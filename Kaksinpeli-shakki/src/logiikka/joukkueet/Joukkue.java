/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.joukkueet;

import java.util.ArrayList;
import logiikka.nappulat.Kuningas;
import logiikka.nappulat.Nappula;

/**
 *
 * @author Antti
 */
public class Joukkue {
    public static Joukkue MUSTA = new Joukkue('m');
    public static Joukkue VALKOINEN = new Joukkue('v');
    
    private ArrayList<Nappula> nappulat;
    private final char TALLENNUSMERKKI;
    
    private Joukkue(char tallennusMerkki) {
        this.TALLENNUSMERKKI = tallennusMerkki;
    }
    
    public char getTallennusMerkki() {
        return TALLENNUSMERKKI;
    }
    
    public static Joukkue getJoukkue(char TALLENNUSMERKKI) throws Exception {
        if (TALLENNUSMERKKI == Joukkue.MUSTA.getTallennusMerkki()) {
            return Joukkue.MUSTA;
        } else if (TALLENNUSMERKKI == Joukkue.VALKOINEN.getTallennusMerkki()) {
            return Joukkue.VALKOINEN;
        } else {
            throw new Exception("Vääränlainen tallennusmerkki.");
        }
    }
    
    public Kuningas getKuningas() {
        for (Nappula nappula : nappulat) {
            if (nappula instanceof Kuningas) {
                return (Kuningas)nappula;
            }
        }
        return null;
    }
}
