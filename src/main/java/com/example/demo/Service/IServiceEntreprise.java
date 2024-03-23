package com.example.demo.Service;

import com.example.demo.entities.Entreprise;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface IServiceEntreprise {
    void addEntreprise(Entreprise entreprise)throws SQLException;
    ObservableList<Entreprise> getAllEntreprises() throws SQLException;

    void updateEntreprise(Entreprise entreprise) throws  SQLException;
    void deleteEntreprise(long id )throws  SQLException;
}
