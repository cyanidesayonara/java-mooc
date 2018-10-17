package lentokentta;

import java.util.Scanner;
import lentokentta.data.*;
import lentokentta.ui.*;
import lentokentta.logic.*;

public class Main {

    public static void main(String[] args) {
        // Kirjoita pääohjelma tänne. Omien luokkien tekeminen on hyödyllistä.
        Text text = new Text(new Scanner(System.in));
        Logic logic = new Logic(text);
        logic.start();
    }
}
