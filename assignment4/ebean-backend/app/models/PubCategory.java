package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="pub_abstract")
public class PubCategory extends Model {
    @Column(name="id")
    private Long id;
    @Column(name="pub_id")
    private Long pubId;
    @Column(name="category1")
    private String category1;
    @Column(name="category2")
    private String category2;
    @Column(name="category3")
    private String category3;
    @Column(name="category4")
    private String category4;
    @Column(name="category5")
    private String category5;
    @Column(name="category6")
    private String category6;
    @Column(name="category7")
    private String category7;
    @Column(name="category8")
    private String category8;
    @Column(name="category9")
    private String category9;
    @Column(name="category10")
    private String category10;

    @Column(name="max_rate")
    private String maxRate;
    @Column(name="max_index")
    private int maxIndex;

    private int count;
    public static Find<Long, PubCategory> findCategory = new Find<Long, PubCategory>(){};
    public static List<PubCategory> aggregateByIndex(){
        Query<PubCategory> query = Ebean.find(PubCategory.class);
        String sql = "SELECT COUNT(*), max_index FROM pub_category GROUP BY max_index ORDER BY max_index";
        RawSql rawSql = RawSqlBuilder.parse(sql).columnMapping("COUNT(*)", "count")
        .columnMapping("max_index", "maxIndex").create();
        query.setRawSql(rawSql);
        List<PubCategory> list = query.findList();
        return list;
    }

    public static List<Long> getPubIds(Integer maxIndex){
        Query<Long> query = Ebean.find(Long.class);
        String sql = "SELECT pub_id from pub_category where max_index =" + maxIndex;
        RawSql rawSql = RawSqlBuilder.parse(sql).create();
        query.setRawSql(rawSql);
        return query.findList();
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

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getCategory4() {
        return category4;
    }

    public void setCategory4(String category4) {
        this.category4 = category4;
    }

    public String getCategory5() {
        return category5;
    }

    public void setCategory5(String category5) {
        this.category5 = category5;
    }

    public String getCategory6() {
        return category6;
    }

    public void setCategory6(String category6) {
        this.category6 = category6;
    }

    public String getCategory7() {
        return category7;
    }

    public void setCategory7(String category7) {
        this.category7 = category7;
    }

    public String getCategory8() {
        return category8;
    }

    public void setCategory8(String category8) {
        this.category8 = category8;
    }

    public String getCategory9() {
        return category9;
    }

    public void setCategory9(String category9) {
        this.category9 = category9;
    }

    public String getCategory10() {
        return category10;
    }

    public void setCategory10(String category10) {
        this.category10 = category10;
    }

    public String getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(String maxRate) {
        this.maxRate = maxRate;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
