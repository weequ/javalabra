/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

/**
 *
 * @author Antti
 */
public class Vari {
    private char tallennusMerkki;
    
    public final static Vari MUSTA = new Vari('m');
    public final static Vari VALKOINEN = new Vari('v');
    
    private Vari(char tallennusMerkki) {
        this.tallennusMerkki = tallennusMerkki;
    }
    
    
    public char getTallennusMerkki() {
        return tallennusMerkki;
    }
    
}
