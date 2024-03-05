package fakhredinne.puissanceapp.Vue;

import fakhredinne.puissanceapp.Model.Joueur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class InterfaceJeuPuissance {
    private GridPane grilleJeu=new GridPane();
    private Button [][]tabB=new Button [6][7];

    public void setExpression(int ii){
        System.out.println("it work");
    }


    public void dessiner(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <7; j++) {
                grilleJeu.setHgap(15);
                grilleJeu.setVgap(40);
                Button btn=new Button("");
                grilleJeu.add(btn,j,i);
                tabB[i][j]=btn;
            }


        }
    }
    public GridPane getTop(String info){
        GridPane grilleJeu=new GridPane();
        Label label =new Label();
        label.setText(info);
        grilleJeu.add(label,5,1);
        return grilleJeu;
    }
    public GridPane getLeft(String info){
        GridPane grilleJeu2=new GridPane();
        Label lb=new Label(info);
        grilleJeu2.add(lb,1,1);
        return grilleJeu2;
    }
    public GridPane getRight(String info){
        GridPane grilleJeu2=new GridPane();
        Label lb=new Label(info);
        grilleJeu2.add(lb,1,1);
        return grilleJeu2;
    }
    public void setCouleurButton(int lig,int col,String color){
        tabB[5-lig][col].setStyle("-fx-background-color:"+color+";");
    }

    public GridPane getGrilleJeu() {
        return grilleJeu;
    }

    public void setGrilleJeu(GridPane grilleJeu) {
        this.grilleJeu = grilleJeu;
    }

    public Button[][] getTabB() {
        return tabB;
    }

    public void setTabB(Button[][] tabB) {
        this.tabB = tabB;
    }

}
