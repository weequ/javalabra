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
public abstract class Nappula {
    
    private Ruutu ruutu;
    private Vari vari;
    
    protected Point[] kaveleTaiSyo;
    protected int maxAskeleet;
    
    
    public abstract char getTallennusMerkki();
    
    public ArrayList<Ruutu> laskeSiirtoMahdollisuudet() {//Sotilas ylikirjoittaa tämän
        ArrayList<Ruutu> tulos = new ArrayList<Ruutu>();
        for (int siirto = 0; siirto < kaveleTaiSyo.length; siirto++) {
            for (int askeleet = 1; askeleet < maxAskeleet; askeleet++) {
                Ruudukko r = ruutu.getRuudukko();
                Ruutu kasiteltavaRuutu = r.getRuutu(this.ruutu.getX()+kaveleTaiSyo[0].x, this.ruutu.getY()+kaveleTaiSyo[0].y);
                if (kasiteltavaRuutu.getNappula() == null) {
                    tulos.add(kasiteltavaRuutu);
                    continue;
                } else {
                    if (!kasiteltavaRuutu.getNappula().getVari().equals(this.ruutu.getNappula().getVari())) {
                        tulos.add(kasiteltavaRuutu);
                    }
                    break;
                }
            }
        }
        return tulos;
    }
    
    public Nappula(Vari vari) {
        this.vari = vari;
    }
    
    
    public void setRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }
    
    public Ruutu getRuutu() {
        return ruutu;
    }
    
    public Vari getVari() {
        return vari;
    }
}
