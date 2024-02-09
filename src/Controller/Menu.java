package Controller;

// Import des classes nécessaires
import Model.Joueurs;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Import de la méthode EffacerCarte de la classe Carte depuis le package Model


// Définition de la classe Menu
public class Menu {

    // Fonction qui permet de parcourir le menu du jeu
    public static void MenuDuJeu () {
        // Detecte si le menu doit s'ouvrir de nouveau
        boolean OuvrirMenuDuJeu = false;
        // DO s'occupe de l'affichage et mise en place des inputs
        do{
            OuvrirMenuDuJeu = false;
            System.out.println("        ✃ＤＥＳＴＲＯＹ ＴＨＥ ＧＡＲＤＥＮ ✃ ");
            System.out.println("          ―――――――――――――――――――――――――――");
            System.out.println("             1 - Jouer ");
            System.out.println("             2 - Règles du jeu ");
            System.out.println("             3 - Scores");
            System.out.println("             4 - Quitter");
            System.out.println("             5 - Les meilleurs joueurs");
            System.out.println("             6 - Les PIRES !! Joueurs");
            System.out.println("          ―――――――――――――――――――――――――――");
            Scanner scanner = new Scanner(System.in);
            // permet au joueur d'inserer un chiffre entre 1 et 4 qui ont chacun une action
            try {
                int choix = scanner.nextInt();
                if (choix == 1){
                    break;
                }
                else if(choix == 2){
                    ReglesDuJeu();
                    OuvrirMenuDuJeu = true;
                }
                else if (choix == 3){
                    VoirResultatsJoueurs(0);
                    OuvrirMenuDuJeu = true;
                }
                else if (choix == 4){
                    QuitterLeJeu();
                }
                else if (choix == 5){
                    VoirResultatsJoueurs(1);
                    OuvrirMenuDuJeu = true;
                }
                else if (choix == 6){
                    VoirResultatsJoueurs(2);
                    OuvrirMenuDuJeu = true;
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

    //Calculer le nombre de joueur dans un partie//
    public static int NombreJoueurPartie(){
        boolean Verif = true;
        do {
            System.out.println("Tapez le nombre de joueur présent dans la partie ( entre 2 et 4 maximum)");
            Scanner NbJoueur = new Scanner(System.in);
            try {
                int choix = NbJoueur.nextInt();
                if(choix == 1)
                {
                    try{
                        String file = "src/Ressources/Ascii-art.txt";
                        Scanner scanner = new Scanner(new File(file));
                        scanner.useDelimiter(" ");

                        while(scanner.hasNextLine())
                        {
                            byte[] decodedBytes = Base64.getDecoder().decode(scanner.nextLine());
                            String decodedString = new String(decodedBytes);
                            System.out.println(decodedString);
                        }

                        scanner.close();
                        System.out.println();
                        System.out.println("You look lonely, i can fix that");
                    } catch (IOException e){

                    }
                }
                if (choix >= 2 && choix <= 4) {
                    Verif = false;
                    return choix;
                }
            }
            catch (Exception e) {

            }
        }while(Verif);
        return 0;
    }

    public  static String EntrerPseudo(){
        Scanner scanner1 = new Scanner(System.in);
        boolean NomUtilisateurExist = false;
        do {
            System.out.println("Entrez le pseudo du joueur   (entre 2 et 10 caractères) :");
            String pseudoJoueur = scanner1.nextLine().toLowerCase();
            if (pseudoJoueur.length() < 2 || pseudoJoueur.length() > 10) {
                System.out.println("Le pseudo doit contenir entre 2 et 10 caractères !");
            }else {
                if(!statDeJeu.RecupererJoueurs().isEmpty()){
                    for(Joueurs joueur : statDeJeu.RecupererJoueurs())
                    {
                        if (!pseudoJoueur.trim().equalsIgnoreCase(joueur.getNomUtilisateur().trim())){
                            NomUtilisateurExist = true;
                        } else {
                            System.out.println("Nom d'utilisateur déjà utilisé");
                        }
                    }
                } else {
                    return pseudoJoueur;
                }
                if(NomUtilisateurExist){
                    return pseudoJoueur;
                }
            }
        } while (true);
    }

    // Visualiser les règles du jeu
    public static void ReglesDuJeu() {
        System.out.println("B̲l̲o̲q̲u̲e̲r̲ ̲l̲e̲ ̲j̲a̲r̲d̲i̲n̲i̲e̲r̲ ̲a̲d̲v̲e̲r̲s̲a̲i̲r̲e̲ ̲a̲f̲i̲n̲ ̲q̲u̲'̲i̲l̲ ̲n̲e̲ ̲p̲u̲i̲s̲s̲e̲ ̲p̲a̲s̲ ̲p̲l̲a̲n̲t̲e̲r̲ ̲d̲e̲ ̲b̲e̲l̲l̲e̲s̲ ̲g̲r̲a̲i̲n̲e̲s̲ ̲d̲a̲n̲s̲ ̲v̲o̲t̲r̲e̲ ̲j̲a̲r̲d̲i̲n̲.̲");
        System.out.println("LES RÈGLES DU JEU");
        System.out.println("≻───── ⋆✩⋆ ─────≺");
        System.out.println("1.Chaque joueur effectue deux actions par tour : se déplacer d'une case et détruire une case de son choix.");
        System.out.println("2.Le dernier joueur pouvant encore se déplacer gagne.");
        System.out.println("3.Un joueur ne peut pas occuper une case détruite ou occupé.");
        System.out.println("Les joueurs n'ont pas le droit de se déplacer en diagonale.");
    }

    // Quitter le jeu et le programme
    public static void QuitterLeJeu(){
        System.out.println("Vous avez quitté le jeu DESTROY THE GARDENER SPACE");
        //au moment de quitter sa va enregistrer le score dans scores.txt
        Score.SauvegarderScoresDansFichier("scores.txt");
        System.exit(0);
    }

    // Voir les résultats des joueurs
    public static void VoirResultatsJoueurs(int filtre) {
        System.out.println("Voici les résultats des joueurs :");
        Map<String,Integer> Liste = Score.AfficherTableauScore();
        LinkedHashMap<String, Integer> Trier = new LinkedHashMap<>();

        if(filtre == 2)
        {
            Trier = Liste.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        } else if (filtre == 1)
        {
            Trier = Liste.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }

        int Tour = 10;
        if(Liste.size() < 10 ){
            Tour = Liste.size();
        }
        for (int i = 0; i < Tour; i++) {
            if(filtre == 0)
            {
                System.out.println(Liste.keySet().toArray()[i] + " : " + Liste.values().toArray()[i] + " Points");
            } else {

                System.out.println(Trier.keySet().toArray()[i] + " : " + Trier.values().toArray()[i] + " Points");
            }
        }
    }
}
