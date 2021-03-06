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
    
    private ArrayList<Nappula> elossaOlevatNappulat;
    private Kuningas kuningas;
    
    /**
     * Merkki joka kuvaa tätä joukkuetta tiedostoon tallennettaessa.
     */
    private final char TALLENNUSMERKKI;
    
    private Joukkue(char tallennusMerkki) {
        elossaOlevatNappulat = new ArrayList<>();
        this.TALLENNUSMERKKI = tallennusMerkki;
        kuningas = null;
    }
    
    public char getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
    
    /**
     * Lisää uuden nappulan joukkueelle.
     * @param nappula Nappula joka lisätään joukkueelle.
     */
    public void addNappula(Nappula nappula) {
        elossaOlevatNappulat.add(nappula);
    }
    
    /**
     * Poistaa nappulan joukkueelta. Tätä käytetään kun nappula kuolee.
     * @param nappula Nappula joka yritetään poistaa joukkueelta.
     * @return Onnistuiko poisto eli kuuluiko tämä nappula ylipäänsä tälle joukkueelle.
     */
    public boolean removeNappula(Nappula nappula) {
        return elossaOlevatNappulat.remove(nappula);
    }
    
    /**
     * Palauttaa joukkuuen joka vastaa parametrina annettua tallennusmerkkiä.
     * @param tallennusmerkki Merkkijono jota käytetään kuvamaan joukkuetta tiedostoissa.
     * @return Joukkue jolle parametrina annettu tallennusmerkki kuuluu.
     * @throws Exception Jos parametrina annettu tallennusmerkki ei kuulu kummallekkaan joukkueelle.
     */
    public static Joukkue getJoukkue(char tallennusmerkki) throws IllegalArgumentException {
        if (tallennusmerkki == Joukkue.MUSTA.getTallennusMerkki()) {
            return Joukkue.MUSTA;
        } else if (tallennusmerkki == Joukkue.VALKOINEN.getTallennusMerkki()) {
            return Joukkue.VALKOINEN;
        } else {
            throw new IllegalArgumentException("Vääränlainen tallennusmerkki.");
        }
    }
    
    public Kuningas getKuningas() {
        return this.kuningas;
    }
    
    
    public void setKuningas(Kuningas kuningas) {
        this.kuningas = kuningas;
    }
    
    /**
     * Laskee kaikkien joukkueen nappuloiden siirtomahdollisuudet
     * @param tarkista Tarkistetaanko jokaisella siirtomahdollisuudella syntyykö shakki?
     */
    public void laskeSiirtoMahdollisuudet(boolean tarkista) {
        for (Nappula nappula : elossaOlevatNappulat) {
            nappula.laskeSiirtoMahdollisuudet(tarkista);
        }
    }
    
    /**
     * Palauttaa vastustajan joukkueen.
     * @return Joukkue ketä vastaan pelataan.
     */
    public Joukkue getVastustaja() {
        if (this.equals(Joukkue.VALKOINEN)) {
            return Joukkue.MUSTA;
        } else {
            return Joukkue.VALKOINEN;
        }
    }
    
    /**
     * Shakkaako tämä joukkue eli onko vastustajan kuningas uhattu?
     * @return True jos shakkaa ja false jos ei shakkaa.
     */
    public boolean shakkaako() {
        return getVastustaja().getKuningas().onkoUhattu();//onkoSiirtoMahdollisuuksissa(getVastustaja().getKuningas());
    }
    
    /**
     * Onko tämä joukkue shakissa eli onko oma kunigas uhattu?
     * @return True jos ollaan shakissa ja false jos ei olla.
     */
    public boolean onkoShakattu() {
        return getVastustaja().shakkaako();
    }
    
    /**
     * Kuuluuko parametrina annettu ruutu tämän joukkueen siirtomahdollisuuksiin?
     * @param ruutu Ruutu jonka suhteen tarkistus tehdään.
     * @return True jos ruutu kuuluu siirtomahdollisuuksiin.
     */
    public boolean onkoSiirtoMahdollisuuksissa(Ruutu ruutu) {
        for (Nappula omaNappula : elossaOlevatNappulat) {
            if (omaNappula.getSiirtoMahdollisuudet().contains(ruutu)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Laskee siirtomahdollisuuksien määrän ja palauttaa sen.
     * @return 
     */
    public int getSiirtomahdollisuuksienMaara() {
        int tulos = 0;
        for (Nappula omaNappula : elossaOlevatNappulat) {
            tulos += omaNappula.getSiirtoMahdollisuudet().size();
        }
        return tulos;
    }
    
    /**
     * Kuuluuko parametrina annettu nappula tämän joukkueen siirtomahdollisuuksiin?
     * @param nappula Nappula jonka suhteen tarkistus tehdään.
     * @return True jos nappula kuuluu siirtomahdollisuuksiin.
     */
    public boolean onkoSiirtoMahdollisuuksissa(Nappula nappula) {
        Ruutu nappulanRuutu = nappula.getRuutu();
        return onkoSiirtoMahdollisuuksissa(nappulanRuutu);
    }
    
    @Override
    public String toString() {
        switch (TALLENNUSMERKKI) {
            case 'm': return "Musta";
            case 'v': return "Valkoinen";
            default: return null;
        }
    }
}
