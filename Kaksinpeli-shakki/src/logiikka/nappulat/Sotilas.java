/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import java.awt.Point;
import java.util.ArrayList;
import logiikka.lauta.Ruudukko;
import logiikka.lauta.Ruutu;

/**
 *
 * @author Antti
 */
public class Sotilas extends Nappula {//Ei koodattu ohilyontimahdollisuutta
    private final static char TALLENNUSMERKKI = 's';
    private final Point[] kavele = null;
    private final Point[] syo = null;

    public Sotilas(Vari vari) {
        super(vari);
    }

    @Override
    public ArrayList<Ruutu> laskeSiirtoMahdollisuudet() {
        Ruutu ruutu = getRuutu();
        Ruudukko ruudukko = ruutu.getRuudukko();
        Vari vari = getVari();
        if (vari.equals(Vari.MUSTA)) {
            ruudukko.getRuutu(ruutu.getX(), ruutu.getY());
        } else if (vari.equals(Vari.VALKOINEN)) {
            ruudukko.getRuutu(ruutu.getX(), ruutu.getY());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public char getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
}
