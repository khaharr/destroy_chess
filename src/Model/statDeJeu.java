package Model;

// Import des classes nécessaires
import java.util.ArrayList;
import java.util.List;

// Définition de la classe statDeJeu
public class statDeJeu {

    // Liste statique des joueurs
    static List<Joueurs> ListeDeJoueurs = new ArrayList<>();

    // Méthode pour obtenir la liste des joueurs
    public static List<Joueurs> getJoueur(){
        return ListeDeJoueurs;
    }

    // Méthode pour ajouter un joueur à la liste
    public static void setJoueurs(Joueurs nouveauJoueur) {
        ListeDeJoueurs.add(nouveauJoueur);
    }
}
