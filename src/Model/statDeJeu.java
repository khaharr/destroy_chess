package Model;

import java.util.ArrayList;
import java.util.List;

public class statDeJeu {

    static List<Joueurs> ListeDeJoueurs = new ArrayList<>();

    public static List<Joueurs> getJoueur(){
        return ListeDeJoueurs;
    }

    public static void setJoueurs(Joueurs nouveauJoueur) {
            ListeDeJoueurs.add(nouveauJoueur);
    }
}
