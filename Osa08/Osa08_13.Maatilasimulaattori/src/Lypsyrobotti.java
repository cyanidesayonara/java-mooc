public class Lypsyrobotti {
    private Maitosailio tankki;
    
    public Lypsyrobotti() {
        
    }
    
    public Maitosailio getMaitosailio() {
        return this.tankki;
    }
    
    public void setMaitosailio(Maitosailio maitosailio) {
        this.tankki = maitosailio;
    }
    
    public void lypsa(Lypsava lypsava) {
        if (this.getMaitosailio() == null) {
            System.out.println("Maidot menevät hukkaan!");
            lypsava.lypsa();
        } else {
            this.tankki.lisaaSailioon(lypsava.lypsa());
        }
    }
}
