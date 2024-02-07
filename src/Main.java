//import Model.Carte;
//import Model.Menu;
import Model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int tour = 0;
        // Génère la carte

        Menu.MenuDuJeu();

        // Instanciation du premier joueur
        Joueurs Joueur1 = new Joueurs("mag", 4, 6, 5, 5);
        statDeJeu.setJoueurs(Joueur1);

        Joueurs Joueur2 = new Joueurs("meg", 3, 3, 9, 6);
        statDeJeu.setJoueurs(Joueur2);
        System.out.println(statDeJeu.getJoueur());


        int[][] CarteGeneree = Carte.Generer();

        // Boucle de jeu
        Scanner scanner = new Scanner(System.in);
        boolean execution_jeu = true;
        while (execution_jeu) {

            // CarteGeneree = Carte.EffacerCarte(CarteGeneree);

            // Affiche la carte avec le joueur (donc ces coordonne sur la matrice )
            Carte.AfficherMap(CarteGeneree);

            // Attend une entrée clavier pour le déplacement du joueur
            System.out.println("Déplacez-vous avec les touches Z (haut), S (bas), Q (gauche), D (droite)  ");
            System.out.println(statDeJeu.getJoueur().get(tour).getCouleur());
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
                //Déclare un cas par défaut qui est exécuté lorsque l'entrée de l'utilisateur ne correspond à aucun des cas précédents.
                default:
                    System.out.println("Veuillez ne choisir que parmis les choix qui vous sont proposés!!!");
                    break;
            }
            // vérification si on doit relancer les tours si le nombre de tour atteind le nombre de joueur on recommence
            if(statDeJeu.getJoueur().size() == tour +1){
                tour = 0;
            } else {
                tour++;
            }
        }
    }
}