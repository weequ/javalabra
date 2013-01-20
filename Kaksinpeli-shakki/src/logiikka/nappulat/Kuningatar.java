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
public class Kuningatar extends Nappula {
    private final static char TALLENNUSMERKKI = 'q';
    public Kuningatar(Vari vari) {
        super(vari);
        kaveleTaiSyo = new Point[8];
        kaveleTaiSyo[0] = new Point(0, 1);
        kaveleTaiSyo[1] = new Point(1, 1);
        kaveleTaiSyo[2] = new Point(1, 0);
        kaveleTaiSyo[3] = new Point(1, -1);
        kaveleTaiSyo[4] = new Point(0, -1);
        kaveleTaiSyo[5] = new Point(-1, -1);
        kaveleTaiSyo[6] = new Point(-1, 0);
        kaveleTaiSyo[7] = new Point(-1, 1);
        
        
        maxAskeleet = 8;
    }


    @Override
    public char getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
}
