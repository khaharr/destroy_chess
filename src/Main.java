import Model.*; // Importe toutes les classes du package Model

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variable pour compter les tours de jeu
        int tour = 0;
        // Affiche le menu de jeu
        Menu.MenuDuJeu();
        // Crée un scanner pour la saisie utilisateur
        Scanner scanner1 = new Scanner(System.in);
        // Demander le pseudo du premier joueur et vérifier sa validité
        String pseudoJoueur1;
        do {
            System.out.println("Entrez le pseudo du joueur 1 (entre 2 et 10 caractères) :");
            pseudoJoueur1 = scanner1.nextLine();
            if (pseudoJoueur1.length() < 2 || pseudoJoueur1.length() > 10) {
                System.out.println("Le pseudo doit contenir entre 2 et 10 caractères !");
            }
        } while (pseudoJoueur1.length() < 2 || pseudoJoueur1.length() > 10);

        // Crée un objet Joueurs pour le premier joueur avec le pseudo saisi et des coordonnées initiales
        Joueurs Joueur1 = new Joueurs(pseudoJoueur1, 4, 6, 5, 5);
        // Ajoute le premier joueur à l'état du jeu
        statDeJeu.setJoueurs(Joueur1);

        String pseudoJoueur2;
        // Demander le pseudo du deuxième joueur et vérifier sa validité
        do {
            System.out.println("Entrez le pseudo du joueur 2 (entre 2 et 10 caractères) :");
            pseudoJoueur2 = scanner1.nextLine();
            if (pseudoJoueur2.length() < 2 || pseudoJoueur2.length() > 10) {
                System.out.println("Le pseudo doit contenir entre 2 et 10 caractères !");
            }
        } while (pseudoJoueur2.length() < 2 || pseudoJoueur2.length() > 10);

        // Crée un objet Joueurs pour le deuxième joueur avec le pseudo saisi et des coordonnées initiales
        Joueurs Joueur2 = new Joueurs(pseudoJoueur2, 6, 6, 6, 6);
        statDeJeu.setJoueurs(Joueur2); // Ajoute le deuxième joueur à l'état du jeu

        int[][] CarteGeneree = Carte.Generer(); // Génère la carte de jeu

        Scanner scanner = new Scanner(System.in); // Crée un scanner pour la saisie utilisateur
        boolean execution_jeu = true;
        while (execution_jeu) { // Boucle de jeu principale
            Carte.AfficherMap(CarteGeneree); // Affiche la carte de jeu

            // Détermine le joueur actif pour ce tour
            Joueurs joueurActif = statDeJeu.getJoueur().get(tour % statDeJeu.getJoueur().size());

            // Affiche le tour du joueur avec son pseudo et sa couleur respective
            System.out.println("Tour du joueur " + Couleurs.Mettre(joueurActif.getCouleur()) + joueurActif.getPseudo() + Couleurs.Mettre(0) + " !");

            // Demande au joueur de saisir une direction pour déplacer son personnage
            System.out.println("Déplacez-vous avec les touches Z (haut), S (bas), Q (gauche), D (droite)  ");

            String input = scanner.nextLine().toUpperCase(); // Lit l'entrée utilisateur et la convertit en majuscules
            switch (input) {
                case "Z":
                    CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, 0, -1); // Déplace le joueur vers le haut
                    break;
                case "Q":
                    CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, -1, 0); // Déplace le joueur vers la gauche
                    break;
                case "S":
                    CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, 0, 1); // Déplace le joueur vers le bas
                    break;
                case "D":
                    CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, 1, 0); // Déplace le joueur vers la droite
                    break;
                default:
                    System.out.println("Veuillez ne choisir que parmi les choix qui vous sont proposés!!!"); // Affiche un message d'erreur si l'entrée est invalide
                    break;
            }

            tour++; // Passe au tour suivant
        }
    }
}
