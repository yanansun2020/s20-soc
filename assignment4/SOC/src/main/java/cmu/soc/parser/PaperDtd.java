package cmu.soc.parser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaperDtd {
    private Long id;
    private String author;
    private String title;
    private String pages;
    private String year;
    private String crossref;
    private String ee;
    private String url;
    private String booktitle;
    private String isbn;
    private String publisher;
    private String editor;
    private String volume;
    private String number;
    private String journal;
    private String series;
    private PaperDtdAttribute paperDtdAttribute;
}
