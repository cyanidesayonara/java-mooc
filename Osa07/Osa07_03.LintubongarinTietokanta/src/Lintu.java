public class Lintu {
    private String nimi;
    private String latNimi;
    
    public Lintu(String nimi, String latNimi) {
        this.nimi = nimi;
        this.latNimi = latNimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public String getLatNimi() {
        return latNimi;
    }
    
    @Override
    public String toString() {
        return getNimi() + " (" + getLatNimi() + "): ";
    }
}
