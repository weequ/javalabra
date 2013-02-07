package logiikka;

import kayttoliittyma.GUI;
import kayttoliittyma.Kuvat;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;
import tiedostonLuku.Lukija;

/**
 * Isäntäluokka josta käsin on saatavilla kaikki shakkipelin kannalta olennainen tieto.
 * @author Antti
 */
public class ShakkiPeli {
    private Joukkue vuoro;
    private Ruudukko ruudukko;
    
    public ShakkiPeli() throws Exception {
        Lukija lukija = new Lukija("aloitusLauta.txt");
        ruudukko = new Ruudukko(lukija.getText());
        GUI gui = new GUI(this);
        setVuoro(Joukkue.VALKOINEN);
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
    
    /**
     * Käynnistää Kaksinpeli-shakin ja graafisen käyttöliittymän.
     * @param args Mitä tahansa(ei merkitystä).
     * @throws Exception Jos aloitusLauta.txt sisältää vääriä merkkejä
     */
    public static void main(String[] args) throws Exception {
        new Kuvat();
        new ShakkiPeli();
    }
}
