package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    // Fonction qui permet de parcourir le menu du jeu //
    public static void menuDuJeu () {
        System.out.println("    ✃ＤＥＳＴＲＯＹ ＴＨＥ ＧＡＲＤＥＮ ＳＰＡＣＥ✃ ");
        System.out.println("          ―――――――――――――――――――――――――――");
        System.out.println("             Jouer ");
        System.out.println("             Règles du jeu ");
        System.out.println("             Quitter");
        System.out.println("          ―――――――――――――――――――――――――――");
        Scanner scanner = new Scanner(System.in);


        try {
            int choix = scanner.nextInt();
           if (choix == 1){
               affichageJoueur();
           }
            else if(choix == 2){
                reglesDuJeu();
            }

            else if (choix == 3){
                quitterLeJeu();
            }
            else {
               System.out.println("Vous ne pouvez pas mettre un chiffre incorrect");
           }
        }
        catch(InputMismatchException e) {
            System.out.println("Veuillez mettre le chiffre correctement");
            menuDuJeu();
        }

    }
    //Permettre au joueur de définir un pseudo ainsi que sa couleur//
    public static void affichageJoueur(){
        System.out.println("Veuillez choisir votre pseudo jeune jardinier !");
        System.out.println("    ―――――――――――――――――――――――――――――――――――");
    }
    //Visualiser les règles du jeu //
    public static void reglesDuJeu(){
        System.out.println("B̲l̲o̲q̲u̲e̲r̲ ̲l̲e̲ ̲j̲a̲r̲d̲i̲n̲i̲e̲r̲ ̲a̲d̲v̲e̲r̲s̲a̲i̲r̲e̲ ̲a̲f̲i̲n̲ ̲q̲u̲'̲i̲l̲ ̲n̲e̲ ̲p̲u̲i̲s̲s̲e̲ ̲p̲a̲s̲ ̲p̲l̲a̲n̲t̲e̲r̲ ̲d̲e̲ ̲b̲e̲l̲l̲e̲s̲ ̲g̲r̲a̲i̲n̲e̲s̲ ̲d̲a̲n̲s̲ ̲v̲o̲t̲r̲e̲ ̲j̲a̲r̲d̲i̲n̲.̲");
        System.out.println("LES RÈGLES DU JEU");
        System.out.println("≻───── ⋆✩⋆ ─────≺");
    }
    public static void quitterLeJeu(){
        System.out.println("Vous avez quitté le jeu DESTROY THE GARDENER SPACE");
        System.exit(0);

    }
}
