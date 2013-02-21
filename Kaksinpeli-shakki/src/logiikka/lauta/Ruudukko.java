package logiikka.lauta;

import logiikka.nappulat.Nappula;

/**
 * Ruudukko eli shakkilauta, joka sisältää ruudut.
 * @author Antti
 */
public class Ruudukko {
    /**
     * 8X8 Matriisi johon ruudut talletetaan.
     */
    Ruutu[][] ruudukko;
    
    /**
     * Luo uuden 8X8 ruudukon ja asettaa nappulat vastaamaan parametrina annettua merkkijonoa.
     * @param teksti Merkkijono jonka tulee koostua 8 rivistä, joista jokainen koostuu kahdeksasta pilkulla erotetutsta nappulasta.
     * @throws Exception 
     */
    public Ruudukko(String teksti) throws IllegalArgumentException {
        ruudukko = new Ruutu[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ruudukko[y][x] = new Ruutu(x, y, this);
            }
        }
        asetaNappulat(teksti);
    }
    
    
    public Ruutu getRuutu(int x, int y) {
        try {
            return ruudukko[y][x];
        } catch(ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }
    
    /**
     * Asettaa pelinappulat parametrina annetun tekstin mukaan.
     * @param teksti Merkkijono jonka tulee koostua 8 rivistä, joista jokainen koostuu kahdeksasta pilkulla erotetutsta nappulasta.
     * @throws Exception 
     */
    private void asetaNappulat(String teksti) throws IllegalArgumentException {
        String[] rivit = teksti.split(System.getProperty("line.separator"));
        if (rivit.length != 8) {
            throw new IllegalArgumentException("Ruudukko sai syötteeksi väärän määrän rivejä. "+rivit.length);
        }
        for (int y = 0; y < rivit.length; y++) {
            String[] nappulat = rivit[y].split(",");
            if (nappulat.length != 8) {
                throw new IllegalArgumentException("Ruudukon rivi sisältää väärän määrän sarakkeita."+nappulat.length+" rivillä "+y);
            }
            for (int x = 0; x < nappulat.length; x++) {
                Nappula nappula = Nappula.luoNappula(nappulat[x]);
                if (nappula == null) continue;
                nappula.setRuutu(ruudukko[y][x]);
                ruudukko[y][x].setNappula(nappula);
            }
        }
    }
    
    @Override
    public String toString() {
        String tulos = "";
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                tulos += ruudukko[y][x].toString();
                if (x < 7) tulos += ",";
            }
            if (y < 7) tulos += System.getProperty("line.separator");
        }
        return tulos;
    }
    
}
