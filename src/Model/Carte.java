package Model;

import com.sun.tools.javac.Main;

import java.util.List;

public class Carte {
    private static boolean AffichageActif = true;

    public static boolean getAffichageActif(){
        return AffichageActif;
    }
    public static int[][] Generer() {


        // je creer la matrice ou je vais positionner toute les case en 0 avec les delimitations de la Model.map avec 2
        int[][] Plateau = {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };

        List<Joueurs> joueurs = statDeJeu.getJoueur();
        System.out.println(joueurs.size());
        for (int i = 0; i < joueurs.size() ; i++) {
            System.out.println(joueurs.get(i).getJoueurY());
            Plateau[joueurs.get(i).getJoueurY()][joueurs.get(i).getJoueurX()] = joueurs.get(i).getID();
        }
            return Plateau;
    }
    
    public static void AfficherMap(int[][] Plateau) {
        // Si l'affichage est désactivé, quitte la méthode sans rien afficher
        if (!AffichageActif) {}

        else {
            // Va parcourir ligne par ligne la carte grâce à une boucle dans une boucle
            for (int colonnes = 0; colonnes < Plateau.length; colonnes++) {
                for (int lignes = 0; lignes < Plateau[colonnes].length; lignes++) {
                    if (Plateau[colonnes][lignes] == 0) {
                        // Remplace 0 par le caractère spécial pour la case vide
                        System.out.print("▮" + "\t");
                    } else {
                        System.out.print(Plateau[colonnes][lignes] + "\t");
                    }
                }
                // Nouvelle ligne pour chaque ligne de la matrice
                System.out.println();
            }
        }
    }


    public static int[][] EffacerCarte(int[][] generatedMap) {
        // Désactive l'affichage de la carte
        AffichageActif = false;
        System.out.println("La carte a été effacée.");
        // Retourne le tableau modifié
        return generatedMap;
    }


}




