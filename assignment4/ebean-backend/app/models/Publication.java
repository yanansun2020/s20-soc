package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="publication")
public class Publication extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    public Long id;
    @Column(name="title")
    private String title;
    @Column(name="channel")
    private String channel;
    @Column(name="year")
    private String year;
    @Column(name="pages")
    private String pages;
    @Column(name="cross_ref")
    private String crossRef;
    @Column(name="ee")
    private String ee;
    @Column(name="url")
    private String url;
    @Column(name="book_title")
    private String bookTitle;
    @Column(name="isbn")
    private String isbn;
    @Column(name="publisher")
    private String publisher;
    @Column(name="editor")
    private String editor;
    @Column(name="volume")
    private String volume;
    @Column(name="number")
    private String number;
    @Column(name="journal")
    private String journal;
    @Column(name="series")
    private String series;
    @Column(name="key")
    private String keyWord;
    @Column(name="mdate")
    private String mdate;

    public static Find<String, Publication> findPublications = new Find<String, Publication>(){};
    public static Find<String, Publication> findByColume = new Find<String, Publication>(){};
    public static Publication getPublicationByTitle(String title) {
        return Publication.findPublications
                .where()
                .eq("title", title)
                .findUnique();
    }

    public static List<Publication> getByNameVolumeNumber(String journal, String volume, String number){
        return Publication.findPublications
                .where()
                .eq("journal",journal)
                .eq("volume", volume)
                .eq("number", number)
                .findList();
    }


    public static List<Publication> getByIds(List<Long> ids){
        return Publication.findPublications
                .where()
                .in("id", ids)
                .findList();
    }

    public static List<Publication> getAllArticleTitles(){
        return Publication.findPublications.all();
    }

    public static List<Publication> getResearAndYeaer(String researcher, String year){
        List<Author> authorList = Author.findByName(researcher);
        if(authorList == null || authorList.size() == 0){
            return new ArrayList<>();
        }
        Long authorId = authorList.get(0).getId();
        List<Long> authorIds = new ArrayList<>();
        authorIds.add(authorId);
        List<PubAuthor> pubAuthors = PubAuthor.getPubAuthors(authorIds);
        List<Long> pubIds = pubAuthors.stream().map(PubAuthor::getPubId).collect(Collectors.toList());
        return Publication.findPublications
                .where()
                .in("id", pubIds)
                .eq("year", year)
                .findList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getCrossRef() {
        return crossRef;
    }

    public void setCrossRef(String crossRef) {
        this.crossRef = crossRef;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }
}
