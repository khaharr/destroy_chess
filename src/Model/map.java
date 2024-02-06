package Model;

public class map {
    // Variable de contrôle pour activer/désactiver l'affichage de la carte
    private static boolean active_affichage = true;
    public static int[][] generate() {


        // je creer la matrice ou je vais positionner toute les case en 0 avec les delimitations de la Model.map avec 2
        int[][] mat = {
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
        //je vais parcourir la matrice présente juste au dessus en faisant une boucle dans une boucle
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length + 1; j++) {

            }

        }
            return mat;
    }


    public static void effacerZero(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    // je vais Remplace les zéros par le caractère spécial "□"
                    mat[i][j] = -1;
                }
            }
        }
    }

    public static void afficherMap(int[][] mat) {
        if (!active_affichage) {
            return;// Si l'affichage est désactivé, quitte la méthode sans rien afficher
        }
        else {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == -1) {
                    // Remplace -1 par le caractère spécial pour la case vide
                    System.out.print("□" + "\t");
                } else {
                    System.out.print(mat[i][j] + "\t");
                }
            }
            // Nouvelle ligne pour chaque ligne de la matrice
            System.out.println();
        }}
    }

    public static int[][] effacerMap(int[][] generatedMap) {
        // Réinitialise les valeurs de la carte à 0
        for (int i = 0; i < generatedMap.length; i++) {
            for (int j = 0; j < generatedMap[i].length; j++) {
                generatedMap[i][j] = 0; // Remplacez 0 par la valeur que vous considérez comme vide
            }
        }
        // Désactive l'affichage de la carte
        active_affichage = false;
        System.out.println("La carte a été effacée.");
        // Retourne le tableau modifié
        return generatedMap;
    }


}




