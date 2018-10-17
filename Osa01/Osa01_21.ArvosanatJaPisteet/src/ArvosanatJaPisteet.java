
import java.util.Scanner;

public class ArvosanatJaPisteet {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna pisteet [0-100]: ");
        int pojot = Integer.parseInt(lukija.nextLine());
        
        if (pojot > 100) {
            System.out.println("\nArvosana: uskomatonta!");
        } else if (pojot > 90) {
            System.out.println("\nArvosana: 5");
        } else if (pojot > 80) {
            System.out.println("\nArvosana: 4");
        } else if (pojot > 70) {
            System.out.println("\nArvosana: 3");
        } else if (pojot > 60) {
            System.out.println("\nArvosana: 2");
        } else if (pojot > 50) {
            System.out.println("\nArvosana: 1");
        } else if (pojot >= 0) {
            System.out.println("\nArvosana: hylätty");
        } else {
            System.out.println("\nArvosana: mahdotonta!");
        }           
    }
}
