/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import java.awt.Point;
import java.util.ArrayList;
import logiikka.lauta.Ruutu;

/**
 *
 * @author Antti
 */
public class Lahetti extends Nappula {
    private final static char TALLENNUSMERKKI = 'l';
    public Lahetti(Vari vari) {
        super(vari);
        kaveleTaiSyo = new Point[4];
        kaveleTaiSyo[0] = new Point(1, 1);
        kaveleTaiSyo[1] = new Point(1, -1);
        kaveleTaiSyo[2] = new Point(-1, 1);
        kaveleTaiSyo[3] = new Point(-1, -1);
        maxAskeleet = 8;
    }

    @Override
    public char getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
}
