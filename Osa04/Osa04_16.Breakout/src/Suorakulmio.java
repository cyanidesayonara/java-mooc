
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Suorakulmio {

    private int x;
    private int y;
    private int leveys;
    private int korkeus;
    private Color vari;

    public Suorakulmio(int x, int y, int leveys, int korkeus, Color vari) {
        this.x = x;
        this.y = y;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.vari = vari;
    }
    
    // kertoo onko annettu piste suorakulmion ulkopuolella
    public boolean ulkopuolella(int x, int y) {
        if(x < this.x || x > this.x + this.leveys) {
            return true;
        }
        
        if(y < this.y || y > this.y + this.korkeus) {
            return true;
        }
        
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public Color getVari() {
        return vari;
    }

    public void setVari(Color vari) {
        this.vari = vari;
    }

}
