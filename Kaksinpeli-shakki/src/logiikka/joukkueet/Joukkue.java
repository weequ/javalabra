/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.joukkueet;

import java.util.ArrayList;
import logiikka.lauta.Ruutu;
import logiikka.nappulat.Kuningas;
import logiikka.nappulat.Nappula;

/**
 * Määrittelee joukkueelle yhteisiä ominaisuuksia ja metodeita.
 * Joukkuita ovat musta ja valkoinen.
 * @author Antti
 */
public class Joukkue {
    public static Joukkue MUSTA = new Joukkue('m');
    public static Joukkue VALKOINEN = new Joukkue('v');
    
    private ArrayList<Nappula> nappulat;
    private Kuningas kuningas;
    private final char TALLENNUSMERKKI;
    
    private Joukkue(char tallennusMerkki) {
        nappulat = new ArrayList<>();
        this.TALLENNUSMERKKI = tallennusMerkki;
        kuningas = null;
    }
    
    public char getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
    
    public void addNappula(Nappula nappula) {
        nappulat.add(nappula);
    }
    
    public boolean removeNappula(Nappula nappula) {
        return nappulat.remove(nappula);
    }
    
    public static Joukkue getJoukkue(char TALLENNUSMERKKI) throws Exception {
        if (TALLENNUSMERKKI == Joukkue.MUSTA.getTallennusMerkki()) {
            return Joukkue.MUSTA;
        } else if (TALLENNUSMERKKI == Joukkue.VALKOINEN.getTallennusMerkki()) {
            return Joukkue.VALKOINEN;
        } else {
            throw new Exception("Vääränlainen tallennusmerkki.");
        }
    }
    
    public Kuningas getKuningas() {
        return this.kuningas;
    }
    
    
    public void setKuningas(Kuningas kuningas) {
        this.kuningas = kuningas;
    }
    
    public void laskeSiirtoMahdollisuudet(boolean tarkista) {
        for (Nappula nappula : nappulat) {
            nappula.laskeSiirtoMahdollisuudet(tarkista);
        }
    }
    
    public Joukkue getVastustaja() {
        if (this.equals(Joukkue.VALKOINEN)) {
            return Joukkue.MUSTA;
        } else {
            return Joukkue.VALKOINEN;
        }
    }
    
    public boolean shakkaako() {
        return getVastustaja().getKuningas().onkoUhattu();//onkoSiirtoMahdollisuuksissa(getVastustaja().getKuningas());
    }
    
    public boolean onkoShakattu() {
        return getVastustaja().shakkaako();
    }
    
    public boolean onkoSiirtoMahdollisuuksissa(Ruutu ruutu) {
        for (Nappula omaNappula : nappulat) {
            if (omaNappula.getSiirtoMahdollisuudet().contains(ruutu)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onkoSiirtoMahdollisuuksissa(Nappula nappula) {
        Ruutu nappulanRuutu = nappula.getRuutu();
        return onkoSiirtoMahdollisuuksissa(nappulanRuutu);
    }
}
