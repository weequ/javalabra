/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.lauta;

/**
 *
 * @author Antti
 */
public class Ruudukko {
    Ruutu[][] ruudukko;
    
    public Ruudukko() {
        ruudukko = new Ruutu[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ruudukko[y][x] = new Ruutu(x, y);
            }
        }
        asetaNappulat();
    }
    
    public Ruutu getRuutu(int x, int y) {
        return ruudukko[y][x];
    }
    
    private void asetaNappulat() {
        
    }
}
