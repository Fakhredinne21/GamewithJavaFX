package fakhredinne.puissanceapp.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Partie {
	private int idP;
	private Joueur j1;
	private Joueur j2;
	private Joueur winner;

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	private ArrayList<Coup> lisCoupJ = new ArrayList();
	private int nbJetonJ1 = 21;
	private int nbJetonJ2 = 21;
	private int scorej1, scorej2;
	private int rolejoueur;
	private Game game;

	public Partie() throws SQLException, ClassNotFoundException {
		GestionJoueur gestionJoueur = new GestionJoueur();
		List<Joueur> listeJoueur = gestionJoueur.getList();
		j1 = listeJoueur.get(1);
		j2 = listeJoueur.get(2);
		this.rolejoueur = j1.getId();
		game = new Game(j1.getId(), j2.getId());
	}

	public Partie(Joueur j1, Joueur j2) {
		this.j1 = j1;
		this.j2 = j2;
		this.rolejoueur = j1.getId();
		game = new Game(j1.getId(), j2.getId());
	}

	public Partie(Joueur j1, Joueur j2, Joueur winner) {
		this.j1 = j1;
		this.j2 = j2;
		this.winner = winner;
	}

	public Partie(int id, int joueur1, int joueur2, int scorej1, int scorej2) {
	}

	public Partie(int id, String nom, int score) {
	}


	public void insertCoup(int jj) {
		if (this.rolejoueur == this.j1.getId()) {
			Coup c=new Coup(jj);
			this.lisCoupJ.add(c);
			nbJetonJ1--;
		} else {
			int derniercoup=this.lisCoupJ.size()-1;
			Coup c=this.lisCoupJ.get(derniercoup);
			c.setCoupJ2(jj);
			nbJetonJ1--;
		}
	}



	public int getScoreJ2() {
		return scorej2;
	}

	public void setScoreJ2(int scorej2) {
		this.scorej2 = scorej2;
	}

	public int getScoreJ1() {
		return scorej1;
	}

	public void setScoreJ1(int scorej1) {
		this.scorej1 = scorej1;
	}
	public int getNbJetonJ1() {
		return nbJetonJ1;
	}

	public void setNbJetonJ1(int nbPionJ1) {
		this.nbJetonJ1 = nbPionJ1;
	}

	public int getNbJetonJ2() {
		return nbJetonJ2;
	}

	public void setNbJetonJ2(int nbPionJ2) {
		this.nbJetonJ2 = nbPionJ2;
	}

	public Game getPuissance() {
		return game;
	}

	public void setPuissance(Game p) {
		this.game = p;
	}

	public Joueur getJ1() {
		return j1;
	}

	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}

	public void setWinner(Joueur jCourant) {
		this.winner = jCourant;
	}

	public Joueur getWinner() {
		return winner;
	}
}
