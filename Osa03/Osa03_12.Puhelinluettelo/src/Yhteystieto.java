
public class Yhteystieto {

    private String nimi;
    private String puhelinnumero;
    private String katuosoite;

    public Yhteystieto(String nimi, String puhelinnumero, String katuosoite) {
        this.nimi = nimi;
        this.puhelinnumero = puhelinnumero;
        this.katuosoite = katuosoite;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getPuhelinnumero() {
        return puhelinnumero;
    }

    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    public String getKatuosoite() {
        return katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

}
