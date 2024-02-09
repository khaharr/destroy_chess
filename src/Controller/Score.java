package Controller;

import Model.Joueurs;
import java.io.BufferedWriter;// les données sont stockées en mémoire tampon avant d'être écrites dans le fichier.
import java.io.FileWriter; // utilisée pour écrire des caractères dans un fichier
import java.io.IOException;
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


    public static void ChargerSauvegarde(Map<String, Integer> sauvegarde)
    {
        scoreParNom = sauvegarde;
    }

    public static int ConnaitreScoreDeUtilisateur(String utilisateur)
    {
        return scoreParNom.get(utilisateur);
    }

}
