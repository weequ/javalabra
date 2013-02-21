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
public class Torni extends Nappula {
    public final static String TALLENNUSMERKKI = "t";
    
    /**
     * @see Nappula#Nappula(logiikka.joukkueet.Joukkue) 
     */
    public Torni(Joukkue joukkue) {
        super(joukkue);
        kaveleTaiSyo = new Point[4];
        kaveleTaiSyo[0] = new Point(0, 1);
        kaveleTaiSyo[1] = new Point(1, 0);
        kaveleTaiSyo[2] = new Point(0, -1);
        kaveleTaiSyo[3] = new Point(-1, 0);
        maxAskeleet = 8;
    }

    @Override
    public String getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
    
}
