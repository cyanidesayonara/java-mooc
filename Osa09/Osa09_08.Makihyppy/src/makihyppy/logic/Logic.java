/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy.logic;

/**
 *
 * @author Santtu
 */
import makihyppy.ui.TextUI;
import makihyppy.domain.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Logic {
    private TextUI textui;
    private Contest contest;
    
    public Logic(TextUI textui) {
        this.textui = textui;
        this.contest = new Contest();
    }
    
    public void start() {
        textui.welcome();
        
        while (true) {
            String jumper = textui.jumpers();
            if (jumper.isEmpty()) {
                break;
            }
            contest.addJumper(jumper);
        }
        
        textui.intro();
        
        while (true) {
            String command = textui.select();
            if (command.equals("hyppaa")) {
                jump();
            }
            if (command.equals("lopeta")) {
                break;
            }
            contest.newRound();
        }
        
        textui.end();
        end();
    }
    
    public void jump() {
        textui.round(contest.getRound());
        
        ArrayList<Jumper> jumpers  = contest.getJumpersInOrderByLeastPoints().stream()
                .collect(Collectors.toCollection(ArrayList::new));
        
        for (int i = 1; i <= jumpers.size(); i++) {
            System.out.println("  " + i + ". " + jumpers.get(i - 1));
        }
        
        System.out.println("\nKierroksen " + contest.getRound() + " tulokset");
        
        for (int i = 0; i < jumpers.size(); i++) {
            System.out.println("  " + jumpers.get(i).getName());
            int distance = contest.jump();
            System.out.println("    pituus: " + distance);
            jumpers.get(i).addPoints(distance);
            jumpers.get(i).addJump(distance);
            List<Integer> points = contest.judges();
            System.out.println("    tuomaripisteet: " + points + "\n");
            jumpers.get(i).addPoints(calculatePoints(points));
       }
    }
    
    public int calculatePoints(List<Integer> points) {
        ArrayList<Integer> sortedPoints = points.stream().sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        sortedPoints.remove(0);
        sortedPoints.remove(sortedPoints.size() - 1);
        return sortedPoints.stream().mapToInt(p -> p).sum();
    }
    
    public void end() {
        ArrayList<Jumper> jumpers  = contest.getJumpersInOrderByMostPoints().stream()
                .collect(Collectors.toCollection(ArrayList::new));
  
        for (int i = 0; i < jumpers.size(); i++) {
            System.out.println((i + 1) + "       " + jumpers.get(i));
            System.out.print("          hyppyjen pituudet:");
            jumpers.get(i).getJumps().forEach(j -> System.out.print(" " + j + " m,"));
            System.out.println("\b"); 
        }
    }
}
