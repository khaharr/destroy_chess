//import Model.Carte;
//import Model.Menu;
// Import des classes nécessaires du package Model
import Model.*;

// Import de la classe Scanner depuis java.util
import java.util.Scanner;

// Définition de la classe principale Main
public class Main {

    // Méthode principale de l'application
    public static void main(String[] args) {

        // Variable pour compter les tours de jeu
        int tour = 0;

        // Affichage du menu de jeu
        Menu.MenuDuJeu();

        // Instanciation des joueurs
        Joueurs Joueur1 = new Joueurs("mag", 4, 6, 5, 5);
        statDeJeu.setJoueurs(Joueur1);

        Joueurs Joueur2 = new Joueurs("meg", 3, 6, 6, 6);
        statDeJeu.setJoueurs(Joueur2);

        // Affichage des joueurs
        System.out.println(statDeJeu.getJoueur());

        // Génération de la carte de jeu
        int[][] CarteGeneree = Carte.Generer();

        // Boucle de jeu
        Scanner scanner = new Scanner(System.in);
        boolean execution_jeu = true;
        while (execution_jeu) {

            // Affichage de la carte avec les joueurs
            Carte.AfficherMap(CarteGeneree);

            // Demande à l'utilisateur de saisir une direction pour déplacer le joueur
            System.out.println("Déplacez-vous avec les touches Z (haut), S (bas), Q (gauche), D (droite)  ");
           // System.out.println(statDeJeu.getJoueur().get(tour).getCouleur());
            String input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "Z":
                    CarteGeneree = statDeJeu.getJoueur().get(tour).DeplacementsJoueurs(CarteGeneree, 0, -1);
                    break;
                case "Q":
                    CarteGeneree = statDeJeu.getJoueur().get(tour).DeplacementsJoueurs(CarteGeneree, -1, 0);
                    break;
                case "S":
                    CarteGeneree = statDeJeu.getJoueur().get(tour).DeplacementsJoueurs(CarteGeneree, 0, 1);
                    break;
                case "D":
                    CarteGeneree = statDeJeu.getJoueur().get(tour).DeplacementsJoueurs(CarteGeneree, 1, 0);
                    break;
                default:
                    // Cas par défaut lorsque l'entrée de l'utilisateur ne correspond à aucun des cas précédents
                    System.out.println("Veuillez ne choisir que parmi les choix qui vous sont proposés!!!");
                    break;
            }

            // Vérification si le nombre de tours atteint le nombre de joueurs, dans ce cas, on recommence à partir du premier joueur
            if(statDeJeu.getJoueur().size() == tour + 1){
                tour = 0;
            } else {
                tour++;
            }
        }
    }
}
