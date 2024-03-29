import Controller.*;
import Model.*; // Importe toutes les classes du package Model
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Controller.Menu.MenuDuJeu;

public class Main {

    public static void main(String[] args) {
        if(GestionaireDeFichier.CopieExiste())
        {
            GestionaireDeFichier.PrendreCopie();
            Score.ChargerSauvegarde(GestionaireDeFichier.LireLignesDuFichierDeSauvegarde());
            System.out.println("Scores chargés !");
        }
        GestionaireDeFichier.asciiVerification();
        game();
    }

    public static void game()
    {

        // Affiche le menu de jeu
        MenuDuJeu();
        // Crée un scanner pour la saisie utilisateur

        int NombreJoueur = Menu.NombreJoueurPartie();
        List<Integer> placementX = new ArrayList<>();
        List<Integer> placementY = new ArrayList<>();
        // placement des joueurs sur la map
        if(NombreJoueur == 2){
            placementX.add(6);
            placementY.add(5);
            placementX.add(11);
            placementY.add(10);
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
            Joueurs joueur = new Joueurs(Pseudo,4,placementX.get(i),placementY.get(i),i+5);
            statDeJeu.DefinirJoueurs(joueur);
            Score.AjouterUtilisateur(joueur);
            //System.out.print(NouveauJoueur.getJoueurX());
        }
        // Variable pour compter les tours de jeu
        int tour = statDeJeu.JoueurAléatoire();
        int[][] CarteGeneree = Carte.Generer(); // Génère la carte de jeu

        Scanner scanner = new Scanner(System.in); // Crée un scanner pour la saisie utilisateur
        boolean ExecutionJeu = true;
        while (ExecutionJeu) { // Boucle de jeu principale
            Carte.AfficherMap(CarteGeneree); // Affiche la carte de jeu

            // Détermine le joueur actif pour ce tour
            Joueurs joueurActif = statDeJeu.RecupererJoueurs().get(tour % statDeJeu.RecupererJoueurs().size());

                //permet de verifier si tout les joueurs sont mort
            for (Joueurs joueur : statDeJeu.RecupererJoueurs())
            {
                joueur.JoueurBloque(CarteGeneree);
            }
            if(statDeJeu.CompteJoueurPlateau() == 1)
            {
                System.out.println("Nous avons un vainqueur");
                CarteGeneree = null;
                //Score.IncrementerScore(joueurActif, 5);
                for (Joueurs joueur : statDeJeu.RecupererJoueurs()) {
                    if(joueur.getEstMort()){
                        Score.IncrementerScore(joueur, -2);
                        GestionaireDeFichier.EditerLigneDuFichier(joueur.getNomUtilisateur(), String.valueOf(Score.ConnaitreScoreDeUtilisateur(joueur.getNomUtilisateur())));
                    } else {
                        Score.IncrementerScore(joueur, 5);
                        GestionaireDeFichier.EditerLigneDuFichier(joueur.getNomUtilisateur(), String.valueOf(Score.ConnaitreScoreDeUtilisateur(joueur.getNomUtilisateur())));

                    }
                }

                GestionaireDeFichier.FaireUneCopieLocal();

                statDeJeu.EffacerListeJoueurs();
                game();
                break;
            }
            if(!joueurActif.getEstMort())
            {
                // Affiche le tour du joueur avec son pseudo et sa couleur respective
                System.out.println("Tour du joueur " + Couleurs.Mettre(joueurActif.getID() - 2) + joueurActif.getNomUtilisateur() + Couleurs.Mettre(0) + " !");

                // Demande au joueur de saisir une direction pour déplacer son personnage
                System.out.println("Déplacez-vous avec les touches Z (haut), S (bas), Q (gauche), D (droite)  ");

                // Permettre de quitter la partie et de retourner dans le menu//
                System.out.println("(c)-  Quitter");

                String input = scanner.nextLine().toUpperCase(); // Lit l'entrée utilisateur et la convertit en majuscules
                switch (input) {
                    case "Z":
                        CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, 0, -1); // Déplace le joueur vers le haut
                        Carte.AfficherMap(CarteGeneree);
                        CarteGeneree = joueurActif.DetruireCase(CarteGeneree);
                        break;
                    case "Q":
                        CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, -1, 0); // Déplace le joueur vers la gauche
                        Carte.AfficherMap(CarteGeneree);
                        CarteGeneree = joueurActif.DetruireCase(CarteGeneree);
                        break;
                    case "S":
                        CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, 0, 1); // Déplace le joueur vers le bas
                        Carte.AfficherMap(CarteGeneree);
                        CarteGeneree = joueurActif.DetruireCase(CarteGeneree);
                        break;
                    case "D":
                        CarteGeneree = joueurActif.DeplacementsJoueurs(CarteGeneree, 1, 0); // Déplace le joueur vers la droite
                        Carte.AfficherMap(CarteGeneree);
                        CarteGeneree = joueurActif.DetruireCase(CarteGeneree);
                        break;
                    case "C":
                        MenuDuJeu();
                        break;
                    default:
                        System.out.println("Veuillez ne choisir que parmi les choix qui vous sont proposés!!!"); // Affiche un message d'erreur si l'entrée est invalide
                        break;
                }

            }
            tour++; // Passe au tour suivant
        }
    }
}
