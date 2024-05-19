package fakhredinne.puissanceapp.Controlleur;


import fakhredinne.puissanceapp.Model.*;
import fakhredinne.puissanceapp.Model.DAO.DAOPartie;
import fakhredinne.puissanceapp.Vue.InterfaceJeuPuissance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controlleur {
    private BorderPane bp = new BorderPane();
    List<Coup> listCoupJ1=new ArrayList<>();
    List<Coup> listCoupJ2=new ArrayList<>();
    private InterfaceJeuPuissance ijp = new InterfaceJeuPuissance();
    private GestionJoueur bd=new GestionJoueur();
    private List<Joueur> list=bd.getList();
    private Joueur jCourant;
    MenuBar menubar=ijp.getTop();
    private ModelJeuPuissance mjp;

    public Controlleur() throws SQLException, ClassNotFoundException {
    }

    public void gameControlleur(){
        bp.setTop(ijp.getTop());
        bp.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 230), CornerRadii.EMPTY, Insets.EMPTY)));
        MenuItem maxJoueur=ijp.getMenuMaxJ();
        MenuItem MenuList=ijp.getMenuListJ();
        MenuItem MenuLancer=ijp.getLancer();
        MenuItem menuLP=ijp.getMenuLP();
        menuLP.setOnAction(event->{
            bp.setLeft(null);
            bp.setRight(null);
            final ObservableList<Partie> data;
            try {
                data = FXCollections.observableArrayList(new DAOPartie().findAll());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            bp.setCenter(ijp.getListPartie(data));
        });
        MenuLancer.setOnAction(event-> {
            try {
                launchGame();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        MenuList.setOnAction(event->{
                    bp.setLeft(null);
                    bp.setRight(null);
                    final ObservableList<Joueur> data = FXCollections.observableArrayList(list);
                    bp.setCenter(ijp.getListJoueur(data));}
                );
        maxJoueur.setOnAction(event->{
            bp.setLeft(null);
            bp.setRight(null);
            Joueur j=list.stream().max(Comparator.comparing(Joueur::getScore)).get();
            ArrayList<Joueur>maxj=new ArrayList<>();
            maxj.add(j);
            final ObservableList<Joueur> data = FXCollections.observableArrayList(maxj);
            bp.setCenter(ijp.getListJoueur(data));
        });


    }
    //implement DAO and understand the specifications ,then understand how
    public  void convertPtoF(Partie partie)throws IOException {
        String fileName= (partie.getIdP()+".txt");
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(partie);
        oos.close();
    }

    private void launchGame() throws SQLException, ClassNotFoundException {
        if(list.size()<2){
            bp.setCenter(ijp.getCenter("Il faut au moins 2 joueurs"));
            return;
        }else {
            mjp=new ModelJeuPuissance(list.get(0),list.get(1));
        }

        ijp.dessiner();
        bp.setCenter(ijp.getGrilleJeu());
        bp.setLeft(ijp.getLeft(mjp.getInfoJ1()));
        bp.setRight(ijp.getRight(mjp.getInfoJ2()));
        this.jCourant=mjp.getJ1();
        gestionAction();
    }
    public void gestionAction() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Button b = ijp.getTabB()[i][j];
                final int jj = j;
                b.setOnAction(
                        event -> {
                            try {
                                traiterClick(jj);
                            } catch (CoupException | SQLException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
        }
    }

   public void traiterClick(int col) throws CoupException, SQLException, ClassNotFoundException {
        int ligne=mjp.getPuissance().getLigneVideByColonne(col);
        mjp.getPartie().getPuissance().setCoup(ligne,col, jCourant.getId());
        Coup c=new Coup();
        c.setCoupJ2(col);
        listCoupJ1.add(c);
        ijp.setCoupJ2(listCoupJ1);
        boolean winCheck=mjp.getPartie().getPuissance().estGagnant(ligne,col, jCourant.getId());
        boolean draw=mjp.getPartie().getPuissance().estRemplie();
        if(draw){
            bp.setCenter(ijp.getCenter(" Draw!"));
            mjp.getPartie().setWinner(null);
            mjp.createPartie();
            mjp.getPartie().getPuissance().clean_grille();

        }
        if(winCheck){
            bp.setCenter(ijp.getCenter(jCourant.getNom()+" win!"));
            jCourant.incrementerScore();
            bd.update(jCourant);
            mjp.getPartie().getPuissance().clean_grille();
            mjp.getPartie().setWinner(jCourant);
            mjp.createPartie();
        }
        if(jCourant==mjp.getJ1()){
            ijp.setCouleurButton(ligne,col,"yellow");
            jCourant=mjp.getJ2();
        }else{
            ijp.setCouleurButton(ligne,col,"red");
            jCourant=mjp.getJ1();

        }


   }
    public BorderPane getBp() {
        return bp;
    }



}
