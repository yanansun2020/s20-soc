package cmu.soc.lucene;

import cmu.soc.dao.entity.Publication;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LucenceService {
    public static final int HITS_MAX_PAGE = 4180;
    //public static final String F_DOCUMENTS_A_CMU_TMP_INDEX_LUCENE = System.getenv("java.io.tmpdir" + "lucene.index");
    public static final String F_DOCUMENTS_A_CMU_TMP_INDEX_LUCENE = "F:\\Documents\\a-cmu\\tmp\\lucene.index";
    private static StandardAnalyzer analyzer = new StandardAnalyzer();
    private static FSDirectory index;

    //private static Directory index = new FilterDirectory();
    public static void main(String[] args) throws IOException, ParseException {
        // 0. Specify the analyzer for tokenizing text.
        // The same analyzer should be used for indexing and searchingPublicationService
        StandardAnalyzer analyzer = new StandardAnalyzer();

        // 1. create the index
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);
        addDocTest(w, "Lucene in Action", "Yanan Sun", "Yanan Sun");
        addDocTest(w, "Lucene for Dummies", "Liang Hao", "Liang Hao");
        addDocTest(w, "Managing Gigabytes", "Yu Jia", "Yu Jia");
        addDocTest(w, "The Art of Computer Science", "Mi Xiao", "Mi Xiao");

        w.close();

        // 2. query
        String querystr = args.length > 0 ? args[0] : "lucene Yu";
        // the "title" arg specifies the default field to use
        // when no field is explicitly specified in the query.
       // Query q = new QueryParser("title", analyzer).parse(querystr);
        QueryParser queryParser2 = new MultiFieldQueryParser(new String[]{"title","author"},analyzer);
        Query query = queryParser2.parse(querystr);
        // 3. search
        int hitsPerPage = 10;
        int totalThresHold = 1000;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, totalThresHold);
        searcher.search(query, collector);
        ScoreDoc[] hits = collector.topDocs(0).scoreDocs;
        // 4. display results
        System.out.println("Found " + hits.length + " hits. in q1 for title");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title") + "\t" + d.get("author"));
        }
        reader.close();
    }

    public Integer buildIndex(List<Publication> allPublications) {
        if (allPublications == null || allPublications.isEmpty()) {
            return -1;
        }
        // 1. create the index

        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        try {
            index = FSDirectory.open(Paths.get(F_DOCUMENTS_A_CMU_TMP_INDEX_LUCENE));
            IndexWriter indexWriter = new IndexWriter(index, config);
            for (Publication publication : allPublications) {
                addDoc(indexWriter, publication.getTitle(), publication.getAuthor(), publication.getId());
            }
            indexWriter.close();
            return 1;
        } catch (IOException e) {
            return 0;
        }
    }

    public List<Publication> basicSearch(String keyword, int numResultsToSkip, int numResultsToReturn) {
        // when no field is explicitly specified in the query.
        IndexReader reader = null;
        try {
            QueryParser queryParser2 = new MultiFieldQueryParser(new String[]{"title","author"},analyzer);
            Query query = queryParser2.parse(keyword);
            // 3. search
            int hitsPerPage = numResultsToReturn;
            //the total publication
            int totalThresHold = HITS_MAX_PAGE;
            index = FSDirectory.open(Paths.get(F_DOCUMENTS_A_CMU_TMP_INDEX_LUCENE));
            reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, totalThresHold);
            searcher.search(query, collector);
            ScoreDoc[] titleHits = collector.topDocs(numResultsToSkip).scoreDocs;
            List<Publication> result = buildSearchResulrByHits(titleHits, searcher);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Publication> buildSearchResulrByHits(ScoreDoc[] titleHits, IndexSearcher indexSearcher) throws IOException {
        List<Publication> publications = new ArrayList<>();
        buildResultByhits(titleHits, publications, indexSearcher);
        return publications;

    }

    private void buildResultByhits(ScoreDoc[] hits, List<Publication> publications, IndexSearcher indexSearcher) throws IOException {
        for (ScoreDoc scoreDoc : hits) {
            int docId = scoreDoc.doc;
            Document doc = indexSearcher.doc(docId);
            Publication publication = new Publication();
            publication.setTitle(doc.get("title"));
            publication.setAuthor(doc.get("author"));
            publications.add(publication);
        }
    }

    private static void addDoc(IndexWriter writer, String title, String author, Long id) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));

        doc.add(new TextField("author", author, Field.Store.YES));
        doc.add(new TextField("id", id+"", Field.Store.YES));

        // use a string field for isbn because we don't want it tokenized
        //doc.add(new StringField("isbn", isbn, Field.Store.YES));
        writer.updateDocument(new Term("id", id+""), doc);
    }

    private static void addDocTest(IndexWriter writer, String title, String author, String name) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));

        doc.add(new TextField("author", author, Field.Store.YES));

        // use a string field for isbn because we don't want it tokenized
        //doc.add(new StringField("isbn", isbn, Field.Store.YES));
        writer.addDocument( doc);
    }

}
