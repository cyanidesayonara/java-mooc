/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

/**
 *
 * @author Santtu
 */
import java.util.*;

public class Liikkuva {
    protected int x;
    protected int y;
    protected int leveys;
    protected int korkeus;

    public Liikkuva(int x, int y, int leveys, int korkeus) {
        this.x = x;
        this.y = y;
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean onKoordinaateissa(int x, int y) {
        return (this.x == x && this.y == y);
    }
    
    public boolean onSamassaRuudussa(Hahmo hahmo) {
        return (this.x == hahmo.x && this.y == hahmo.y);
    }
    
    public int[] liiku(Random random) {
        int[] xy = new int[2];
        switch(random.nextInt(3)) {
            case 0:
                if (y > 0) {
                    xy[0] = x;
                    xy[1] = y - 1;
                    break;
                }
            case 1:
                if (x > 0) {
                    xy[0] = x - 1;
                    xy[1] = y;
                    break;
                }
            case 2:
                if (y < korkeus - 1) {
                    xy[0] = x;
                    xy[1] = y + 1;
                    break;
                }
            case 3:
                if (x < leveys - 1) {
                    xy[0] = x + 1;
                    xy[1] = y;
                    break;
                }
        }
        return xy;
    }
    
    public void liiku(char komento) {
        switch (komento) {
            case 'w':
                liikuYlos();
                break;
            case 'a':
                liikuVasen();
                break;
            case 's':
                liikuAlas();
                break;
            case 'd':
                liikuOikea();
                break;
        }
    }
    
    public void liikuYlos() {
        if (y > 0) {
            setY(y - 1);
        }
    }
    
    public void liikuVasen() {
        if (x > 0) {
            setX(x - 1);
        }
    }
    
    public void liikuAlas() {
        if (y < korkeus - 1) {
            setY(y + 1);
        }
    }
    
    public void liikuOikea() {
        if (x < leveys - 1) {
            setX(x + 1);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Liikkuva other = (Liikkuva) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return x + " " + y;
    }
}