
import kayttoliittyma.GUI;
import kayttoliittyma.Kuvat;
import tiedostonKasittely.PeliTiedostoMuuntaja;

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
        GUI gui = new GUI(PeliTiedostoMuuntaja.avaaPeli("aloitusLauta.txt"));
    }
}
