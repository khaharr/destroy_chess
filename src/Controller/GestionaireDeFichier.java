package Controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionaireDeFichier {

    public static void asciiVerification()
    {
        // Si le fichier n'existe pas dans le dossier HOME alors on le copie de nos sources
        if(!Files.exists(Path.of(System.getProperty("user.home") + "/Ascii-art.txt")))
        {
            try {
                Files.copy(Path.of("src/Ressources/Ascii-art.txt"), Path.of(System.getProperty("user.home") + "/Ascii-art.txt"));
            } catch (IOException e) {
                System.out.println("Le fichier source et le fichier HOME n'existe pas");
            }
            //Si le fichier n'existe pas dans nos source alors on le copie de notre HOME
        } else if (!Files.exists(Path.of("src/Ressources/Ascii-art.txt")))
        {
            try {
                Files.copy(Path.of(System.getProperty("user.home") + "/Ascii-art.txt"), Path.of("src/Ressources/Ascii-art.txt"));
            } catch (IOException e) {
                System.out.println("Le fichier source et le fichier HOME n'existe pas");
            }
        } else {
            //NEED TO RECREATE ONE
        }
    }

    public static void FaireUneCopieLocal()
    {
        try {
            Scanner Originale = new Scanner(new File("src/Ressources/sauvegarde.txt"));

            File file = new File(System.getProperty("user.home")+"/sauvegarde.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            while(Originale.hasNextLine())
            {
                String LigneCourrante = Originale.nextLine();
                String encodedString = Base64.getEncoder().encodeToString(LigneCourrante.getBytes());
                bw.write(encodedString);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Integer> LireLignesDuFichierDeSauvegarde()
    {
        Map<String, Integer> Donnee = new HashMap<>();
        File file = new File("src/Ressources/sauvegarde.txt");
        try {
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine())
            {
                String LigneCourrant = reader.nextLine();

                Donnee.put(LigneCourrant.split(":")[0], Integer.parseInt(LigneCourrant.split(":")[1]));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Donnee;
    }

    public static void EditerLigneDuFichier(String Element, String Value)
    {
        Map<String, String> VariableTampon = new HashMap<>();
        try {
            File newFile = new File("src/Ressources/sauvegarde.txt");
            if(!newFile.exists())
            {
                boolean success = newFile.createNewFile();
            }

            Scanner FichierSauvegarde = new Scanner(new File("src/Ressources/sauvegarde.txt"));
            File file = new File("src/Ressources/sauvegarde.txt");
            while(FichierSauvegarde.hasNextLine())
            {
                String LigneCourrant = FichierSauvegarde.nextLine();
                if(LigneCourrant.split(":")[0].trim().equalsIgnoreCase(Element.trim()))
                {
                    VariableTampon.put(Element, Value);
                } else {
                    VariableTampon.put(LigneCourrant.split(":")[0], LigneCourrant.split(":")[1]);
                }
            }
            if(!VariableTampon.containsKey(Element))
            {
                VariableTampon.put(Element, Value);
            }
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < VariableTampon.size(); i++) {


                bw.write(VariableTampon.keySet().toArray()[i]+":"+VariableTampon.values().toArray()[i]);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean existe()
    {
        return Files.exists(Path.of("src/Ressources/sauvegarde.txt"));
    }

    public static boolean CopieExiste()
    {
        return Files.exists(Path.of(System.getProperty("user.home") + "/sauvegarde.txt"));
    }

    public static void PrendreCopie()
    {
        try {
            Scanner Originale = new Scanner(new File(System.getProperty("user.home")+"/sauvegarde.txt"));

            File file = new File("src/Ressources/sauvegarde.txt");
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            while(Originale.hasNextLine())
            {
                String LigneCourrante = Originale.nextLine();
                byte[] decodedBytes = Base64.getDecoder().decode(LigneCourrante);
                String decodedString = new String(decodedBytes);
                bw.write(decodedString);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
