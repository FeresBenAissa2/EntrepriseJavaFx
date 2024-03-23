package com.example.demo.Service;

import com.example.demo.ConnectionDataBase.DataSource;
import com.example.demo.entities.Vendeur;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;


public class ServiceVendeur implements IServiceVendeur<Vendeur> {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement stmt;

    public ServiceVendeur() {
        try {
            stmt = con.createStatement();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public boolean createVendeur(Vendeur vd) {
       // System.out.println(vd.getSalaire());
        try {
            stmt = con.createStatement();
            String reqEmployee = "insert into employee(matricule,nom,email,anneRecruit,category) values(" +
                    vd.getMatricule() + ",'" +
                    vd.getNom() + "','" +
                    vd.getEmail() + "'," +
                    vd.getAnneRecruit() + ",'" +
                    vd.getCat() + "')";


            if (stmt.executeUpdate(reqEmployee) == 1) {
                String reqSalaire = "Insert into Vendeur(matricule,Vente,Pourcentage) values (" + vd.getMatricule() + "," + 10.0 + "," + 14.5 + ");";
                if (stmt.executeUpdate(reqSalaire) == 1) {
                    return true;
                }


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}