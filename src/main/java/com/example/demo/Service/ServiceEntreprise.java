package com.example.demo.Service;

import com.example.demo.ConnectionDataBase.DataSource;
import com.example.demo.entities.Entreprise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class ServiceEntreprise implements IServiceEntreprise {
    Connection conn = DataSource.getInstance().getConnection();
    PreparedStatement preparedStatement = null;

    @Override
    public void addEntreprise(Entreprise entreprise) throws SQLException {
        try {

            preparedStatement = conn.prepareStatement("INSERT INTO `entreprise` (`adresse_entreprise`,`description_entreprise`,`nom_entreprise`,`type_entreprise`) VALUES (?,?,?,?);");
            preparedStatement.setString(1, entreprise.getAdresseEntreprise());
            preparedStatement.setString(2, entreprise.getDescriptionEntreprise());
            preparedStatement.setString(3, entreprise.getNomEntreprise());
            preparedStatement.setString(4, entreprise.getTypeEntreprise());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Entreprise> getAllEntreprises() throws SQLException {
        ObservableList<Entreprise> entreprises = FXCollections.observableArrayList();
        try {
            Statement ste = conn.createStatement();
            String req = "select * from entreprise";
            ResultSet res = ste.executeQuery(req);

            while (res.next()) {

                Entreprise entreprise = new Entreprise(
                        res.getLong("id_entreprise"),
                        res.getString("nom_entreprise"),
                        res.getString("adresse_entreprise"),
                        res.getString("type_entreprise"),
                        res.getString("description_entreprise"),
                        null,
                        null
                );
                entreprises.add(entreprise);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entreprises;
    }

    @Override
    public void updateEntreprise(Entreprise entreprise) throws SQLException {
        System.out.println("Address :" + entreprise.getAdresseEntreprise());
        System.out.println("Desc :" + entreprise.getDescriptionEntreprise());
        System.out.println("Type :" + entreprise.getTypeEntreprise());
        System.out.println("Nom :" + entreprise.getNomEntreprise());
        try {

            preparedStatement = conn.prepareStatement("UPDATE `entreprise` SET `adresse_entreprise`= ? ,`description_entreprise`=? ,`nom_entreprise`=?,`type_entreprise`=? WHERE `id_entreprise` = ?;");
            preparedStatement.setString(1, entreprise.getAdresseEntreprise());
            preparedStatement.setString(2, entreprise.getDescriptionEntreprise());
            preparedStatement.setString(3, entreprise.getNomEntreprise());
            preparedStatement.setString(4, entreprise.getTypeEntreprise());
            preparedStatement.setLong(5, entreprise.getIdEntreprise());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntreprise(long id) throws SQLException {
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM entreprise WHERE id_entreprise = ?;\n");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
