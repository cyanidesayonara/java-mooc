package asteroids.domain;

import java.util.Arrays;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
Tämän luokan sisäiseen toteutukseen ei tarvitse tutustua sen tarkemmin. Metodien
nimet tarjoavat todennäköisesti hyvän kuvan niiden toiminnasta. 
    
Metodien sisäisen toteutuksen ymmärtäminen ei ole tarpeen tämän kurssin 
puitteissa. Jos peleissä käytettävä matematiikka kiinnostaa, kannattaa tutustua 
Helsingin yliopistolla tarjottavaan kurssiin "Johdatus yliopistomatematiikkaan" 
sekä lukea kirja "Essential Mathematics for Games and Interactive Applications".
 */
public class Monikulmio extends Liikkuva {

    // monikulmio muodostuu järjestetystä joukosta pisteitä
    protected Piste[] kulmat;
    // jokaisella monikulmiolla on sijainti
    // protected Piste sijainti;
    // jokaista monikulmiota voi kääntää -- nolla astetta osoittaa tässä itään
    // protected double kaannosAsteina;

    public Monikulmio(Piste[] kulmat, Piste sijainti, Piste liike, double kaannosAsteina, double kaannosliike) {
        super(sijainti, liike, kaannosAsteina, kaannosliike);
        this.kulmat = kulmat;
    }

    /**
     * Palauttaa monikulmion kulmat. Kulmat ovat muutettu vastaamaan monikulmion
     * sijaintia sekä käännöstä.
     * @return 
     */
    public Piste[] kulmat() {
        Piste keski = keskipiste();

        Piste[] monikulmionKulmatKaannettyna = new Piste[kulmat.length];

        for (int i = 0; i < kulmat.length; i++) {
            Piste p = kulmat[i];

            double x = ((p.getX() - keski.getX()) * Math.cos(Math.toRadians(kaannosAsteina)))
                    - ((p.getY() - keski.getY()) * Math.sin(Math.toRadians(kaannosAsteina)))
                    + keski.getX() / 2 + sijainti.getX();
            double y = ((p.getX() - keski.getX()) * Math.sin(Math.toRadians(kaannosAsteina)))
                    + ((p.getY() - keski.getY()) * Math.cos(Math.toRadians(kaannosAsteina)))
                    + keski.getY() / 2 + sijainti.getY();

            monikulmionKulmatKaannettyna[i] = new Piste(x, y);
        }
        return monikulmionKulmatKaannettyna;
    }

    public boolean sisaltaa(Piste piste) {
        Piste[] pisteet = kulmat();
        double crossingNumber = 0;
        for (int i = 0, j = 1; i < kulmat.length; i++, j = (j + 1) % kulmat.length) {
            if ((((pisteet[i].getX() < piste.getX()) && (piste.getX() <= pisteet[j].getX()))
                    || ((pisteet[j].getX() < piste.getX()) && (piste.getX() <= pisteet[i].getX())))
                    && (piste.getY() > pisteet[i].getY() + (pisteet[j].getY() - pisteet[i].getY())
                    / (pisteet[j].getX() - pisteet[i].getX()) * (piste.getX() - pisteet[i].getX()))) {
                crossingNumber++;
            }
        }

        return crossingNumber % 2 == 1;
    }


    public double ala() {
        double sum = 0;
        for (int i = 0, j = 1; i < kulmat.length; i++, j = (j + 1) % kulmat.length) {
            sum += kulmat[i].getX() * kulmat[j].getY() - kulmat[j].getX() * kulmat[i].getY();
        }
        return Math.abs(sum / 2);
    }

    public Piste keskipiste() {
        double x = 0.0;
        double y = 0.0;

        for (int i = 0, j = 1; i < kulmat.length; i++, j = (j + 1) % kulmat.length) {
            x += (kulmat[i].getX() + kulmat[j].getX())
                    * (kulmat[i].getX() * kulmat[j].getY() - kulmat[j].getX() * kulmat[i].getY());
            y += (kulmat[i].getY() + kulmat[j].getY())
                    * (kulmat[i].getX() * kulmat[j].getY() - kulmat[j].getX() * kulmat[i].getY());
        }

        Piste keskipiste = new Piste(x, y);

        double ala = ala();
        return new Piste(Math.abs(keskipiste.getX() / (6 * ala)), Math.abs(keskipiste.getY() / (6 * ala)));
    }
    
    public boolean tormaa(Monikulmio toinen) {
        return Arrays.asList(toinen.kulmat()).stream().map(p -> sisaltaa(p)).filter(b -> b == true).count() > 0;
    }
    
    public void piirra(GraphicsContext gc) {
        Piste[] pisteet = kulmat();

        gc.setStroke(Color.WHITE);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(2);

        gc.beginPath();
        gc.moveTo(pisteet[0].getX(), pisteet[0].getY());

        for (int i = 1; i < pisteet.length; i++) {
            gc.lineTo(pisteet[i].getX(), pisteet[i].getY());
        }

        gc.lineTo(pisteet[0].getX(), pisteet[0].getY());
        gc.closePath();

        gc.stroke();
        gc.fill();
    }
}
