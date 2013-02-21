package logiikka.lauta;

import logiikka.nappulat.Nappula;

/**
 * Ruutu määrittelee yksittäiselle shakkilaudan ruudulle ominaisuuksia. 
 * Ruudulla on koordinaatit ja siihen voi kuulua enintään yksi nappula.
 * @author Antti
 */
public class Ruutu {
    /**
     * Ruudukko johon tämä ruutu kuuluu.
     */
    private Ruudukko ruudukko;
    /**
     * Ruudun koordinaatit. x kasvaa oikealla ja y kasvaa alas.
     */
    private int x, y;
    /**
     * Ruudussa oleva nappula. Null jos ruutu on tyhjä.
     */
    private Nappula nappula;
    
    /**
     * Luo uuden ruutu olion
     * @param x Ruudun x-koordinaatti. Kasvaa vasemmalta oikealle.
     * @param y Ruudun y-koodrinaatti. Kasvaa ylhäältä alaspäin.
     * @param ruudukko Ruudukko johon tämä ruutu kuuluu.
     */
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
    
    @Override
    public String toString() {
        if (nappula == null) {
            return "aa";
        } else {
            return nappula.toString();
        }
    }
}
