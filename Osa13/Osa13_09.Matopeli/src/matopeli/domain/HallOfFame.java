/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santtu
 */
public class HallOfFame {
    private static Path path = new File("hof.csv").toPath();
    
    public static String lisaaTulos(String nimi, int tulos) {
        // luo tiedosto jos ei ole
        luoTiedosto();
        
        // lue tiedosto listalle
        List<String> tulokset = lueTiedosto();
        
        // järjestä lista tulosten mukaan
        tulokset.stream()
                .map(t -> t.split(","))
                .sorted((t1, t2) -> Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]))
                .map(t -> t[0] + "," + t[1]);
        
        // käy tulokset läpi
        for (int i = 0; i < tulokset.size(); i++) {
            int verrattava = Integer.parseInt(tulokset.get(i).split(",")[1]);
            
            // jos annettu tulos on parempi kuin verrattava...
            if (tulos > verrattava) {
                
                // ...lisää tulos sen indeksiin...
                tulokset.add(i, nimi + "," + tulos);
                
                // ... ja kirjoita tiedosto
                kirjotaTiedosto(tulokset);
                
                // palauta lopuksi rimpsu
                return (i + 1) + "," + nimi + "," + tulos;
            }
        }

        // jos jäi viimeiseksi (tai tyhjä lista), lisää, kirjoita, palauta
        tulokset.add(nimi + "," + tulos);
        kirjotaTiedosto(tulokset);
        return (tulokset.size()) + "," + nimi + "," + tulos;
    }
    
    public static List<String> getTulokset() {
        List<String> tulokset = lueTiedosto();
        
        // palauta max 10 parasta tulosta
        return (tulokset.size() > 10) ? tulokset.subList(0, 10) : tulokset;
    }
    
    public static void luoTiedosto() {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Tiedostoa ei voi luoda");
            }
        }
    }
    
    public static List<String> lueTiedosto() {
        List<String> tulokset = new ArrayList();
        try {
            tulokset = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Tiedostoa ei voi lukea");
        }
        return tulokset;
    }
    
    public static void kirjotaTiedosto(List<String> tulokset) {
        try {
            Files.write(path, tulokset);
        } catch (IOException e) {
            System.out.println("Tiedostoa ei voi kirjoittaa");
        }
    }
}
