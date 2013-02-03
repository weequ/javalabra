package logiikka.lauta;

import logiikka.nappulat.Nappula;

/**
 * Ruutu määrittelee yksittäiselle shakkilaudan ruudulle ominaisuuksia.
 * @author Antti
 */
public class Ruutu {
    private Ruudukko ruudukko;
    private int x;
    private int y;
    private Nappula nappula;
    
    public Ruutu(int x, int y, Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.x = x;
        this.y = y;
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko;
    }
    
    public Nappula getNappula() {
        return this.nappula;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }
}
