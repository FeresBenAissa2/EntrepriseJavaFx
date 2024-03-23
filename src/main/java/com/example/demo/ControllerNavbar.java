package com.example.demo;
import java.util.Objects;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
public class ControllerNavbar implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private BorderPane bp;

    @FXML
    private Text title;

    @FXML
    private void home(MouseEvent event) {
        bp.setCenter(title);
    }

    @FXML
    private void page1(MouseEvent event) {
        loadPage("ManageEntreprise");
    }

    @FXML
    private void page2(MouseEvent event) {
        loadPage("AddSalaire");
    }




    private void loadPage(String page) {
        Parent root=null;

        try {
            root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        bp.setCenter(root);
    }
}
