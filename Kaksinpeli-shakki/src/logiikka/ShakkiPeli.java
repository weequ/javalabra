/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import kayttoliittyma.GUI;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;
import logiikka.nappulat.Nappula;
import tiedostonLuku.Lukija;

/**
 *
 * @author Antti
 */
public class ShakkiPeli {
    private Joukkue vuoro;
    private Ruudukko ruudukko;
    
    public ShakkiPeli() throws Exception {
        Lukija lukija = new Lukija("aloitusLauta.txt");
        ruudukko = new Ruudukko(lukija.getText());
        GUI gui = new GUI(this);
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko;
    }
    
    public Joukkue getVuoro() {
        return vuoro;
    }
    
    public void setVuoro(Joukkue vuoro) {
        this.vuoro = vuoro;
    }
    
    public void vaihdaVuoroa() {
        if (vuoro.equals(Joukkue.MUSTA)) {
            vuoro = Joukkue.VALKOINEN;
        } else {
            vuoro = Joukkue.MUSTA;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new ShakkiPeli();
    }
}
