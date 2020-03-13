package service;

import models.PaperAbstracts;

import java.sql.SQLException;
import java.util.List;

public interface PublicationService {
    void addAbstract(List<PaperAbstracts> paperAbstracts) throws SQLException, ClassNotFoundException;
}
