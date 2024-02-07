import Model.Carte;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Génère la carte
        int[][] generatedMap = Carte.Generer();

        // Coordonnées initiales du joueur
        int playerX = 6;
        int playerY = 5;

        // Boucle de jeu
        Scanner scanner = new Scanner(System.in);
        boolean execution_jeu = true;
        while (execution_jeu) {

           // generatedMap = Carte.EffacerCarte(generatedMap);

            // Affiche la carte avec le joueur (donc ces coordonne sur la matrice )
            Carte.AfficherMap(generatedMap, playerX, playerY);

            // Attend une entrée clavier pour le déplacement du joueur
            System.out.println("Déplacez-vous avec les touches Z (haut), S (bas), Q (gauche), D (droite)  ");
            String input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "Z":
                    // Vérifie si le déplacement vers le haut est possible en vérifiant si la case au-dessus du joueur n'est pas un mur.
                    if (generatedMap[playerY - 1][playerX] != 2) {
                        // Réinitialise la case actuelle du joueur à 0 dans la carte.
                        generatedMap[playerY][playerX] = 0;
                        //Déplace le joueur vers le haut en diminuant sa coordonnée Y.
                        playerY--;
                    }
                    break;
                case "S":
                    // Vérifie si le déplacement vers le BAs est possible en vérifiant si la case en dessus du joueur n'est pas un mur.
                    if (generatedMap[playerY + 1][playerX] != 2) {
                        // Réinitialise la case actuelle du joueur à 0 dans la carte.
                        generatedMap[playerY][playerX] = 0;
                        //Déplace le joueur vers le bas en augmentant sa coordonnée Y.
                        playerY++;
                    }
                    break;
                case "Q":
                    // Vérifie si le déplacement vers la gauche est possible en vérifiant si la case a gauche du joueur n'est pas un mur.
                    if (generatedMap[playerY][playerX - 1] != 2) {
                        // Réinitialise la case actuelle du joueur à 0 dans la carte.
                        generatedMap[playerY][playerX] = 0;
                        //Déplace le joueur vers la gauche en diminuant sa coordonnée Y.
                        playerX--;
                    }
                    break;
                case "D":
                    // Vérifie si le déplacement vers la droite est possible en vérifiant si la case a droite du joueur n'est pas un mur.
                    if (generatedMap[playerY][playerX + 1] != 2) {
                        // Réinitialise la case actuelle du joueur à 0 dans la carte.
                        generatedMap[playerY][playerX] = 0;
                        //Déplace le joueur vers la droite en augmentant sa coordonnée Y.
                        playerX++;
                    }
                    break;
                    // Déclare un cas pour l'entrée "EXIT", qui arrête le jeu en changeant la valeur de execution_jeu à false.
                case "EXIT":
                    execution_jeu = false;
                    break;
                    //Déclare un cas par défaut qui est exécuté lorsque l'entrée de l'utilisateur ne correspond à aucun des cas précédents.
                default:
                    System.out.println("!!!");
                    break;
            }
        }
    }
}
