package cmu.soc.dao;

import cmu.soc.dao.entity.Author;
import cmu.soc.dao.entity.PubAbs;
import cmu.soc.dao.entity.PubAuthor;
import cmu.soc.dao.entity.Publication;
import cmu.soc.parser.PaperAbstracts;
import cmu.soc.parser.PaperDtd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublicationMapper {
   /* @Insert("INSERT INTO publication (title, channel, year, pages, cross_ref, ee, url, book_title, isbn, publisher, editor, volume, number, journal, series, key, mdate) VALUES " +
            "(#{title}, #{channel}, #{year}, #{pages}, #{crossref}, #{ee}, #{url}, #{booktitle}, #{isbn}, #{publisher}, #{editor}, #{number}, #{journal}, #{series}, #{key}, #{mdate})")
    */
   Long addPublication(@Param("paperDtd") PaperDtd paperDtd);

    /*@Insert("insert into author(name) values (#{name})")*/
    Long addAuthor(@Param("author") Author author);

    /*@Insert("insert into pub_author(pub_id, author_id) values(#{pubId}, #{authorId})")*/
    Long addPubAuthor(@Param("pubAuthor") PubAuthor pubAuthor);

    List<Publication> getPubsByTitle(@Param("pub")Publication publication);

    Author getOneAuthorByName(@Param("name")String name);

    List<Author> getCoAuthors(@Param("name")String name);

    List<Publication> getAuthorsByPbIds(@Param("paperIds")List<Long> paperIds);

    Long addAbstract(@Param("pubAbs") PubAbs pubAbs);

   PubAbs getAbstract(@Param("title") String title);

   Publication getPubByTitle(@Param("pub")Publication publication);
}
