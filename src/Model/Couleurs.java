package Model;

public class Couleurs {

    int Defaut = 0;
    int Noir = 1;
    int Rouge = 2;
    int Vert = 3;
    int Jaune = 4;
    int Bleu = 5;
    int Mauve = 6;
    int Ciel = 7;
    public static int Blanc = 8;

    /**
     * Retourne une couleur pour le terminal via un entier
     *
     * @param Couleur
     * @return
     */
    public static String Mettre(int Couleur)
    {

        return switch (Couleur) {
            case 0 -> "\u001B[0m";
            case 1 -> "\u001B[30m";
            case 2 -> "\u001B[31m";
            case 3 -> "\u001B[32m";
            case 4 -> "\u001B[33m";
            case 5 -> "\u001B[34m";
            case 6 -> "\u001B[35m";
            case 7 -> "\u001B[36m";
            case 8 -> "\u001B[37m";
            case 9 -> "\u001B[38m";
            default -> "\u001B[0m";
        };
    }
}
