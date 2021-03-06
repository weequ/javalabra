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
 * @see Nappula
 * @author Antti
 */
public class Ratsu extends Nappula {
    public final static String TALLENNUSMERKKI = "r";
    
    /**
     * @see Nappula#Nappula(logiikka.joukkueet.Joukkue) 
     */
    public Ratsu(Joukkue joukkue) {
        super(joukkue);
        kaveleTaiSyo = new Point[8];
        kaveleTaiSyo[0] = new Point(1, 2);
        kaveleTaiSyo[1] = new Point(2, 1);
        kaveleTaiSyo[2] = new Point(2, -1);
        kaveleTaiSyo[3] = new Point(1, -2);
        kaveleTaiSyo[4] = new Point(-1, -2);
        kaveleTaiSyo[5] = new Point(-2, -1);
        kaveleTaiSyo[6] = new Point(-2, 1);
        kaveleTaiSyo[7] = new Point(-1, 2);
        maxAskeleet = 1;
    }

    @Override
    public String getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }

}
