package com.example.demo;

import com.example.demo.Service.ServiceEntreprise;
import com.example.demo.entities.Entreprise;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EntrepriseController implements Initializable {
    public TextField entreprise_nom_fid;
    public Text errorNom;
    public TextField entreprise_address_fid;
    public Text errorAddress;
    public TextField entreprise_type_fid;
    public Text errorType;
    public TextField entreprise_description_fid;
    public Text errorDescription;
    public Button save_btn_fid;
    public Button update_btn_fid;
    public Button delete_btn_fid;
    public TableView<Entreprise> local_table_view_fid;
    public TableColumn<Entreprise, Long> column_entreprise_id_fid;
    public TableColumn<Entreprise, String> column_entreprise_nom_fid;
    public TableColumn<Entreprise, String> column_entreprise_type_fid;
    public TableColumn<Entreprise, String> column_entreprise_desciption_fid;
    public TableColumn<Entreprise, String> column_entreprise_address_fid;
    ServiceEntreprise serviceEntreprise = new ServiceEntreprise();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        save_btn_fid.setOnAction(event -> addNewEntreprise());
        update_btn_fid.setOnAction(event -> updateEntreprise());
        delete_btn_fid.setOnAction(event -> deleteEntreprise());
        initTable();
        refreshTable();
    }

    private void initTable() {
        column_entreprise_id_fid.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getIdEntreprise()));
        column_entreprise_nom_fid.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getNomEntreprise()));
        column_entreprise_type_fid.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getTypeEntreprise()));
        column_entreprise_desciption_fid.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getDescriptionEntreprise()));
        column_entreprise_address_fid.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getAdresseEntreprise()));
        // Listen for selection changes and update the input fields
        local_table_view_fid.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updateInputFields(newSelection);
            }
        });
        clearErrorMessages();

    }

    private void updateInputFields(Entreprise selectedEntreprise) {
        entreprise_address_fid.setText(selectedEntreprise.getAdresseEntreprise());
        entreprise_description_fid.setText(selectedEntreprise.getDescriptionEntreprise());
        entreprise_type_fid.setText(selectedEntreprise.getTypeEntreprise());
        entreprise_nom_fid.setText(selectedEntreprise.getNomEntreprise());
    }

    private void refreshTable() {
        try {
            local_table_view_fid.setItems(serviceEntreprise.getAllEntreprises());
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private void clearErrorMessages() {
        errorNom.setText("");
        errorAddress.setText("");
        errorType.setText("");
        errorDescription.setText("");
    }
    private void clearInputFields() {
        entreprise_address_fid.setText("");
        entreprise_description_fid.setText("");
        entreprise_type_fid.setText("");
        entreprise_nom_fid.setText("");
    }


    private void addNewEntreprise() {
        clearErrorMessages(); // Clear previous error messages
        try {
            if (validateInput()) {
            Entreprise entreprise = new Entreprise();
            entreprise.setAdresseEntreprise(entreprise_address_fid.getText());
            entreprise.setDescriptionEntreprise(entreprise_description_fid.getText());
            entreprise.setTypeEntreprise(entreprise_type_fid.getText());
            entreprise.setNomEntreprise(entreprise_nom_fid.getText());
            serviceEntreprise.addEntreprise(entreprise);
            refreshTable();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
//    }
    }

    private void updateEntreprise() {
        Entreprise selectedEntreprise = local_table_view_fid.getSelectionModel().getSelectedItem();
        clearErrorMessages(); // Clear previous error messages
        if (selectedEntreprise != null) {
            try {
                if (validateInput()) {
                // Update the selectedLocal object directly
                selectedEntreprise.setAdresseEntreprise(entreprise_address_fid.getText());
                selectedEntreprise.setDescriptionEntreprise(entreprise_description_fid.getText());
                selectedEntreprise.setTypeEntreprise(entreprise_type_fid.getText());
                selectedEntreprise.setNomEntreprise(entreprise_nom_fid.getText());
                serviceEntreprise.updateEntreprise(selectedEntreprise);
                refreshTable();
                    clearInputFields();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please select a Entreprise to update.");
        }
    }
    private void deleteEntreprise() {
        try {
            Entreprise selectedEntreprise = local_table_view_fid.getSelectionModel().getSelectedItem();
            long id = selectedEntreprise.getIdEntreprise();
            serviceEntreprise.deleteEntreprise(id);
            refreshTable();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    private boolean validateInput() {
        boolean isValid = true;

        if (entreprise_nom_fid.getText().isEmpty()) {
            errorNom.setText("Name cannot be empty.");
            isValid = false;
        }
        if (entreprise_address_fid.getText().isEmpty()) {
            errorAddress.setText("Address cannot be empty.");
            isValid = false;
        }
        if (entreprise_description_fid.getText().isEmpty()) {
            errorDescription.setText("Description cannot be empty.");
            isValid = false;
        }
        if (entreprise_type_fid.getText().isEmpty()) {
            errorType.setText("Type cannot be empty.");
            isValid = false;
        }

        return isValid;
    }
}
