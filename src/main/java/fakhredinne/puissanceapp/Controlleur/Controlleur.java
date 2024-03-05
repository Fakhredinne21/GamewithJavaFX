package fakhredinne.puissanceapp.Controlleur;


import fakhredinne.puissanceapp.Model.*;
import fakhredinne.puissanceapp.Vue.InterfaceJeuPuissance;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

public class Controlleur {
    private BorderPane bp = new BorderPane();
    private InterfaceJeuPuissance ijp = new InterfaceJeuPuissance();
    private GestionJoueur bd=new GestionJoueur();
    private List<Joueur> list=bd.getList();
    private Joueur jCourant;

    private ModelJeuPuissance mjp=new ModelJeuPuissance(list.get(0),list.get(1));
    public void gameControlleur(){
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
                            } catch (CoupException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
        }
    }
   public void traiterClick(int col) throws CoupException {
        int ligne=mjp.getPuissance().getLigneVideByColonne(col);
        mjp.getPartie().getPuissance().setCoup(ligne,col, jCourant.getId());
        boolean winCheck=mjp.getPartie().getPuissance().estGagnant(ligne,col, jCourant.getId());
        boolean draw=mjp.getPartie().getPuissance().estRemplie();
        if(draw){
            bp.setTop(ijp.getTop(" Draw!"));
        }
        if(winCheck){
            bp.setTop(ijp.getTop(jCourant.getNom()+" win!"));
            jCourant.incrementerScore();
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
