/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 * Näyttää globaaliin lokiin lähetettyjä lokiviestejä tekstiboxissa.
 * Voit lähettää viestin tähän laatikkoon esim komennolla Logger.getGlobal().log(Level.INFO, "Hello world!");
 * @author Antti
 */
public class LokiTextArea extends JTextArea {
    private Lokivarasto lokivarasto;
   
    public LokiTextArea() {
        super(5, 10); //5 riviä
        lokivarasto = new Lokivarasto();
        setEditable(false);
    }
    
    
    /**
     * Tallettaa Globaaliin lokiin lähetettyjä lokitietueita.
     */
    private class Lokivarasto extends Handler {

        private final static int MAKSIMIKAPASITEETI = 30;
        
        /**
         * @see java.util.logging.LogRecord
         */
        private ArrayList<LogRecord> lokitietueet;

        //Luo lokivaraston joka sisältää maksimissaan 30 lokitietuetta.
        public Lokivarasto() {
            lokitietueet = new ArrayList<>(MAKSIMIKAPASITEETI);
            Logger.getGlobal().addHandler(this);
        }

        @Override
        public void publish(LogRecord record) {
            if (lokitietueet.size() == MAKSIMIKAPASITEETI) {
                lokitietueet.remove(0);
            }
            lokitietueet.add(record);
            setText(toString());
        }

        @Override
        public void flush() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void close() throws SecurityException {
            lokitietueet.clear();
        }
        
        @Override
        public String toString() {
            String tulos = "";
            Iterator<LogRecord> iterator = lokitietueet.iterator();
            while (iterator.hasNext()) {
                LogRecord lokitietue = iterator.next();
                tulos+=lokitietue.getMessage();
                if (iterator.hasNext()) tulos+=System.getProperty("line.separator");
            }
            return tulos;
        }

    }
    
}
