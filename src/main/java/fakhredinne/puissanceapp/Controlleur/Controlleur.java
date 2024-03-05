package Controlleur;

import Vue.InterfaceJeuPuissance;
import javafx.scene.layout.BorderPane;

public class Controlleur {
    private BorderPane bd = new BorderPane();
    private InterfaceJeuPuissance ijp = new InterfaceJeuPuissance();
    public void gameControlleur(){

    }

    public BorderPane getBd() {
        return bd;
    }

    public void setBd(BorderPane bd) {
        this.bd = bd;
    }

}
