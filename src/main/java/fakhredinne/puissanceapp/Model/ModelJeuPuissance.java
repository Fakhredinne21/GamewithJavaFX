package fakhredinne.puissanceapp.Model;

import fakhredinne.puissanceapp.Model.DAO.DAOPartie;

public class ModelJeuPuissance {

    private Joueur j1;
    private Joueur j2;
    private Game puissance;
    private Partie partie;
    public void createPartie(){
        DAOPartie daoPartie=new DAOPartie();
        try {
            daoPartie.create(partie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Partie getPartie() {
        return partie;
    }

    public ModelJeuPuissance(Joueur j1, Joueur j2) {
        this.j1 = j1;
        this.j2 = j2;
        this.partie=new Partie(j1,j2);
        this.puissance=partie.getPuissance();
    }


    public Game getPuissance() {
        return puissance;
    }

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public String getInfoJ1(){
        return j1.toString();
    }
    public String getInfoJ2(){
        return j2.toString();
    }


}
