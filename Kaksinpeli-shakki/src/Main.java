
import kayttoliittyma.GUI;
import kayttoliittyma.Kuvat;
import tiedostonKasittely.PeliTiedostoMuuntaja;
import tiedostonKasittely.ResurssienLukija;

/**
 * Ohjelman käynnistävä luokka
 * @author Antti
 */
public class Main {
    
    /**
     * Käynnistää Kaksinpeli-shakin ja graafisen käyttöliittymän.
     * @param args Mitä tahansa(ei merkitystä).
     * @throws Exception Jos aloitusLauta.txt sisältää vääriä merkkejä
     */
    public static void main(String[] args) throws Exception {
        Kuvat.lataaKuvat();
        GUI gui = new GUI(PeliTiedostoMuuntaja.tekstiShakkiPeliksi(ResurssienLukija.lueTiedostoTekstiksi("/resurssit/aloitusLauta.txt")));
    }
}
