package Model;


//Création d'un objet Joueurs
public class Joueurs {

    private String pseudo;
    private String couleur;
    private int score;
    private int coordX;
    private int coordY;

    // Création d'un constructeur Joueurs pour pouvoir instancier des joueurs
    public Joueurs (String pseudo, String couleur, int score) {
        this.pseudo = pseudo;
        this.couleur = couleur;
        this.score = score;
    }


    /* Création des getters et setters pour pouvoir récupérer et modifier les attributs des joueurs, qui ont été
    encapsulés (définis en privé pour pas qu'ils ne soient manipulés en dehors de la classe sans ça) */

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    /* Création d'une méthode pour permettre aux joueurs de se déplacer, en faisant varier leurs coordonnées x et y
        dans la carte, lorsqu'ils pressent une certaine touche. */
    public void déplacementsJoueurs (int JoueurX, int JoueurY) {
        //
    }

    /* Création d'une méthode pour permettre aux joueurs de détruire une case de leur choix après s'être déplacés,
    en rentrant un nom de case constitué d'une lettre et d'un chiffre  */
    public void détruireCases() {
        //
    }



}
