package fakhredinne.puissanceapp;

import fakhredinne.puissanceapp.Controlleur.Controlleur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AppPuissance extends Application {
    Controlleur  control=new Controlleur();

    public AppPuissance() throws SQLException, ClassNotFoundException {

    }

    @Override
    public void start(Stage stage) {

      control.gameControlleur();
      Scene scene= new Scene(control.getBp(),840,680);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String [] args){
        launch();
    }

}
