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
    
    /**
     * Ruudut johon valkoinen sotilas voi kävellä. Mustalle pätee kun y-koordinaatista otetaan vastaluku.
     */
    private Point[] kavele = new Point[] {new Point(0, -1)};
    
    /**
     * Ruudut johon valkoinen sotilas voi syödä. Mustalle pätee kun y-koordinaatista otetaan vastaluku.
     */
    private static Point[] syo = new Point[] {new Point(-1, -1), new Point(1, -1)};

    
    public Sotilas(Joukkue joukkue) {
        super(joukkue);
        kaveleTaiSyo = new Point[0];
    }
    
    /**
     * Laskee sotilaan siirtomahdollisuudet.
     * @param tarkista 
     */
    @Override
    public void laskeSiirtoMahdollisuudet(boolean tarkista) {
        siirtoMahdollisuudet.clear();
        if (!onkoLiikkunut()) {
            kavele = new Point[] {new Point(0, -1), new Point(0, -2)};
        } else {
            kavele = new Point[] {new Point(0, -1)};
        }
        muunnaKoordinaatit();
        laskeKavelyRuudut(tarkista);
        laskeSyontiRuudut(tarkista);
        
    }
    
    private boolean onkoLiikkunut() {
        if (getJoukkue().equals(Joukkue.MUSTA)) {
            return getRuutu().getY() != 1;
        } else {
            return getRuutu().getY() != 6;
        }
    }
    
    private void laskeKavelyRuudut(boolean tarkista) {
        Ruutu ruutu = getRuutu();
        Ruudukko ruudukko = ruutu.getRuudukko();
        for (int i = 0; i < kavele.length; i++) {
            Ruutu kasiteltavaRuutu = ruudukko.getRuutu(ruutu.getX()+kavele[i].x, ruutu.getY()+kavele[i].y);
            if (kasiteltavaRuutu == null) continue;
            if (kasiteltavaRuutu.getNappula() == null) {
                lisaaSiirtoMahdollisuus(kasiteltavaRuutu, tarkista);
            } else break;
        }
    }
    
    private void laskeSyontiRuudut(boolean tarkista) {
        Ruutu ruutu = getRuutu();
        Ruudukko ruudukko = ruutu.getRuudukko();
        for (int i = 0; i < syo.length; i++) {
            Ruutu kasiteltavaRuutu = ruudukko.getRuutu(ruutu.getX()+syo[i].x, ruutu.getY()+syo[i].y);
            if (kasiteltavaRuutu == null) continue;
            Nappula kasiteltavaNappula = kasiteltavaRuutu.getNappula();
            if (kasiteltavaNappula == null) continue;
            if (kasiteltavaNappula.getJoukkue() != this.getJoukkue()) lisaaSiirtoMahdollisuus(kasiteltavaRuutu, tarkista);
        }
    }
    
    private void muunnaKoordinaatit() {
        final int kerroin;
        if (getJoukkue() == Joukkue.MUSTA) {
            kerroin = -1;
        } else {
            kerroin = 1;
        }
        for (int i = 0; i < kavele.length; i++) {
            kavele[i].y *= kerroin;
        }
        for (int i = 0; i < syo.length; i++) {
            syo[i].y *= kerroin;
        }
    }

    @Override
    public String getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }

}
