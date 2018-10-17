/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokentta.data;

/**
 *
 * @author Santtu
 */
import java.util.*;

public class Airport {
    private Map<String, Plane> planes;
    private List<Flight> flights;
    
    public Airport() {
        this.planes = new HashMap<>();
        this.flights = new ArrayList<>();
    }
    
    public void addPlane(String name, String capacity) {
        this.planes.put(name, new Plane(name, capacity));
    }
    
    public void addFlight(String name, String origin, String destination) {
        Plane plane = planes.get(name);
        this.flights.add(new Flight(plane, origin, destination));
    }
    
    public Map<String, Plane> getPlanes() {
        return planes;
    }
    
    public List<Flight> getFlights() {
        return flights;
    }
}
