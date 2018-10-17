package sanakirja;

public class Main {
    public static void main(String[] args) {
        
        MuistavaSanakirja sanakirja = new MuistavaSanakirja("src/sanat.txt");
        boolean onnistui = sanakirja.lataa();

        if (onnistui) {
            System.out.println("sanakirjan lataaminen onnistui");
        }

        System.out.println(sanakirja.kaanna("apina"));
        System.out.println(sanakirja.kaanna("ohjelmointi"));
        System.out.println(sanakirja.kaanna("alla oleva"));
    }
}
