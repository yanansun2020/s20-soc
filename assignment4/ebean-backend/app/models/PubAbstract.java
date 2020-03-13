package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="pub_abstract")
public class PubAbstract extends Model {
    @Id
    private Long id;
    @Column(name="abs")
    private String abs;
    @Column(name="title")
    private String title;
    @Column(name="ee")
    private String ee;
    @Column(name="pub_id")
    private Long pubId;
    public static Find<String, PubAbstract> findPublications = new Find<String, PubAbstract>(){};

    public static List<PubAbstract> getAbstractsByIds(List<Long> pubIds){
        return findPublications
                .where()
                .in("pubId", pubIds)
                .findList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public Long getPubId() {
        return pubId;
    }

    public void setPubId(Long pubId) {
        this.pubId = pubId;
    }
}
