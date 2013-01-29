/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import java.awt.Point;
import java.awt.image.BufferedImage;
import kayttoliittyma.Kuvat;
import logiikka.joukkueet.Joukkue;

/**
 *
 * @author Antti
 */
public class Lahetti extends Nappula {
    public final static char TALLENNUSMERKKI = 'l';
    
    public Lahetti(Joukkue joukkue) {
        super(joukkue);
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

    @Override
    public BufferedImage getKuva() {
        if (this.getJoukkue().equals(Joukkue.MUSTA)) {
            return Kuvat.MUSTA_LAHETTI;
        } else {
            return Kuvat.VALKOINEN_LAHETTI;
        }
    }
}
