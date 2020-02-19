package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pub_author")
public class PubAuthor extends Model {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Constraints.Required
    @Column(name="pub_id")
    public Long pubId;

    @Constraints.Required
    @Column(name="author_id")
    public Long authorId;

    public static Find<Long, PubAuthor> findById = new Find<Long, PubAuthor>(){};

    public static List<PubAuthor> getPubAuthors(List<Long> authorIds) {
        return PubAuthor.findById
                .where()
                .in("authorId", authorIds)
                .findList();
    }

    public static List<PubAuthor> getByPub(List<Long> pubIds) {
        return PubAuthor.findById
                .where()
                .in("pubId", pubIds)
                .findList();
    }

    public static List<PubAuthor> getPubAuthorsById(Long authorId) {
        return PubAuthor.findById
                .where()
                .eq("authorId", authorId)
                .findList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPubId() {
        return pubId;
    }

    public void setPubId(Long pubId) {
        this.pubId = pubId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
