package saannollisetlausekkeet;

public class Tarkistin {

    public Tarkistin() {
        
    }
    
    public boolean onViikonpaiva(String merkkijono) {
        return merkkijono.matches("ma|ti|ke|to|pe|la|su");
    }
    
    public boolean kaikkiVokaaleja(String s) {
        return s.matches("(a|e|i|o|u|y|ä|ö)+");
    }
    
    public boolean kellonaika(String s) {
        return s.matches("(([0-1][0-9])|20|21|22|23):[0-5][0-9]:[0-5][0-9]");
    }
}
