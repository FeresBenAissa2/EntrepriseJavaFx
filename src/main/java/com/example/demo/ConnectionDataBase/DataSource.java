package com.example.demo.ConnectionDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private  String url="jdbc:mysql://localhost:3306/entreprisedb";
    private  String user="root";
    private  String password="root";

    private static DataSource data;

    private Connection con;

    private DataSource() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("cnx etablie");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getInstance() {
        if (data == null) {
            data = new DataSource();
        }
        return data;
    }
    public Connection getConnection() {
        return con;
    }
}
//test