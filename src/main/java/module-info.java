module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo to javafx.fxml;
    opens com.example.demo.entities to javafx.base;
    exports com.example.demo;
}