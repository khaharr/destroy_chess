package Model;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Création d'un objet Joueurs
public class Joueurs {

    private String NomUtilisateur;
    private int Couleur;

    private int Score;
    private int JoueurX;
    private int JoueurY;

    private boolean Estmort = false ;
    private int id;

    // Création d'un constructeur Joueurs pour pouvoir instancier des joueurs
    public Joueurs (String NomUtilisateur, int couleur, int joueurX, int joueurY, int id) {
        this.NomUtilisateur = NomUtilisateur;
        this.Couleur = couleur;
        this.Score = 0;
        this.JoueurX =  joueurX;
        this.JoueurY =  joueurY;
        this.id = id;
    }

    // Méthode pour obtenir le pseudo du joueur
    public String getNomUtilisateur() {
        return this.NomUtilisateur;
    }

    public boolean getEstMort() {
        return Estmort;
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

    /**
     * Création d'une function pour permettre aux joueurs de se déplacer, en utilisant des coordonées relatives
     *     dans la carte, lorsqu'ils pressent une certaine touche.
     *
     * @param carte
     * @param joueurX
     * @param joueurY
     * @return int[][]
     */
    public int[][] DeplacementsJoueurs (int[][] carte, int joueurX, int joueurY) {
        //Ici on vérifie si la case voulu par l'utilisateur est disponible
        if(carte[JoueurY + joueurY][JoueurX + joueurX] == 0) {
            // Ici on définit la case voulu par l'utilisateur par son identifiant dans les donées de la carte
            carte[JoueurY + joueurY][JoueurX + joueurX] = id;
            //Remplacement de l'ancien place de l'utilisateur par un 0 = Case normal
            carte[JoueurY][JoueurX] = 0;

            // Modification des cordonées du joueurs dans son objet
            JoueurY += joueurY;
            JoueurX += joueurX;
        }

        // renvoi de la carte
        return carte;
    }

    /**
     * Permet de détruire la case préciser par l'utilisateur
     *
     * @param carte
     * @return
     */
    public int[][] DetruireCase (int[][] carte)
    {
        Map<String, Integer> TraduitDonnee = new HashMap<>();
        TraduitDonnee.put("A", 1);
        TraduitDonnee.put("B", 2);
        TraduitDonnee.put("C", 3);
        TraduitDonnee.put("D", 4);
        TraduitDonnee.put("E", 5);
        TraduitDonnee.put("F", 6);
        TraduitDonnee.put("G", 7);
        TraduitDonnee.put("H", 8);
        TraduitDonnee.put("I", 9);
        TraduitDonnee.put("J", 10);

        System.out.println("Choissiez une case à  détruire. Example : A1");
        Scanner DemanderAuJoueur = new Scanner(System.in);
        boolean Recommencer = true;
        do {
            try{
                String Reponse = DemanderAuJoueur.nextLine().toUpperCase();
                String Ligne = Reponse.substring(0, 1);
                String Colonne = Reponse.substring(1);

                if(TraduitDonnee.get(Ligne) == null)
                {
                    System.out.println("Vous avez entrée une valeur inconnu veuillez mettre une valeur entre A et J");
                } else {
                    Integer LigneTraduite = TraduitDonnee.get(Ligne);
                    if(carte[LigneTraduite][Integer.parseInt(Colonne)] == 0) {
                        carte[LigneTraduite][Integer.parseInt(Colonne)] = 1;
                        Recommencer = false;
                    } else {
                        System.out.println("Case déjà occupé");
                    }
                }


            } catch (Exception e)
            {

            }
        } while (Recommencer);

        return carte;
    }

    public int getID(){
        return this.id;
    }

    /* Création d'une méthode pour permettre aux joueurs de détruire une case de leur choix après s'être déplacés,
    en rentrant un nom de case constitué d'une lettre et d'un chiffre
    public void DétruireCases() {
        //*/

    // Verifier si les cases adjacente sont disponibles //
    public void JoueurBloque(int[][] Carte){
        if (Carte[JoueurY-1][JoueurX]!=0 &&
                Carte[JoueurY+1][JoueurX]!=0 &&
                Carte[JoueurY][JoueurX +1]!=0 &&
                Carte[JoueurY][JoueurX -1]!=0) {
                Estmort = true ;

        }

    }



}
