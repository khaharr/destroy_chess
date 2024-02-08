import Model.*; // Importe toutes les classes du package Model

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variable pour compter les tours de jeu
        int tour = 0;
        // Affiche le menu de jeu
        Menu.MenuDuJeu();
        // Crée un scanner pour la saisie utilisateur

        int NombreJoueur = Menu.NombreJoueurPartie();
        List<Integer> placementX = new ArrayList<>();
        List<Integer> placementY = new ArrayList<>();
        // placement des joueurs sur la map
        if(NombreJoueur == 2){
            placementX.add(6);
            placementY.add(5);
            placementX.add(6);
            placementY.add(6);
        } else {
            placementX.add(5);
            placementY.add(5);
            placementX.add(5);
            placementY.add(6);

            placementX.add(7);
            placementY.add(5);
            placementX.add(7);
            placementY.add(6);
        }

        for (int i = 0; i < NombreJoueur; i++) {
             String Pseudo = Menu.EntrerPseudo();
             statDeJeu.DefinirJoueurs(new Joueurs(Pseudo,4,placementX.get(i),placementY.get(i),i+5));
//            System.out.print(NouveauJoueur.getJoueurX());
        }

        int[][] CarteGeneree = Carte.Generer(); // Génère la carte de jeu

        Scanner scanner = new Scanner(System.in); // Crée un scanner pour la saisie utilisateur
        boolean ExecutionJeu = true;
        while (ExecutionJeu) { // Boucle de jeu principale
            Carte.AfficherMap(CarteGeneree); // Affiche la carte de jeu

            // Détermine le joueur actif pour ce tour
            Joueurs joueurActif = statDeJeu.RecupererJoueurs().get(tour % statDeJeu.RecupererJoueurs().size());

            // Affiche le tour du joueur avec son pseudo et sa couleur respective
            System.out.println("Tour du joueur " + Couleurs.Mettre(joueurActif.getCouleur()) + joueurActif.getNomUtilisateur() + Couleurs.Mettre(0) + " !");

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
