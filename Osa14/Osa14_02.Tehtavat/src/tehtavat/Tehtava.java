/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehtavat;

/**
 *
 * @author Santtu
 */
public class Tehtava {
    private String name;
    private boolean done;
    
    public Tehtava(String name) {
        this.name = name;
        done = false;
    }
     
    public String getName() {
        return name;
    }
    
    public void doTask() {
        done = true;
    }
    
    public boolean doneOrNah() {
        return done;
    }
    
}
