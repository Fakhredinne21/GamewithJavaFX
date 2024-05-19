package fakhredinne.puissanceapp.Model;

public class Coup {
	public Coup() {
	}

	public int getNumColonneJ1() {
		return numColonneJ1;
	}

	public int getNumColonneJ2() {
		return numColonneJ2;
	}

	private int numColonneJ1 ;
	private int numColonneJ2 ;
	public Coup(int numColonneJ1, int numColonne2) {
		this.numColonneJ1 = numColonneJ1;
	}

	public Coup(int jj) {
	}

	public int getCoupJ1() {
		return numColonneJ1;
	}
	public void setCoupJ1(int pnumColonneJ1os) {
		this.numColonneJ1 = numColonneJ1;
	}

	public int getCoupJ2() {
		return numColonneJ2;
	}
	public void setCoupJ2(int numColonneJ2) {
		this.numColonneJ2 = numColonneJ2;
	}
	@Override
	public String toString() {
		return "Coup [numColonneJ1=" + numColonneJ1 +", numColonneJ2=" + numColonneJ2 +"]";
	}
}
