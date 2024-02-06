package Model;


//Création d'un objet Joueurs
public class Joueurs {

    private String pseudo;
    private String couleur;
    private int score;
    private int ancienneCoordX;
    private int coordX;
    private int ancienneCoordY;
    private int coordY;

    // Création d'un constructeur Joueurs pour pouvoir instancier des joueurs
    public Joueurs (String pseudo, String couleur, int score) {
        this.pseudo = pseudo;
        this.couleur = couleur;
        this.score = score;
    }

    /* Création d'une méthode pour permettre aux joueurs de se déplacer, en faisant varier leurs coordonnées x et y
    dans la carte, lorsqu'ils pressent une certaine touche. */
    public void déplacementsJoueurs (int ancienneCoordX, int ancienneCoordY, int coordX, int coordY) {
        //
    }

    /* Création d'une méthode pour permettre aux joueurs de détruire une case de leur choix après s'être déplacés,
    en rentrant un nom de case constitué d'une lettre et d'un chiffre  */
    public void détruireCases() {
        //
    }



}
