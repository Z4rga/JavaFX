package tn.esprit.application.services;

import java.sql.SQLException;  // Import SQLException from java.sql package
import java.util.List;

public interface ServiceInterface<T> {
    void ajouter(T t) throws SQLException;
    void modifier(T t) throws SQLException;
    void supprimer(int id) throws SQLException;
    T recuperer(int id) throws SQLException;
    List<T> recupererall() throws SQLException;
}
