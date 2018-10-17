
public class Pallo {

    private double x;
    private double y;
    private double sade;

    public Pallo(double x, double y, double sade) {
        this.x = x;
        this.y = y;
        this.sade = sade;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSade() {
        return sade;
    }

    public void setSade(double sade) {
        this.sade = sade;
    }

    public void liikuta(Liike liike) {
        this.x += liike.getLiikeX();
        this.y += liike.getLiikeY();
    }
}
