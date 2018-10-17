
public class Main {

    public static void main(String[] args) {
        // Testaa ohjelmasi toimintaa täällä!
        Kirjasto kirjasto = new Kirjasto();

        kirjasto.lisaaKirja(new Kirja("Cheese Problems Solved", "Woodhead Publishing", 2007));
        kirjasto.lisaaKirja(new Kirja("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        kirjasto.lisaaKirja(new Kirja("NHL Hockey", "Stanley Kupp", 1952));
        kirjasto.lisaaKirja(new Kirja("Battle Axes", "Tom A. Hawk", 1851));

        kirjasto.haeKirjaNimekkeella("Cheese").forEach(k -> System.out.println(k));

        System.out.println("---");
        kirjasto.haeKirjaJulkaisijalla("Pong Group").forEach(k -> System.out.println(k));

        System.out.println("---");
        kirjasto.haeKirjaJulkaisuvuodella(1851).forEach(k -> System.out.println(k));
    }
}
