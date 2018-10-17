package sovellus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
import java.net.*;
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class BonusSanasto {
    List<String> sanasto;
    
    public BonusSanasto() throws Exception {
        sanasto = new ArrayList();
        URL url = new URL("https://gist.githubusercontent.com/deekayen/4148741/raw/01c6252ccc5b5fb307c1bb899c95989a8a284616/1-1000.txt");
        URLConnection conn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        reader.lines().forEach(l -> {
            if (l.length() > 2) {
                sanasto.add(l);
            }
        });
    }
    
    public List<String> getSanasto() {
        return sanasto;
    }
}
