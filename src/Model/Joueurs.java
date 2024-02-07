package Model;

//Création d'un objet Joueurs
public class Joueurs {

    private String Pseudo;
    private int Couleur;
    private int Score;
    private int JoueurX;
    private int JoueurY;

    private int id;

    // Création d'un constructeur Joueurs pour pouvoir instancier des joueurs
    public Joueurs (String pseudo, int couleur, int joueurX, int joueurY, int id) {
        this.Pseudo = pseudo;
        this.Couleur = couleur;
        this.Score = 0;
        JoueurX =  joueurX;
        JoueurY =  joueurY;
        this.id = id;
    }


    /* Création des getters et setters pour pouvoir récupérer et modifier les attributs des joueurs, qui ont été
    encapsulés (définis en privé pour pas qu'ils ne soient manipulés en dehors de la classe sans ça) */

    public int getCouleur() {
        return Couleur;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }

    public int getJoueurX(){
        return JoueurX;
    }
    public void setJoueurX(int joueurX) {
        JoueurX = joueurX;
    }
    public int getJoueurY(){
        return JoueurY;
    }
    public void setJoueurY(int joueurY) {
        JoueurY = joueurY;
    }




    /* Création d'une méthode pour permettre aux joueurs de se déplacer, en faisant varier leurs coordonnées x et y
    dans la carte, lorsqu'ils pressent une certaine touche. */
    public int[][] DeplacementsJoueurs (int[][] carte, int joueurX, int joueurY) {
        if(carte[JoueurY + joueurY][JoueurX + joueurX] == 0) {
            carte[JoueurY + joueurY][JoueurX + joueurX] = id;
            carte[JoueurY][JoueurX] = 0;
            JoueurY += joueurY;
            JoueurX += joueurX;
        }
        return carte;
    }

    public int getID(){
        return this.id;
    }

    /* Création d'une méthode pour permettre aux joueurs de détruire une case de leur choix après s'être déplacés,
    en rentrant un nom de case constitué d'une lettre et d'un chiffre  */

    public void DétruireCases() {
        //
    }

/*if (x == Joueurs.getJoueurX() && y == Joueurs.getJoueurY()) {
        // Affiche le joueur en remplaçant la case par un point de couleur
        System.out.print(+"●" +Couleurs.Mettre(0)+ "\t");
        */
}
