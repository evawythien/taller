package talleruned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Eva
 */
public class ValidacionDatos {

    // Para consumir menos recursos al compilar el patron
    private static final Pattern patronMatricula = Pattern.compile("^\\d{4}[A-Z]{3}"); // 1234 asd 
    private static final Pattern patronMatriculaVieja = Pattern.compile("^[A-Z]{0,1}([A-Z]-){0,1}[0-9]{4}-[A-Z]{1,3}$"); // va - 1234 - as

    public static boolean comprobarDni(String dni) {

        return true;
    }

    public static boolean comprobarMatricula(String matricula) {

        Matcher patron = patronMatricula.matcher(matricula);
        Matcher patronVieja = patronMatriculaVieja.matcher(matricula);
        return patron.matches() || patronVieja.matches();
    }
}
