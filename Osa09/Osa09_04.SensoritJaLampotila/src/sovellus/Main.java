/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/**
 *
 * @author Santtu
 */
public class Main {
    
    public static void main(String[] args) {
    Sensori kumpula = new Lampomittari();
    Sensori kaisaniemi = new Lampomittari();
    Sensori helsinkiVantaa = new Lampomittari();

    Keskiarvosensori paakaupunki = new Keskiarvosensori();
    paakaupunki.lisaaSensori(kumpula);
    paakaupunki.lisaaSensori(kaisaniemi);
    paakaupunki.lisaaSensori(helsinkiVantaa);

    paakaupunki.paalle();
    System.out.println("lämpötila Pääkaupunkiseudulla "+paakaupunki.mittaa() + " astetta");
    System.out.println("lämpötila Pääkaupunkiseudulla "+paakaupunki.mittaa() + " astetta");
    System.out.println("lämpötila Pääkaupunkiseudulla "+paakaupunki.mittaa() + " astetta");

    System.out.println("mittaukset: "+paakaupunki.mittaukset());
    }
}
