/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.lauta;

import logiikka.nappulat.Nappula;

/**
 *
 * @author Antti
 */
public class Ruutu {
    private Ruudukko ruudukko;
    private int x;
    private int y;
    private Nappula nappula;
    
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko;
    }
    
    public Nappula getNappula() {
        return nappula;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
