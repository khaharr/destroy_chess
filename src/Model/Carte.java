package Model;

import java.util.List;

public class Carte {
    // Variable statique pour contrôler l'affichage de la carte
    private static boolean AffichageActif = true;

    // Méthode pour obtenir l'état de l'affichage
    public static boolean getAffichageActif(){
        return AffichageActif;
    }

    // Méthode pour générer la carte
    public static int[][] Generer() {
        // Création d'une matrice de 12 lignes et 13 colonnes
        int[][] plateau = new int[12][13];
        // Récupération des joueurs depuis les statistiques de jeu
        List<Joueurs> joueurs = statDeJeu.RecupererJoueurs();

        // Remplissage de la matrice selon les spécifications
        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau[x].length; y++) {
                if ((x == 0) | (x == 11) | (y == 0) | (y == 12)) {
                    // Remplir les bords avec des 2 pour définir les limites de la carte
                    plateau[x][y] = 2;
                } else {
                    // Remplir le reste avec des 0 pour définir les cases jouables
                    plateau[x][y] = 0;
                }
            }
        }

        // Placement des joueurs sur la carte
        for (Joueurs joueur : joueurs) {
            plateau[joueur.getJoueurY()][joueur.getJoueurX()] = joueur.getID();
        }
        return plateau;
    }


    // Méthode pour afficher la carte
    public static void AfficherMap(int[][] Plateau) {
        // Génération de listes pour pouvoir resortir les charactères en fonction d'un index
        char[] Lettre = {'a', 'b', 'c', 'd', 'e','f','g','h','i', 'j'};
        int [] Chiffre = {1,2,3,4,5,6,7,8,9,10,11};
        if (!AffichageActif) {
            // Si l'affichage est désactivé, quitte la méthode sans rien afficher
        } else {
            // Parcours de la carte ligne par ligne
            for (int Ligne = 0; Ligne < Plateau.length; Ligne++) {
                if(Ligne > 0 & Ligne < 11){
                    // Affichage d'une des lettres de la liste au début des lignes
                    System.out.print(Lettre[Ligne-1]);
                }

                for (int Colonnes = 0; Colonnes < Plateau[Ligne].length; Colonnes++) {
                    if(Ligne == 0 && Colonnes > 0 & Colonnes < 12){
                        // Affichage du  chiffre de l'index courant au début des colonnes
                        System.out.print(Colonnes);
                        System.out.print("\t");
                    }
                    else if (Plateau[Ligne][Colonnes] == 0) {
                        // Remplace 0 par le caractère spécial pour les cases jouables
                        System.out.print("▮" + "\t");
                    } else if (Plateau[Ligne][Colonnes] == 2) {
                        // Remplace 2 par un vide pour retirer les 2
                        System.out.print("" + "\t");
                    } else if (Plateau[Ligne][Colonnes] >= 5 && Plateau[Ligne][Colonnes] <= 8) {
                        // Affichage des joueurs avec leurs couleurs respectives Si l'ID du joueur correspond à la valeur dans la case de la matrice, cela signifie que c'est la position d'un joueur.
                        for (Joueurs joueur : statDeJeu.RecupererJoueurs()) {
                            if (joueur.getID() == Plateau[Ligne][Colonnes]) {
                                System.out.print(Couleurs.Mettre(joueur.getCouleur()) +"●" + Couleurs.Mettre(0) + "\t");
                                break;
                            }
                        }
                    } else {
                        // Affichage des autres éléments du plateau
                        System.out.print(Plateau[Ligne][Colonnes] + "\t");
                    }
                }
                // saut de ligne dans l'affichage
                System.out.println();
            }
        }
    }


    // Méthode pour effacer la carte
    public static int[][] EffacerCarte(int[][] generatedMap) {
        // Désactive l'affichage de la carte
        AffichageActif = false;
        System.out.println("La carte a été effacée.");
        // Retourne le tableau modifié
        return generatedMap;
    }
}
