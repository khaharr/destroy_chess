package Model;

public class Carte {
    private static boolean active_affichage = true;
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

            return Plateau;
    }
    
    public static void AfficherMap(int[][] Plateau, int JoueurX, int JoueurY) {
        if (!active_affichage) {
            // Si l'affichage est désactivé, quitte la méthode sans rien afficher
            return;
        } else {
            // ca va parcourir ligne par ligne la carte en faisant une boucle dans une boucle
            for (int i = 0; i < Plateau.length; i++) {
                for (int j = 0; j < Plateau[i].length; j++) {
                    if (i == JoueurY && j == JoueurX) {
                        // Affiche le joueur en remplaçant la case par
                        System.out.print(Couleurs.Mettre(6)+"●" +Couleurs.Mettre(0)+ "\t");
                    } else if (Plateau[i][j] == 0) {
                        // Remplace 0 par le caractère spécial pour la case vide
                        System.out.print("▮" + "\t");
                    } else {
                        System.out.print(Plateau[i][j] + "\t");
                    }
                }
                // Nouvelle ligne pour chaque ligne de la matrice
                System.out.println();
            }
        }
    }


    public static int[][] EffacerCarte(int[][] generatedMap) {
        // Désactive l'affichage de la carte
        active_affichage = false;
        System.out.println("La carte a été effacée.");
        // Retourne le tableau modifié
        return generatedMap;
    }


}




