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
public class Plane {
    private String name;
    private String capacity;
    
    public Plane(String name, String capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " henkilöä)";
    }
}
