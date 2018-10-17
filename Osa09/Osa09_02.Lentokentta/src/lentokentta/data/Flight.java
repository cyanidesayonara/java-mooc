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
public class Flight {
    private Plane plane;
    private String origin;
    private String destination;
    
    public Flight(Plane plane, String origin, String destination) {
        this.plane = plane;
        this.origin = origin;
        this.destination = destination;
    }
    
    @Override
    public String toString() {
        return plane + " (" + origin + "-" + destination + ")";
    }
}
