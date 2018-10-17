/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
import java.util.ArrayList;

public class Puhelinmuistio {
    private ArrayList<Henkilo> henkilot;
    

    public Puhelinmuistio() {
        this.henkilot = new ArrayList<>();
    }
    
    public void lisaa(String nimi, String numero) {
        Henkilo henkilo = new Henkilo(nimi, numero);
        this.henkilot.add(henkilo);
    }
    
    public void tulostaKaikki() {
        int i = 0;
        while (i < this.henkilot.size()) {
            System.out.println(henkilot.get(i));
            i++;
        }
    }
    
    public String haeNumero(String nimi) {
        int i = 0;
        while (i < henkilot.size()) {
            Henkilo henkilo = henkilot.get(i);
            if (henkilo.haeNimi() == nimi) {
                return henkilo.haeNumero();
            }
            i++;
        }
        return "numero ei tiedossa";
    }
} 
