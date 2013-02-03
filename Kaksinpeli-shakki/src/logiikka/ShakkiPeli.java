/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import kayttoliittyma.GUI;
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
    
    public void setVuoro(Joukkue vuoro) {
        this.vuoro = vuoro;
        this.vuoro.laskeSiirtoMahdollisuudet(true);
        this.vuoro.getVastustaja().laskeSiirtoMahdollisuudet(false);
        if (this.vuoro.onkoShakattu()) System.out.println("Shakki!");
    }
    
    public void vaihdaVuoroa() {
        if (vuoro.equals(Joukkue.MUSTA)) {
            setVuoro(Joukkue.VALKOINEN);
        } else {
            setVuoro(Joukkue.MUSTA);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new ShakkiPeli();
    }
}
