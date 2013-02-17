package logiikka.lauta;

import logiikka.nappulat.Nappula;

/**
 * Ruudukko eli shakkilauta sisältää ruudut.
 * @author Antti
 */
public class Ruudukko {
    Ruutu[][] ruudukko;
    
    public Ruudukko(String teksti) throws Exception {
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
    
    private void asetaNappulat(String teksti) throws Exception {
        String[] rivit = teksti.split(System.getProperty("line.separator"));
        if (rivit.length != 8) {
            throw new Exception("Ruudukko sai syötteeksi väärän määrän rivejä. "+rivit.length);
        }
        for (int y = 0; y < rivit.length; y++) {
            String[] nappulat = rivit[y].split(",");
            if (nappulat.length != 8) {
                throw new Exception("Ruudukon rivi sisältää väärän määrän sarakkeita."+nappulat.length+" rivillä "+y);
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
