package com.example.demo;


import com.example.demo.Service.Service;
import com.example.demo.Service.ServiceVendeur;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Vendeur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SalController implements Initializable {
    @FXML
    private Button btnChek;

    @FXML
    private AnchorPane btnListeTout;

    @FXML
    private TextField Nom;

    @FXML
    private TextField email;

    @FXML
    private TextField recut;

    @FXML
    private TextField salaire;

    @FXML
    private TextField mat;

    @FXML
    private RadioButton btnE;

    @FXML
    private RadioButton BtnV;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnUpdate;
    @FXML
    private Button BtnLister;
    @FXML
    private Button btnMax;

    @FXML
    private Button btnMix;

    @FXML
    private Button BTNDet;

    @FXML
    private Button BtnExport;

    @FXML
    private Button BtnListeAn;

    @FXML
    private TextField first;

    @FXML
    private TextField last;
    @FXML
    private TextArea textArea;

    @FXML
    private Button BtnBetwwen;
    @FXML
    private TextField Hsupp;
    @FXML
    private RadioButton RadioEm;

    @FXML
    private RadioButton RadioVen;
    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, Integer> matColmn;

    @FXML
    private TableColumn<Employee, Integer> nameColmn;

    @FXML
    private TableColumn<Employee, Integer> emailColmn;

    @FXML
    private TableColumn<Employee, Integer> recColmn;

    @FXML
    private TableColumn<Employee, Integer> salColmn;
    @FXML
    private TableColumn<Employee, Integer> roleCol;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        matColmn.setCellValueFactory(new PropertyValueFactory<>("Matricule"));
        nameColmn.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        emailColmn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("Cat"));
        recColmn.setCellValueFactory(new PropertyValueFactory<>("AnneRecruit"));
        salColmn.setCellValueFactory(new PropertyValueFactory<>("Salaire"));
        Service sp = new Service();
        table.getItems().addAll(sp.listerEmployee());
    }
    @FXML
    void Add(ActionEvent event) throws NumberFormatException, IOException {
        if(btnE.isSelected()) {

            Employee emp = new Employee(Integer.parseInt(mat.getText()), Nom.getText(), email.getText(), "E", Double.parseDouble(recut.getText()), 0.1, Double.parseDouble(Hsupp.getText()), 10.0);
            System.out.println(emp.toString());
            Service sp = new Service();
            boolean result = sp.createEmployee(emp);

        }
        if  (BtnV.isSelected()){

            Vendeur v = new Vendeur(Integer.parseInt(mat.getText()), Nom.getText(), email.getText(), "V", Double.parseDouble(recut.getText()), 0.1, Double.parseDouble(Hsupp.getText()), 10.0, 10.2 , 11.5);
            System.out.println(v.toString());
            ServiceVendeur sp = new ServiceVendeur();
            boolean result = sp.createVendeur(v);

        }
        mat.setText("");
        Nom.setText("");
        email.setText("");
        recut.setText("");
        Hsupp.setText("");
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Details(ActionEvent event) {

    }

    @FXML
    void Export(ActionEvent event) {

    }

    @FXML
    void ListAnn(ActionEvent event) {
        Service sp = new Service();
        table.getItems().clear();
        table.getItems().addAll(sp.listerAnniceir());
    }

    @FXML
    void ListerBetw(ActionEvent event) {

    }

    @FXML
    void ListerCat(ActionEvent event) {

    }

    @FXML
    void ListerMax(ActionEvent event) {

    }

    @FXML
    void ListerMin(ActionEvent event) {

    }

    @FXML
    void Quite(ActionEvent event) {

    }
    @FXML
    void ModifCkeck(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
}
