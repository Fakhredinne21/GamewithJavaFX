module fakhredinne.puissanceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens fakhredinne.puissanceapp.Model to javafx.base;
    opens fakhredinne.puissanceapp to javafx.fxml;
    exports fakhredinne.puissanceapp;
    opens fakhredinne.puissanceapp.Model.DAO to javafx.base;
}