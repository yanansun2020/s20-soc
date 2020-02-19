package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="author")
public class Author extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    public Long id;

    @Constraints.Required
    @Column(name="name")
    public String name;

    public static Find<String, Author> findByName = new Find<String, Author>(){};
    public static Find<Long, Author> findById = new Find<Long, Author>(){};

    /**
     * get authors
     * @param name
     * @return
     */
    public static List<Author> findByName(String name) {
        return Author.findByName
                .where()
                .eq("name", name)
                .findList();
    }

    public static List<Author> findByIds(List<Long> authorIds) {
        return Author.findByName
                .where()
                .in("id", authorIds)
                .findList();
    }

    public static List<Author> findAll() {
        return Author.findById.all();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
