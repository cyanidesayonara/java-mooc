
public class Paaohjelma {

    public static void main(String[] args) {
        // tee testauskoodia tänne
        Pino p = new Pino();
        
        p.lisaa("    *");
        p.lisaa("*********");
        p.lisaa(" *******");
        p.lisaa("  *****");
        p.lisaa("   ***");
        p.lisaa("    *");

        while (p.koko() > 0) {
            System.out.println(p.poista());
        }
    }
}
