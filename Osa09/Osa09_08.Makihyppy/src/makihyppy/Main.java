package makihyppy;

import java.util.Scanner;

import makihyppy.ui.*;
import makihyppy.domain.*;
import makihyppy.logic.*;

public class Main {

    public static void main(String[] args) {
        // Kirjoita pääohjelma tänne. Omien luokkien tekeminen on erittäin hyödyllistä.
        //String test = "Mikael\rMika\r\rhyppaa\rhypppaa\rhyppaa\rlopeta";
        Scanner scanner = new Scanner(System.in);
        TextUI textui = new TextUI(scanner);
        Logic logic = new Logic(textui);
        logic.start();
    }
    
    
}
