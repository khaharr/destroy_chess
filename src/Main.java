import Model.map;

public class Main {

    public static void main(String[] args) {
        // Génère la carte

                // Génère la carte
                int[][] generatedMap = map.generate();

                // Affiche la carte avec les zéros remplacés
                //map.afficherMap(generatedMap);
                //Remplace les zéros par un caractère spécial
                map.effacerZero(generatedMap);

                // Efface la carte et obtient le tableau modifié
                //generatedMap = map.effacerMap(generatedMap);

                // Affiche la carte après l'avoir effacée
                map.afficherMap(generatedMap);



    }}
