import java.util.Collection;

public class Navetta {
    private Maitosailio tankki;
    private Lypsyrobotti robo;

    public Navetta(Maitosailio maitosailio) {
        this.tankki = maitosailio;
    }
    
    public Maitosailio getMaitosailio() {
        return this.tankki;
    }
    
    public void asennaLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        this.robo = lypsyrobotti;
        this.robo.setMaitosailio(getMaitosailio());
    }
    
    public void hoida(Lehma lehma) {
        if (this.robo == null) {
            throw new IllegalStateException("Lypsyrobottia ei asennettu");
        }
        this.robo.lypsa(lehma);
    }
    
    public void hoida(Collection<Lehma> lehmat) {
        lehmat.stream()
                .forEach(l -> hoida(l));
    }
    
    @Override
    public String toString() {
        return "Navetta: " + tankki;
    }
}
