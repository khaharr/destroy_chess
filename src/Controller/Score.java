package Controller;

import Model.Joueurs;

import java.util.HashMap;
import java.util.Map;

public class Score {
    public static Map<String, Integer> scoreParNom = new HashMap<>();

    public static void AjouterUtilisateur(Joueurs leJoueur)
    {
        scoreParNom.put(leJoueur.getNomUtilisateur(), 0);
    }

    public static void IncrementerScore(Joueurs LeJoueur, int points)
    {
        scoreParNom.put(LeJoueur.getNomUtilisateur(), scoreParNom.get(LeJoueur.getNomUtilisateur()) + points);
    }

    public static Map<String, Integer> AfficherTableauScore(){
        return scoreParNom;
    }
}
