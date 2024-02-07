package Model;

import com.sun.tools.javac.Main;

import java.util.List;

public class Carte {
    private static boolean AffichageActif = true;

    public static boolean getAffichageActif(){
        return AffichageActif;
    }
    public static int[][] Generer() {
        //Création d'une matrice de 12 lignes et 13 colonnes
            int[][] plateau = new int[12][13];
            List<Joueurs> joueurs = statDeJeu.getJoueur();

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

                for (int NombreDuJoueur = 0; NombreDuJoueur < joueurs.size(); NombreDuJoueur++) {
                    plateau[joueurs.get(NombreDuJoueur).getJoueurY()][joueurs.get(NombreDuJoueur).getJoueurX()] = joueurs.get(NombreDuJoueur).getID();
                }
                return plateau;
            }
    
 
                      
    public static void AfficherMap(int[][] Plateau) {
        char[] Lettre = {'a', 'b', 'c', 'd', 'e','f','g','h','i', 'j'};
        int [] Chiffre = {1,2,3,4,5,6,7,8,9,10,11};
        if (!AffichageActif) {
            // Si l'affichage est désactivé, quitte la méthode sans rien afficher
        } else {
            // ca va parcourir ligne par ligne la carte en faisant une boucle dans une boucle

            for (int Ligne = 0; Ligne < Plateau.length; Ligne++) {
                if(Ligne > 0 & Ligne < 11){
                    System.out.print(Lettre[Ligne-1]);
                }

                for (int Colonnes = 0; Colonnes < Plateau[Ligne].length; Colonnes++) {
                    if(Ligne == 0 && Colonnes > 0 & Colonnes < 12){
                        System.out.print(Chiffre[Colonnes-1]);
                    }
//                    if (Ligne == JoueurY && Colonnes == JoueurX) {
//                        // Affiche le joueur en remplaçant la case par
//
//                        System.out.print(Couleurs.Mettre(6)+"●" +Couleurs.Mettre(0)+ "\t");
                    /*}*/ else if (Plateau[Ligne][Colonnes] == 0) {

                        // Remplace 0 par le caractère spécial pour la case vide
                        System.out.print("▮" + "\t");
                    } else if (Plateau[Ligne][Colonnes] == 2) {
                        // Remplace 2 par un vide pour retirer les 2
                        System.out.print(""+"\t");
                    }else {
                        System.out.print(Plateau[Ligne][Colonnes] + "\t");
                      
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




