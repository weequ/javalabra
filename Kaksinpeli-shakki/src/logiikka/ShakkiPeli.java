package logiikka;

import java.util.logging.Level;
import java.util.logging.Logger;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;

/**
 * Isäntäluokka josta käsin on saatavilla kaikki shakkipelin kannalta olennainen tieto.
 * @author Antti
 */
public class ShakkiPeli {
    /**
     * Joukkue kenen vuoro on.
     */
    private Joukkue vuoro;
    
    /**
     * Ruudukko jolla pelataan.
     */
    private Ruudukko ruudukko;
    
    /**
     * Kokoaa ruudukon ja vuoron uudeksi shakkipeliksi
     * @param ruudukko Shakkipelin käyttämä ruudukko.
     * @param vuoro Joukkue kumpi aloittaa.
     */
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
        int siirtomahdollisuuksienMaara = this.vuoro.getSiirtomahdollisuuksienMaara();
        if (this.vuoro.onkoShakattu()) {
            if (siirtomahdollisuuksienMaara == 0) {
                Logger.getGlobal().log(Level.INFO, "Shakkimatti. "+this.vuoro.getVastustaja().toString()+" voitti!");
            } else {
                Logger.getGlobal().log(Level.INFO, this.vuoro.getVastustaja().toString()+" shakkaa!");
            }
        } else if (siirtomahdollisuuksienMaara == 0){
            Logger.getGlobal().log(Level.INFO, "Pattitilanne. Tasapeli!");
        }
    }
    
    /**
     * Vaihtaa vuoron toiselle joukkueelle.
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
