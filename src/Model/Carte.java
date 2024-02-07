package Model;

import com.sun.tools.javac.Main;

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
        List<Joueurs> joueurs = statDeJeu.getJoueur();

        // Remplissage de la matrice selon les spécifications
        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau[x].length; y++) {
                if ((x == 0) | (x == 11) | (y == 0) | (y == 12)) {
                    // Remplir les bords avec des 2
                    plateau[x][y] = 2;
                } else {
                    // Remplir le reste avec des 0
                    plateau[x][y] = 0;
                }
            }
        }

        // Placement des joueurs sur la carte
        for (int NombreDuJoueur = 0; NombreDuJoueur < joueurs.size(); NombreDuJoueur++) {
            plateau[joueurs.get(NombreDuJoueur).getJoueurY()][joueurs.get(NombreDuJoueur).getJoueurX()] = joueurs.get(NombreDuJoueur).getID();
        }
        return plateau;
    }

    // Méthode pour afficher la carte
    public static void AfficherMap(int[][] Plateau) {
        char[] Lettre = {'a', 'b', 'c', 'd', 'e','f','g','h','i', 'j'};
        int [] Chiffre = {1,2,3,4,5,6,7,8,9,10,11};
        if (!AffichageActif) {
            // Si l'affichage est désactivé, quitte la méthode sans rien afficher
        } else {
            // Parcours de la carte ligne par ligne
            for (int Ligne = 0; Ligne < Plateau.length; Ligne++) {
                if(Ligne > 0 & Ligne < 11){
                    // Affichage des lettres pour les lignes intermédiaires
                    System.out.print(Lettre[Ligne-1]);
                }

                for (int Colonnes = 0; Colonnes < Plateau[Ligne].length; Colonnes++) {
                    if(Ligne == 0 && Colonnes > 0 & Colonnes < 12){
                        // Affichage des chiffres pour la première ligne
                        System.out.print(Chiffre[Colonnes-1]);
                        System.out.print("\t");
                    }
                    else if (Plateau[Ligne][Colonnes] == 0) {
                        // Remplace 0 par le caractère spécial pour la case vide
                        System.out.print("▮" + "\t");
                    } else if (Plateau[Ligne][Colonnes] == 2) {
                        // Remplace 2 par un vide pour retirer les 2
                        System.out.print("" + "\t");
                    } else if (Plateau[Ligne][Colonnes] >= 5 && Plateau[Ligne][Colonnes] <= 8) {
                        // Affichage des joueurs avec des couleurs spécifiques
                        System.out.print(Couleurs.Mettre(6)+"●"+Couleurs.Mettre(0) + "\t");
                    } else {
                        // Affichage des autres éléments du plateau
                        System.out.print(Plateau[Ligne][Colonnes] + "\t");
                    }
                }
                // Nouvelle ligne pour chaque ligne de la matrice
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
