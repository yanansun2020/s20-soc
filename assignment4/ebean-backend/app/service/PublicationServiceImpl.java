package service;

import models.PaperAbstracts;
import models.PubAbs;
import mysql.JdbcExecute;

import java.sql.SQLException;
import java.util.List;

public class PublicationServiceImpl implements PublicationService{
    public void addAbstract(List<PaperAbstracts> paperAbstracts) throws SQLException, ClassNotFoundException {
        JdbcExecute jdbcExecute = new JdbcExecute();
        for(PaperAbstracts paperAbstracts1: paperAbstracts){
            String title = paperAbstracts1.getTitle();
            Long pubId = jdbcExecute.queryPubIdByTitle(title);
            if(pubId == null){
                continue;
            }
            PubAbs pubAbs = new PubAbs();
            pubAbs.setPubId(pubId);
            pubAbs.setAbstracts(paperAbstracts1.getAbstracts());
            pubAbs.setTitle(paperAbstracts1.getTitle());
            pubAbs.setEe(paperAbstracts1.getEe());
            jdbcExecute.insert(pubAbs);
            //addAbstractToDB(pubAbs);
        }
    }
}
