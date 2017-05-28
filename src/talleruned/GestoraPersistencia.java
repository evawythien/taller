package talleruned;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestoraPersistencia {

    public static <K, V> HashMap<K, V> leerEnXML(String path) {

        File file = new File(path);
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                XMLDecoder xmlDecoder = new XMLDecoder(bis);
                return (HashMap<K, V>) xmlDecoder.readObject();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new HashMap<K, V>();
    }

    public static void escribirXML(String path, Object objeto) {

        try {
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            xmlEncoder.writeObject(objeto);
            xmlEncoder.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
