package logiikka;

import kayttoliittyma.GUI;
import kayttoliittyma.Kuvat;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;
import tiedostonKasittely.Lukija;

/**
 * Isäntäluokka josta käsin on saatavilla kaikki shakkipelin kannalta olennainen tieto.
 * @author Antti
 */
public class ShakkiPeli {
    private Joukkue vuoro;
    private Ruudukko ruudukko;
    
    /**
     * Luo uuden shakkipelin aloitusLauta.txt tiedostosta.
     * @throws Exception 
     */
    public ShakkiPeli() throws Exception {
        Lukija lukija = new Lukija("aloitusLauta.txt");
        ruudukko = new Ruudukko(lukija.getText());
        setVuoro(Joukkue.VALKOINEN);
    }
    
    public ShakkiPeli(Ruudukko ruudukko, Joukkue vuoro) {
        this.ruudukko = ruudukko;
        setVuoro(vuoro);
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko;
    }
    
    public Joukkue getVuoro() {
        return vuoro;
    }
    
    /**
     * Vaihtaa vuoron ja päivittää siirtomahdollisuudet.
     * @param vuoro 
     */
    public void setVuoro(Joukkue vuoro) {
        this.vuoro = vuoro;
        this.vuoro.laskeSiirtoMahdollisuudet(true);
        this.vuoro.getVastustaja().laskeSiirtoMahdollisuudet(false);
        if (this.vuoro.onkoShakattu()) System.out.println("Shakki!");
    }
    
    /**
     * Vaihtaa vuoron
     */
    public void vaihdaVuoroa() {
        if (vuoro.equals(Joukkue.MUSTA)) {
            setVuoro(Joukkue.VALKOINEN);
        } else {
            setVuoro(Joukkue.MUSTA);
        }
    }
    
    @Override
    public String toString() {
        return vuoro.getTallennusMerkki()+System.getProperty("line.separator")+ruudukko.toString();
    }
    
}
