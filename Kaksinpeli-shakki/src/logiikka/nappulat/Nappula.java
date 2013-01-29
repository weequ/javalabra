/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;
import logiikka.lauta.Ruutu;

/**
 *
 * @author Antti
 */
public abstract class Nappula {
    
    private Ruutu ruutu;
    private Joukkue joukkue;
    protected ArrayList<Ruutu> siirtoMahdollisuudet;
    
    protected Point[] kaveleTaiSyo;
    protected int maxAskeleet;
    
    
    public abstract char getTallennusMerkki();
    public abstract BufferedImage getKuva();
    
    public Nappula(Joukkue joukkue) {
        this.joukkue = joukkue;
    }
    
    public void laskeSiirtoMahdollisuudet(boolean tarkista) {//Sotilas ylikirjoittaa tämän
        ArrayList<Ruutu> tulos = new ArrayList<>();
        Ruudukko r = ruutu.getRuudukko();
        for (int siirto = 0; siirto < kaveleTaiSyo.length; siirto++) {
            for (int askeleet = 1; askeleet <= maxAskeleet; askeleet++) {
                Ruutu kasiteltavaRuutu = r.getRuutu(this.ruutu.getX()+kaveleTaiSyo[siirto].x*askeleet, this.ruutu.getY()+kaveleTaiSyo[siirto].y*askeleet);
                if (kasiteltavaRuutu == null) break;
                if (kasiteltavaRuutu.getNappula() == null) {
                    tulos.add(kasiteltavaRuutu);
                    continue;
                } else {
                    if (!kasiteltavaRuutu.getNappula().getJoukkue().equals(this.ruutu.getNappula().getJoukkue())) {
                        tulos.add(kasiteltavaRuutu);
                    }
                    break;
                }
            }
        }
        siirtoMahdollisuudet = tulos;
    }
    
    public ArrayList<Ruutu> getSiirtoMahdollisuudet() {
        return siirtoMahdollisuudet;
    }

    public void setRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }
    
    public Ruutu getRuutu() {
        return ruutu;
    }
    
    public Joukkue getJoukkue() {
        return joukkue;
    }
    
    public static Nappula luoNappula(String merkki) throws Exception {
        if (merkki.equals("aa")) return null;
        Joukkue nappulanJoukkue = Joukkue.getJoukkue(merkki.charAt(0));
        
        switch (merkki.charAt(1)) {
            case Kuningas.TALLENNUSMERKKI:
                return new Kuningas(nappulanJoukkue);
            case Kuningatar.TALLENNUSMERKKI:
                return new Kuningatar(nappulanJoukkue);
            case Torni.TALLENNUSMERKKI:
                return new Torni(nappulanJoukkue);
            case Lahetti.TALLENNUSMERKKI:
                return new Lahetti(nappulanJoukkue);
            case Ratsu.TALLENNUSMERKKI:
                return new Ratsu(nappulanJoukkue);
            case Sotilas.TALLENNUSMERKKI:
                return new Sotilas(nappulanJoukkue);
            default: 
                return null;
        }
    }
}
