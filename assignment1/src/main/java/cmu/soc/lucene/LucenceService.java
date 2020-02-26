package cmu.soc.lucene;

import cmu.soc.dao.entity.Publication;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LucenceService {
    private static StandardAnalyzer analyzer = new StandardAnalyzer();
    private Directory index = new RAMDirectory();
    public static void main(String[] args) throws IOException, ParseException {
        // 0. Specify the analyzer for tokenizing text.
        // The same analyzer should be used for indexing and searchingPublicationService
        StandardAnalyzer analyzer = new StandardAnalyzer();

        // 1. create the index
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);
        addDoc(w, "Lucene in Action", "193398817", "Yanan Sun");
        addDoc(w, "Lucene for Dummies", "55320055Z", "Liang Hao");
        addDoc(w, "Managing Gigabytes", "55063554A", "Yu Jia");
        addDoc(w, "The Art of Computer Science", "9900333X", "Mi Xiao");

        w.close();

        // 2. query
        String querystr = args.length > 0 ? args[0] : "lucene Yu";
        // the "title" arg specifies the default field to use
        // when no field is explicitly specified in the query.
        Query q = new QueryParser("title", analyzer).parse(querystr);
        Query q2 = new QueryParser("author", analyzer).parse(querystr);

        // 3. search
        int hitsPerPage = 10;
        int totalThresHold = 1000;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, totalThresHold);
        searcher.search(q, collector);
        TopScoreDocCollector collector2 = TopScoreDocCollector.create(hitsPerPage, totalThresHold);
        searcher.search(q2, collector2);
        ScoreDoc[] hits = collector.topDocs(0).scoreDocs;
        ScoreDoc[] hits2 = collector2.topDocs(0).scoreDocs;
        // 4. display results
        System.out.println("Found " + hits.length + " hits. in q1 for title");
        for(int i=0;i<hits.length;++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title") + "\t" + d.get("author"));
        }

        System.out.println("Found " + hits2.length + " hits. inq2 for author");
        for(int i=0;i<hits2.length;++i) {
            int docId = hits2[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title") + "\t" + d.get("author"));
        }
        // reader can only be closed when there
        // is no need to access the documents any more.
        reader.close();
    }
    public Integer buildIndex( List<Publication> allPublications ){
        if(allPublications == null || allPublications.isEmpty()){
            return -1;
        }
        // 1. create the index

        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        try {
            IndexWriter indexWriter = new IndexWriter(index, config);
            for(Publication publication : allPublications ){
                addDoc(indexWriter, publication.getTitle(), publication.getIsbn(),publication.getAuthor());
            }
            return 1;
        } catch (IOException e) {
           return 0;
        }
    }

    public List<Publication> basicSearch(String keyword, int numResultsToSkip, int numResultsToReturn){
        // when no field is explicitly specified in the query.
        try {
            Query q = new QueryParser("title", analyzer).parse(keyword);
            Query q2 = new QueryParser("author", analyzer).parse(keyword);
            // 3. search
            int hitsPerPage = numResultsToReturn;
            int totalThresHold = 1000;
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, totalThresHold);
            searcher.search(q, collector);
            TopScoreDocCollector collector2 = TopScoreDocCollector.create(hitsPerPage, totalThresHold);
            searcher.search(q2, collector2);
            ScoreDoc[] titleHits = collector.topDocs(numResultsToSkip).scoreDocs;
            ScoreDoc[] authorHits = collector2.topDocs(numResultsToSkip).scoreDocs;
            return buildSearchResulrByHits(titleHits, authorHits, searcher);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Publication> buildSearchResulrByHits(ScoreDoc[] titleHits, ScoreDoc[] authorHits, IndexSearcher indexSearcher) throws IOException {
        List<Publication> publications = new ArrayList<>();
        buildResultByhits(titleHits, publications, indexSearcher);
        buildResultByhits(authorHits, publications, indexSearcher);
        return publications;

    }
    private void buildResultByhits(ScoreDoc[] hits,  List<Publication> publications, IndexSearcher indexSearcher) throws IOException {
        for (ScoreDoc scoreDoc : hits) {
            int docId = scoreDoc.doc;
            Document doc = indexSearcher.doc(docId);
            Publication publication = new Publication();
            publication.setTitle(doc.get("title"));
            publication.setAuthor(doc.get("author"));
            publications.add(publication);
        }
    }

    private static void addDoc (IndexWriter w, String title, String isbn, String author) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));

        doc.add(new TextField("author", author, Field.Store.YES));
        // use a string field for isbn because we don't want it tokenized
        doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }

}
