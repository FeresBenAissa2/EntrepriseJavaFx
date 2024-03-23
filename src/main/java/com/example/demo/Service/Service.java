package com.example.demo.Service;

import com.example.demo.ConnectionDataBase.DataSource;
import com.example.demo.entities.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service implements IService<Employee>{
    private Connection con = DataSource.getInstance().getConnection();
    private Statement stmt;
    public Service() {
        try {
            stmt = con.createStatement();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @Override
    public boolean createEmployee(Employee employee) {
        System.out.println(employee.getSalaire() );
        try {
            stmt = con.createStatement();
            String reqEmployee = "insert into employee(matricule,nom,email,anneRecruit,category) values(" +
                    employee.getMatricule() + ",'" +
                    employee.getNom() + "','" +
                    employee.getEmail() + "'," +
                    employee.getAnneRecruit() + ",'" +
                    employee.getCat() + "')";

            if (stmt.executeUpdate(reqEmployee) == 1) {
                String reqSalaire = "Insert into salaire(matricule,salaire,hsupp,phsupp) values (" + employee.getMatricule() + "," + employee.getSalaire() + "," + employee.getHSupp() + "," + employee.getPHsupp() + ");";
                if (stmt.executeUpdate(reqSalaire) == 1) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }




    @Override
    public List<Employee> listerEmployee() {
        List<Employee> emps = new ArrayList<>();
        try {
            stmt = con.createStatement();
            String reqE = "SELECT e.matricule, nom, email, category, anneRecruit, (salaire + HSupp * PHSupp) as salaireTot  from employee e, salaire s where s.matricule = e.Matricule;";

            ResultSet rsE = stmt.executeQuery(reqE);

            while (rsE.next()) {
                Employee employee = new Employee(rsE.getInt(1), rsE.getString(2), rsE.getString(3), rsE.getString(4),
                        rsE.getDouble(5), rsE.getDouble(6));
                emps.add(employee);
            }
            return emps;

        } catch (SQLException ex) {
            System.out.println("Erreur SQL" + ex);
        }
        return null;
    }

    @Override
    public List<Employee> listerAnniceir() {
        List<Employee> emps = new ArrayList<>();
        try {
            String req = "Select e.matricule, nom, email, category, anneRecruit ,s.salaire from employee e INNER JOIN salaire s on e.matricule = s.matricule Order by anneRecruit ASC;";
            stmt = con.createStatement();
            ResultSet rsA = stmt.executeQuery(req);
            while (rsA.next()) {
                emps.add(new Employee(rsA.getInt(1), rsA.getString(2), rsA.getString(3), rsA.getString(4),rsA.getDouble(5),rsA.getDouble(6)));
            }
            return emps;
        }catch(SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
