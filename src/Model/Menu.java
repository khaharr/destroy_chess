package Model;

// Import des classes nécessaires
import java.util.InputMismatchException;
import java.util.Scanner;

// Import de la méthode EffacerCarte de la classe Carte depuis le package Model
import static Model.Carte.EffacerCarte;

// Définition de la classe Menu
public class Menu {

    // Fonction qui permet de parcourir le menu du jeu
    public static void MenuDuJeu () {
        boolean OuvrirMenuDuJeu = false;
        // Detecte si le menu doit s'ouvrir de nouveau
        // DO s'occupe de l'affichage et mise en place des inputs
        do{
            OuvrirMenuDuJeu = false;
            System.out.println("        ✃ＤＥＳＴＲＯＹ ＴＨＥ ＧＡＲＤＥＮ ✃ ");
            System.out.println("          ―――――――――――――――――――――――――――");
            System.out.println("             1 - Jouer ");
            System.out.println("             2 - Règles du jeu ");
            System.out.println("             3 - Quitter");
            System.out.println("          ―――――――――――――――――――――――――――");
            Scanner scanner = new Scanner(System.in);
            try {
                int choix = scanner.nextInt();
                if (choix == 1){
                    SelectionPseudoEtCouleur();
                }
                else if(choix == 2){
                    ReglesDuJeu();
                    OuvrirMenuDuJeu = true;
                }
                else if (choix == 3){
                    QuitterLeJeu();
                }
                else {
                    System.out.println("Vous ne pouvez pas mettre un chiffre incorrect");
                }
            }
            // gère les erreurs, si le joueur met un chiffre ou un caractère autre que 1,2,3
            catch(InputMismatchException e) {
                System.out.println("Veuillez mettre le chiffre correctement");
                OuvrirMenuDuJeu = true;
            }
        }while (OuvrirMenuDuJeu);
    }

    // Permettre au joueur de définir un pseudo ainsi que sa couleur
    public static void SelectionPseudoEtCouleur(){
        // Déclaration des variables
        boolean VerifPseudo = false;
        String PseudoChoisi;

        do {
            // Affichage de la demande pour choisir le pseudo
            System.out.println("Veuillez choisir votre pseudo jeune jardinier !");
            System.out.println("    ―――――――――――――――――――――――――――――――――――");

            // Enregistrement du pseudo du joueur
            Scanner pseudo = new Scanner(System.in);
            PseudoChoisi = pseudo.next();

            // Vérification si le pseudo contient uniquement des lettres et si sa longueur est comprise entre 2 et 10 caractères
            if (PseudoChoisi.matches("[a-zA-Z]+") && PseudoChoisi.length() >= 2 && PseudoChoisi.length() <= 10) {
                System.out.println("Pseudo validé avec succès !");
                System.out.println(Couleurs.Mettre(6) + PseudoChoisi + Couleurs.Mettre(0));
                VerifPseudo = false; // Le pseudo est valide, on sort de la boucle
            } else {
                // Le pseudo contient des caractères invalides ou n'est pas dans la plage de longueur spécifiée
                System.out.println("Veuillez choisir un pseudo valide entre 2 et 10 caractères maximum, contenant uniquement des lettres !");
                VerifPseudo = true; // On continue la boucle pour redemander un pseudo
            }
        } while (VerifPseudo); // Répéter tant que le pseudo n'est pas valide

    }

    // Visualiser les règles du jeu
    public static void ReglesDuJeu() {
        System.out.println("B̲l̲o̲q̲u̲e̲r̲ ̲l̲e̲ ̲j̲a̲r̲d̲i̲n̲i̲e̲r̲ ̲a̲d̲v̲e̲r̲s̲a̲i̲r̲e̲ ̲a̲f̲i̲n̲ ̲q̲u̲'̲i̲l̲ ̲n̲e̲ ̲p̲u̲i̲s̲s̲e̲ ̲p̲a̲s̲ ̲p̲l̲a̲n̲t̲e̲r̲ ̲d̲e̲ ̲b̲e̲l̲l̲e̲s̲ ̲g̲r̲a̲i̲n̲e̲s̲ ̲d̲a̲n̲s̲ ̲v̲o̲t̲r̲e̲ ̲j̲a̲r̲d̲i̲n̲.̲");
        System.out.println("LES RÈGLES DU JEU");
        System.out.println("≻───── ⋆✩⋆ ─────≺");
        System.out.println("1.Chaque joueur effectue deux actions par tour : se déplacer d'une case et détruire une case de son choix.");
        System.out.println("Les joueurs n'ont pas le droit de se déplacer en diagonale.");
    }

    // Quitter le jeu et le programme
    public static void QuitterLeJeu(){
        System.out.println("Vous avez quitté le jeu DESTROY THE GARDENER SPACE");
        System.exit(0);
    }
}
