package Model;
// Import des classes nécessaires

import java.util.ArrayList;
import java.util.List;

// Définition de la classe statDeJeu
public class statDeJeu {

    // Liste statique des joueurs
    static List<Joueurs> ListeDeJoueurs = new ArrayList<>();

    // Méthode pour obtenir la liste des joueurs
    public static List<Joueurs> RecupererJoueurs(){
        return ListeDeJoueurs;
    }
    // compte le nombre de joueur en vie sur le plateau//
    public  static int CompteJoueurPlateau() {
        int nombre = 0;
        for (int i = 0; i < ListeDeJoueurs.size(); i++) {
            if (!ListeDeJoueurs.get(i).getEstMort()) {
                nombre++;
            }
            return nombre;
        }
        return nombre;
    }



    // Méthode pour ajouter un joueur à la liste
    public static void DefinirJoueurs(Joueurs nouveauJoueur) {
        ListeDeJoueurs.add(nouveauJoueur);
    }
}
