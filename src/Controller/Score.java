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


    /**
     * Cette méthode permet d'enregistrer les scores des joueurs dans un fichier texte spécifié.
     *
     * @param cheminFichier Le chemin du fichier dans lequel enregistrer les scores.
     */
    public static void SauvegarderScoresDansFichier(String cheminFichier) {
        try {
            // Création d'un BufferedWriter pour écrire dans le fichier spécifié
            BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier));

            // Parcours de la map contenant les scores des joueurs
            for (Map.Entry<String, Integer> entry : scoreParNom.entrySet()) {
                // Écriture du nom du joueur suivi de son score, séparés par =
                writer.write(entry.getKey() + "=" + entry.getValue());
                // Ajout d'un saut de ligne pour passer à l'entrée suivante
                writer.newLine();
            }

            // Fermeture du BufferedWriter pour libérer les ressources
            writer.close();

            // Affichage d'un message indiquant que les scores ont été enregistrés avec succès
            System.out.println("Scores enregistrés dans le fichier : " + cheminFichier);
        } catch (IOException e) {
            // En cas d'erreur lors de l'écriture dans le fichier, affichage d'un message d'erreur
            System.out.println("Erreur lors de l'enregistrement des scores dans le fichier : " + cheminFichier);
        }
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
