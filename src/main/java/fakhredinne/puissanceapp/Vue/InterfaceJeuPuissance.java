package Vue;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class InterfaceJeuPuissance {
    private GridPane grilleJeu=new GridPane();
    private Button [][]tabB=new Button [40][40] ;
    public void dessiner(){
        for (int i = 0; i < 42; i++) {
            Button btn=new Button(""+i);
          //  grilleJeu.add(btn);

        }
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
