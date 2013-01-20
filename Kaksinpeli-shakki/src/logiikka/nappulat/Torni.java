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
public class Torni extends Nappula {
    private final static char TALLENNUSMERKKI = 't';
    public Torni(Vari vari) {
        super(vari);
        kaveleTaiSyo = new Point[4];
        kaveleTaiSyo[0] = new Point(0, 1);
        kaveleTaiSyo[1] = new Point(1, 0);
        kaveleTaiSyo[2] = new Point(0, -1);
        kaveleTaiSyo[3] = new Point(-1, 0);
        maxAskeleet = 8;
    }

    @Override
    public char getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
}
