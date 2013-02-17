/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import kayttoliittyma.Kuvat;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;
import logiikka.lauta.Ruutu;

/**
 * @see Nappula
 * @author Antti
 */
public class Sotilas extends Nappula {//Ei koodattu ohilyontimahdollisuutta
    public final static String TALLENNUSMERKKI = "s";
    private Point[] kavele = new Point[] {new Point(0, -1)};
    private static Point[] syo = new Point[] {new Point(-1, -1), new Point(1, -1)};

    public Sotilas(Joukkue joukkue) {
        super(joukkue);
        kaveleTaiSyo = new Point[0];
    }
    
    public boolean onkoLiikkunut() {
        if (getJoukkue().equals(Joukkue.MUSTA)) {
            return getRuutu().getY() != 1;
        } else {
            return getRuutu().getY() != 6;
        }
    }

    @Override
    public void laskeSiirtoMahdollisuudet(boolean tarkista) {
        siirtoMahdollisuudet.clear();
        Ruutu ruutu = getRuutu();
        Ruudukko ruudukko = ruutu.getRuudukko();
        Joukkue joukkue = getJoukkue();
        if (!onkoLiikkunut()) {
            kavele = new Point[] {new Point(0, -1), new Point(0, -2)};
        } else {
            kavele = new Point[] {new Point(0, -1)};
        }
        final int kerroin;
        if (joukkue == Joukkue.MUSTA) {
            kerroin = -1;
        } else {
            kerroin = 1;
        }
        for (int i = 0; i < kavele.length; i++) {
            Ruutu kasiteltavaRuutu = ruudukko.getRuutu(ruutu.getX()+kavele[i].x, ruutu.getY()+kavele[i].y*kerroin);
            if (kasiteltavaRuutu == null) continue;
            if (kasiteltavaRuutu.getNappula() == null) {
                lisaaSiirtoMahdollisuus(kasiteltavaRuutu, tarkista);
            } else break;
        }
        for (int i = 0; i < syo.length; i++) {
            Ruutu kasiteltavaRuutu = ruudukko.getRuutu(ruutu.getX()+syo[i].x, ruutu.getY()+syo[i].y*kerroin);
            if (kasiteltavaRuutu == null) continue;
            Nappula kasiteltavaNappula = kasiteltavaRuutu.getNappula();
            if (kasiteltavaNappula == null) continue;
            if (kasiteltavaNappula.getJoukkue() != this.getJoukkue()) lisaaSiirtoMahdollisuus(kasiteltavaRuutu, tarkista);
        }
    }

    @Override
    public String getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }

    @Override
    public BufferedImage getKuva() {
        if (this.getJoukkue().equals(Joukkue.MUSTA)) {
            return Kuvat.MUSTA_SOTILAS;
        } else {
            return Kuvat.VALKOINEN_SOTILAS;
        }
    }
}
