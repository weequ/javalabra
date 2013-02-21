/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;
import logiikka.lauta.Ruutu;

/**
 * Määrittelee shakkinappuloille yhteisiä ominaisuuksia.
 * Kaikki shakkinappulat perivät tämän luokan.
 * @see Kuningas
 * @see Kuningatar
 * @see Torni
 * @see Lahetti
 * @see Ratsu
 * @see Sotilas
 * @author Antti
 */
public abstract class Nappula {
    
    /**
     * Ruutu jolla nappula seisoo.
     */
    private Ruutu ruutu;
    
    /**
     * Joukkue johon nappula kuuluu
     */
    private Joukkue joukkue;
    
    /**
     * Ruudut joihin nappula voi kulkea tai joita se uhkaa.
     * Omalla vuorolla siirtomahdollisuudet kuvaavat ruutuja joihin nappula voi siirtyä.
     * Vastustajan vuorolla siirtomahdollisuudet kuvaavat ruutuja joita nappula uhkaa.
     */
    protected ArrayList<Ruutu> siirtoMahdollisuudet;
    
    /**
     * Ympäröivät poikkeamapisteet (eng. offset) joihin tämä nappula voi siirtyä.
     * Esim torni : [(0, 1), (1, 0) , (0, -1), (-1, 0)];
     * Sotilas on ainoa nappula joka ei käytä tätä ominaisuutta, koska sillä on syö ja kävele ruudut erikseen.
     */
    protected Point[] kaveleTaiSyo;
    
    /**
     * Kuinka pitkälle kutakin käveleTaiSyo ruutua voidaan edetä.
     * Esim Kuningas 1, Torni 8, Hevonen 1
     */
    protected int maxAskeleet;
    
    /**
     * Nappulaa kuvaava tallennusmerkki ilman joukkueen tallennusmerkkiä.
     * @return Tallennusmerkki joka kuvaa nappulaa tiedostossa.
     */
    public abstract String getTallennusMerkki();
    
    
    /**
     * Luo uuden nappula olion. 
     * Vain aliluokat voivat käyttää tätä koska luokka on abstrakti.
     * @param joukkue Joukkue johon nappula kuuluu
     */
    public Nappula(Joukkue joukkue) {
        this.joukkue = joukkue;
        siirtoMahdollisuudet = new ArrayList<>();
        joukkue.addNappula(this);
    }
    
    /**
     * Siirtää nappulaa. Ei tarkista onko siirto laillinen.
     * @param ruutuun Ruutu johon nappula siirretään.
     */
    public void siirrä(Ruutu ruutuun) {
        Nappula syotyNappula = ruutuun.getNappula();
        joukkue.getVastustaja().removeNappula(syotyNappula);
        ruutuun.setNappula(this);
        getRuutu().setNappula(null);
        setRuutu(ruutuun);
    }
    
    /**
     * Kertoo uhkaako vastustaja tätä nappulaa.
     * @return 
     */
    public boolean onkoUhattu() {
        return joukkue.getVastustaja().onkoSiirtoMahdollisuuksissa(this);
    }
    
    /**
     * Päivittää siirtomahdollisuudet getSiirtomahdollisuudet() metodin käytettäväksi.
     * @param tarkista Tarkistetaanko uhkaako vastusta kuningasta jos siirtyisimme siirtomahdollisuuteen.
     * @see #getSiirtoMahdollisuudet() 
     */
    public void laskeSiirtoMahdollisuudet(boolean tarkista) {//Sotilas ylikirjoittaa tämän
        siirtoMahdollisuudet.clear();
        Ruudukko r = ruutu.getRuudukko();
        for (int siirto = 0; siirto < kaveleTaiSyo.length; siirto++) {
            for (int askeleet = 1; askeleet <= maxAskeleet; askeleet++) {
                Ruutu kasiteltavaRuutu = r.getRuutu(this.ruutu.getX()+kaveleTaiSyo[siirto].x*askeleet, this.ruutu.getY()+kaveleTaiSyo[siirto].y*askeleet);
                if (kasiteltavaRuutu == null) break;
                if (kasiteltavaRuutu.getNappula() == null) {
                    lisaaSiirtoMahdollisuus(kasiteltavaRuutu, tarkista);
                } else {
                    if (!kasiteltavaRuutu.getNappula().getJoukkue().equals(getJoukkue())) {
                        lisaaSiirtoMahdollisuus(kasiteltavaRuutu, tarkista);
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * Yrittää lisätä ruudun siirtomahdollisuuksien joukkoon.
     * @param ruutu Ruutu jota yritetään lisätä
     * @param tarkista Tarkistetaanko siirtomahdollisuus shakin varalta.
     */
    protected void lisaaSiirtoMahdollisuus(Ruutu ruutu, boolean tarkista) {
        if (tarkista && !tarkistaSiirtomahdollisuus(ruutu)) return;
        siirtoMahdollisuudet.add(ruutu);
    }
    
    
    /**
     * Tarkistaa siirtomahdollisuuden shakin varalta.
     * @param ruutu Ruutu johon yritetään siirtää
     * @return true = voi siirtää, false = laiton siirto
     */
    public boolean tarkistaSiirtomahdollisuus(Ruutu ruutu) {
        Ruutu aloitusRuutu = getRuutu();
        Nappula syotyNappula = ruutu.getNappula();
        siirrä(ruutu);
        joukkue.getVastustaja().laskeSiirtoMahdollisuudet(false);
        boolean tulos = !getJoukkue().onkoShakattu();
        siirrä(aloitusRuutu);
        ruutu.setNappula(syotyNappula);
        if (syotyNappula != null) joukkue.getVastustaja().addNappula(syotyNappula);
        joukkue.getVastustaja().laskeSiirtoMahdollisuudet(false);
        return tulos;
     }
    
    /**
     * Palauttaa viimeksi laskeSiirtomahdollisuudet metodilla päivitetyt siirtomahdollisuudet.
     * @return Ruudut joihin nappula pystyy siirtymään tai joita se uhkaa riippuen laskeSiirtomahdollisuudet metodissa käytetystä parametrista.
     * @see #laskeSiirtoMahdollisuudet(boolean) 
     */
    public ArrayList<Ruutu> getSiirtoMahdollisuudet() {
        return siirtoMahdollisuudet;
    }

    
    public void setRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }
    
    public Ruutu getRuutu() {
        return ruutu;
    }
    
    public Joukkue getJoukkue() {
        return joukkue;
    }
    
    /**
     * Luo nappula olion riippuen parametrista.
     * @param merkki Ensimmäinen merkki määrittelee joukkuuen ja loput nappulan tyypin.
     * @return Nappula joka on joko Kuningas, Kuningatar, Torni, Lahetti, Ratsu tai Sotilas.
     * @throws Exception Jos käytät vääriä merkkejä.'
     * @see Kuningas
     * @see Kuningatar
     * @see Torni
     * @see Lahetti
     * @see Ratsu
     * @see Sotilas
     */
    public static Nappula luoNappula(String merkki) {
        if (merkki.equals("aa")) return null;
        Joukkue nappulanJoukkue;
        try {
            nappulanJoukkue = Joukkue.getJoukkue(merkki.charAt(0));
        } catch (IllegalArgumentException ex) {
            System.out.println("Nappulan luonti epäonnistui.");
            return null;
        }
        
        switch (String.valueOf(merkki.charAt(1))) {
            case Kuningas.TALLENNUSMERKKI:
                return new Kuningas(nappulanJoukkue);
            case Kuningatar.TALLENNUSMERKKI:
                return new Kuningatar(nappulanJoukkue);
            case Torni.TALLENNUSMERKKI:
                return new Torni(nappulanJoukkue);
            case Lahetti.TALLENNUSMERKKI:
                return new Lahetti(nappulanJoukkue);
            case Ratsu.TALLENNUSMERKKI:
                return new Ratsu(nappulanJoukkue);
            case Sotilas.TALLENNUSMERKKI:
                return new Sotilas(nappulanJoukkue);
            default: 
                System.out.println("Tallennusmerkki ei vastaa mitään nappulaa");
                return null;
        }
    }
    
    /**
     * Palauttaa nappulan niin kuin se tallennettaisiin tiedostoon.
     * Ensin joukkueen merkki ja sitten nappulan merkki. Esim musta torni olisi mt
     * @return Nappulaa kuvaava merkkijono.
     */
    @Override
    public String toString() {
        return getJoukkue().getTallennusMerkki()+getTallennusMerkki();
    }
    
}
