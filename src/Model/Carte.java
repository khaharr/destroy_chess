package Model;

public class Carte {
    private static boolean active_affichage = true;
    public static int[][] Generer() {
        //Création d'une matrice de 12 lignes et 13 colonnes
            int[][] plateau = new int[12][13];
                //Remplissage de la matrice selon les spécifications
                for (int x = 0; x < plateau.length; x++) {
                    for (int y = 0; y < plateau[x].length; y++) {
                        if ((x == 0) | (x == 11) | (y == 0) | (y == 12)) {
                            // Remplir les bords avec des 2
                            plateau[x][y] = 2;
                        } else {
                            //sinon Remplir le reste avec des 0
                            plateau[x][y] = 0;
                        }
                    }
                }
                return plateau;
            }


    public static void AfficherMap(int[][] Plateau, int JoueurX, int JoueurY) {
        char[] Lettre = {'a', 'b', 'c', 'd', 'e','f','g','h','i', 'j'};
        int [] Chiffre = {1,2,3,4,5,6,7,8,9,10,11};
        if (!active_affichage) {
            // Si l'affichage est désactivé, quitte la méthode sans rien afficher
        } else {
            // ca va parcourir ligne par ligne la carte en faisant une boucle dans une boucle

            for (int y = 0; y < Plateau.length; y++) {
                if(y > 0 & y < 11){
                    System.out.print(Lettre[y-1]);
                }
                for (int x = 0; x < Plateau[y].length; x++) {
                    if(x > 0 & x < 12){
                        System.out.print(Chiffre[x-1]);
                    }
                    if (y == JoueurY && x == JoueurX) {
                        // Affiche le joueur en remplaçant la case par
                        System.out.print(Couleurs.Mettre(3)+"●" +Couleurs.Mettre(0)+ "\t");
                    } else if (Plateau[y][x] == 0) {
                        // Remplace 0 par le caractère spécial pour la case vide
                        System.out.print("▮" + "\t");
                    } else if (Plateau[y][x] == 2) {
                        // Remplace 2 par un vide pour retirer les 2
                        System.out.print(""+"\t");
                    }else {
                        System.out.print(Plateau[y][x] + "\t");
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




