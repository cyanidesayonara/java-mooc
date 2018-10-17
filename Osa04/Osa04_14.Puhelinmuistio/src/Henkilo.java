/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Henkilo {
    private String nimi;
    private String numero;
    
    public Henkilo(String nimi, String numero) {
        this.nimi = nimi;
        this.numero = numero;
    }
    
    public String haeNimi() {
        return this.nimi;
    }
    
    public String haeNumero() {
        return this.numero;
    }
    
    public void vaihdaNumeroa(String uusiNumero) {
        this.numero = uusiNumero;
    }
    
    public String toString() {
        return haeNimi() + "  puh: " + haeNumero();
    }
}