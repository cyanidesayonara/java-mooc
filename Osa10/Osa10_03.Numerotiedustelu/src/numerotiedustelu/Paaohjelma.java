package numerotiedustelu;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        // tee tästä ohjelmasi käynnistyspiste
        // HUOM: ohjelmassa saa luoda Scanner-olion vain kertaalleen
        //String test = "1\npekka\n123\n4\npekka\nida\nhelsinki\n4\njukka\nkorso\nvantaa\n7\nkk";
        TextUI textui = new TextUI(new Scanner(System.in));
        Numerotiedustelu numerotiedustelu = new Numerotiedustelu(textui);
        numerotiedustelu.start();
    }
}
