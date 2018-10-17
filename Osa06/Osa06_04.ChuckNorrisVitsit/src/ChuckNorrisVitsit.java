
import java.util.Scanner;
import java.util.ArrayList;
import java.net.URL;

public class ChuckNorrisVitsit {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> arguments = new ArrayList<>();
        ArrayList<String> joke = new ArrayList<>();

        // Toteuta vitsien lukeminen tässä
        while (true) {
            System.out.print("Anna käsky: ");
            String[] kasky = lukija.nextLine().split(" ");

            if (kasky[0].equals("lopeta")) {
                break;
            } else if (kasky[0].equals("satunnainen")) {
                try (Scanner uno = new Scanner(new URL("http://api.icndb.com/jokes/random").openStream())) {
                    while (uno.hasNextLine()) {
                        joke.add(uno.nextLine());
                    }
                    System.out.println(joke);
                    joke.clear();
                } catch (Exception e) {
                    System.out.println("Virhe");
                }
            } else if (kasky[0].equals("vitsi") && !kasky[1].isEmpty()) {
                try (Scanner dos = new Scanner(new URL("http://api.icndb.com/jokes/" + Integer.parseInt(kasky[1])).openStream())) {
                    while (dos.hasNextLine()) {
                        joke.add(dos.nextLine());
                    }
                    System.out.println(joke);
                    joke.clear();
                } catch (Exception e) {
                    System.out.println("Virhe");
                }
            } else {
                System.out.println("Anna yksi seuraavista käskyistä: ");
                System.out.println("(1) satunnainen");
                System.out.println("(2) vitsi [numero]");
                System.out.println("(3) lopeta");
            }
        }
    }
}
