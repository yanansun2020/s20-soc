package models;

import java.util.List;

public class PublicationWrapper extends Publication {
    private List<Author> authors;
    private String abs;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }
}
