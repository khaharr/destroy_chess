import Model.map;

public class Main {

    public static void main(String[] args) {
        // Génère la carte
        int[][] generatedMap = map.generate();
        //Remplace les zéros par un caractère spécial
        map.effacerZero(generatedMap);
        // Affiche la carte avec les zéros remplacés
        map.afficherMap(generatedMap);
        map.effacerMap(generatedMap);
    }
}
