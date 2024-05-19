package fakhredinne.puissanceapp.Vue;

import fakhredinne.puissanceapp.Model.Coup;
import fakhredinne.puissanceapp.Model.Joueur;
import fakhredinne.puissanceapp.Model.Partie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

public class InterfaceJeuPuissance {
    private  MenuItem menuLP;
    private  MenuItem menuMaxJ;
    private  MenuItem menuListJ;
    private MenuItem Lancer;
    private GridPane grilleJeu=new GridPane();
    private Button [][]tabB=new Button [6][7];
    TableView <Coup> tableViewj1,tableViewj2;

    public void setExpression(int ii){
        System.out.println("it work");
    }


    public void dessiner(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <7; j++) {
                grilleJeu.setHgap(15);
                grilleJeu.setVgap(40);
                Button btn=new Button("");
                DropShadow shadow = new DropShadow();
                shadow.setRadius(5.0); // Adjusts the blur radius of the shadow
                shadow.setOffsetX(1.0); // Moves the shadow horizontally by 2 pixels
                shadow.setOffsetY(2.0); // Moves the shadow vertically by 2 pixels
                shadow.setColor(Color.WHITE); // Sets the shadow color

// Apply the DropShadow effect to the button
                btn.setEffect(shadow);
                btn.setStyle(
                        "-fx-background-radius: 150em;"
                        + "-fx-min-width: 50px;"
                        + "-fx-min-height: 50px;"
                        + "-fx-max-width: 50px;"
                        + "-fx-max-height: 50px;"
                );
                grilleJeu.add(btn,j,i);
                tabB[i][j]=btn;
            }


        }
    }
    public GridPane getTop(String info){
        GridPane grilleJeu=new GridPane();
        Label label =new Label();
        label.setText(info);
        return grilleJeu;
    }
    public GridPane getLeft(String info){
        GridPane grilleJeu2=new GridPane();
        Label lb=new Label(info);
        grilleJeu2.add(lb,1,1);
        lb.setFont(new Font(18)); // Set font size and family
        lb.setTextFill(Color.WHITE); // Set text color
        tableViewj1 =new TableView<Coup>();
        TableColumn<Coup,Integer> coup = new TableColumn("numColonneJ1");
        coup.setCellValueFactory(new PropertyValueFactory<Coup, Integer>("numColonneJ1"));
        tableViewj1.getColumns().addAll(coup);
        grilleJeu2.add(tableViewj1,1,2);
        return grilleJeu2;
    }
    public GridPane getRight(String info){
        GridPane grilleJeu2=new GridPane();
        Label lb=new Label(info);
        grilleJeu2.add(lb,1,1);
        lb.setFont(new Font(18)); // Set font size and family
        lb.setTextFill(Color.WHITE); // Set text color
        tableViewj2 =new TableView<Coup>();
        TableColumn<Coup,Integer> coup = new TableColumn("numColonneJ2");
        coup.setCellValueFactory(new PropertyValueFactory<Coup, Integer>("numColonneJ2"));
        tableViewj2.getColumns().addAll(coup);
        grilleJeu2.add(tableViewj2,1,2);
        return grilleJeu2;
    }
    public void setCoupJ1(List<Coup> coup){

        ObservableList<Coup> list=FXCollections.observableArrayList(coup);
        tableViewj1.setItems(list);
    }
    public void setCoupJ2(List<Coup> coup){
        ObservableList<Coup> list=FXCollections.observableArrayList(coup);
        tableViewj2.setItems(list);
    }
    public GridPane getCenter(String info){
        GridPane grilleJeu2=new GridPane();
        Label lb=new Label(info);
        grilleJeu2.add(lb,50,50);
        lb.setFont(new Font(18)); // Set font size and family
        lb.setTextFill(Color.WHITE); // Set text color
        return grilleJeu2;
    }
    public void setCouleurButton(int lig,int col,String color){
        tabB[5-lig][col].setStyle(
                "-fx-background-radius: 150em;"
                        + "-fx-min-width: 50px;"
                        + "-fx-min-height: 50px;"
                        + "-fx-max-width: 50px;"
                        + "-fx-max-height: 50px;"+
                "-fx-background-color:"+color+";");
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
    public MenuBar getTop(){
         MenuBar mb=new MenuBar();
         Menu menuP=new Menu("Partie");
         Menu menuJ=new Menu("Joueur");
         MenuItem menuExpo=new MenuItem("Exporter Partie");
         MenuItem menuImpor=new MenuItem("Importer Partie");
         menuListJ=new MenuItem("Liste Joueur");
         menuMaxJ=new MenuItem("Max Joueur");
         Lancer=new MenuItem("Lancer Partie");
         menuLP=new MenuItem("Liste Partie");
         mb.getMenus().addAll(menuP,menuJ);
         menuJ.getItems().addAll(menuListJ,menuMaxJ);
         menuP.getItems().addAll(Lancer,menuExpo,menuImpor,menuLP);

        return mb;

    }

    public MenuItem getMenuMaxJ() {
        return menuMaxJ;
    }

    public MenuItem getMenuListJ() {
        return menuListJ;
    }

    public MenuItem getLancer() {
        return Lancer;
    }

    public MenuItem getMenuLP() {return menuLP;}

    public void menuCommunication(){


    }
    public TableView getListJoueur(ObservableList<Joueur>list){

        TableView <Joueur> tableView =new TableView<Joueur>();
        TableColumn<Joueur,Integer> id = new TableColumn("id");
        TableColumn <Joueur,String>nom = new TableColumn("nom");
        TableColumn <Joueur,Integer>score = new TableColumn("score");
        id.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        score.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("score"));
        tableView.getColumns().addAll(id, nom, score);

        tableView.setItems(list);

        return tableView;
    }
    public TableView getListPartie(ObservableList<Partie>list){
        TableView <Partie> tableView =new TableView<Partie>();
        TableColumn <Partie,Integer>j1 = new TableColumn("joueur1");
        TableColumn <Partie,Integer>j2 = new TableColumn("joueur2");
        TableColumn <Partie,Integer>winner = new TableColumn("winner");
        j1.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("j1"));
        j2.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("j2"));
        winner.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("winner"));
        tableView.getColumns().addAll( j1, j2, winner);

        tableView.setItems(list);

        return tableView;
    }

}

