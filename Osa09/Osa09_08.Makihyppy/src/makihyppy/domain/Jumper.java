/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy.domain;

/**
 *
 * @author Santtu
 */
import java.util.ArrayList;
import java.util.List;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private List<Integer> jumps;
    private int points;
    
    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.jumps = new ArrayList();
    }
    
    public String getName() {
        return name;
    }
    
    public int getPoints() {
        return points;
    }
    
    public List<Integer> getJumps() {
        return jumps;
    }
    
    public void addPoints(int points) {
        this.points += points;
    }
    
    public void addJump(int distance) {
        jumps.add(distance);
    }
    
    @Override
    public int compareTo(Jumper jumper) {
        return points - jumper.getPoints();
    }
    
    @Override
    public String toString() {
        return name + " (" + points + " pistettä)"; 
    }
}
