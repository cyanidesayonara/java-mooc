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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Contest {
    private List<Jumper> jumpers;
    private Random random;
    private int round;
    
    public Contest() {
        jumpers = new ArrayList<>();
        random = new Random();
        round = 1;
    }
    
    public void addJumper(String name) {
        jumpers.add(new Jumper(name));
    }
   
    public List<Jumper> getJumpersInOrderByLeastPoints() {
        Collections.sort(jumpers);
        return jumpers;
    }
    
    public List<Jumper> getJumpersInOrderByMostPoints() {
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        return jumpers;
    }
    
    public int getRound() {
        return round;
    }
    
    public void newRound() {
        round++;
    }
    
    public int jump() {
        return random.nextInt(61) + 60;
    }
    
    public List<Integer> judges() {
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            points.add(random.nextInt(11) + 10);
        }
        return points;
    }
}
