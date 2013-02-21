package tiedostonKasittely;

import java.io.IOException;
import logiikka.ShakkiPeli;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;

/**
 * Pelin avaamisen ja tallentamisen hoitava luokka.
 * @author Antti
 */
public class PeliTiedostoMuuntaja {

    /**
     * Avaa shakkipelin annetusta tiedostopolusta.
     * @param tiedostoPolku
     * @return ShakkiPeli tai null jos pelin avaaminen epäonnistuu.
     */
    public static ShakkiPeli avaaPeli(String tiedostoPolku) {
        Lukija lukija;
        try {
            lukija = new Lukija(tiedostoPolku);
            return tekstiShakkiPeliksi(lukija.getText());
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Tallentaa shakkipelin annettuun tiedostopolkuun.
     * @param shakkiPeli Shakkipeli joka tallennetaan.
     * @param tiedostoPolku Tiedostopolku johon tallennetaan.
     * @return True jos tallentaminen onnistuu, false jos epäonnistuu.
     */
    public static boolean tallennaPeli(ShakkiPeli shakkiPeli, String tiedostoPolku) {
        Kirjoittaja kirjoittaja = new Kirjoittaja(tiedostoPolku);
        try {
            kirjoittaja.kirjoita(shakkiPeliTekstiksi(shakkiPeli));
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    /**
     * Tekee trim operaation jokaiselle taulukon alkiolle. Ei muuta parametrina annettua taulukkoa.
     * @param arr Taulukko jota trimmataan.
     * @return Trimmattu taulukko
     * @see String#trim() 
     */
    private static String[] trimArr(String[] arr) {
        String[] tulos = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tulos[i] = arr[i].trim();
        }
        return tulos;
    }
    
    /**
     * Muuttaa tiedostosta luetun tekstin ShakkiPeliksi
     * @param teksti Teksti joka muutetaan shakkipeliksi. Ensimmäinen rivi sisältää parametrit jotka on erotettu pilkulla.
     * @return Tekstistä muodostettu ShakkiPeli olio.
     * @throws IllegalArgumentException Jos teksti on virheellinen.
     */
    private static ShakkiPeli tekstiShakkiPeliksi(String teksti) throws IllegalArgumentException {
        String rivinVaihto = System.getProperty("line.separator");
        int ensimmainenRivinVaihto = teksti.indexOf(rivinVaihto);
        String ensimmainenRivi = teksti.substring(0, ensimmainenRivinVaihto);
        System.out.println(ensimmainenRivi);
        String[] parametrit = trimArr(ensimmainenRivi.split(","));
        String ruudukkoString = teksti.substring(ensimmainenRivinVaihto+rivinVaihto.length());
        Ruudukko ruudukko = new Ruudukko(ruudukkoString);
        return new ShakkiPeli(ruudukko, Joukkue.getJoukkue(parametrit[0].charAt(0)));
    }
    
    /**
     * Muuttaa ShakkiPelin tiedostoon tallennettavaksi kelpaavaksi merkkijonoksi.
     * @param shakkiPeli
     * @return 
     */
    private static String shakkiPeliTekstiksi(ShakkiPeli shakkiPeli) {
        return shakkiPeli.toString();
    }
}
