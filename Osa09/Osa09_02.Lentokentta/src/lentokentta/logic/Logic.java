/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokentta.logic;

/**
 *
 * @author Santtu
 */
import lentokentta.ui.Text;
import lentokentta.data.Airport;

public class Logic {
    private Text text;
    private Airport airport;
    
    public Logic(Text text) {
        this.text = text;
        this.airport = new Airport();
    }
    
    public void start() {
        welcome();
        control();
        header();
        service();
    }
    
    public boolean control() {
        while (true) {
            String command = text.airportControl();
            switch(command) {
                case "1":
                    addPlane();
                    break;
                case "2":
                    addFlight();
                    break;
                case "x":
                    return false;
            }
        }
        
    }

    public void welcome() {
        text.welcome();
    }
    
    public void addPlane() {
        String[] plane = text.addPlane();
        airport.addPlane(plane[0], plane[1]);
    }
    
    public void addFlight() {
        String[] flight = text.addFlight();
        airport.addFlight(flight[0], flight[1], flight[2]);
    }
    
    public void header() {
        text.header();
    }
    
    public boolean service() {
        while (true) {
            String command = text.flightService();
            switch (command) {
                case "1":
                    printAllPlanes();
                    break;
                case "2":
                    printFlights();
                    break;
                case "3":
                    printPlane();
                    break;
                case "x":
                    return false;
            }
        }
    }
    
    public void printAllPlanes() {
        airport.getPlanes().values().stream()                
                            .forEach(p -> System.out.println(p));
    }
    
    public void printFlights() {
        airport.getFlights().stream()                
                            .forEach(p -> System.out.println(p));
    }
    
    public void printPlane() {
        String plane = text.printPlane();
        System.out.println(airport.getPlanes().get(plane));
    }
    
    
}
