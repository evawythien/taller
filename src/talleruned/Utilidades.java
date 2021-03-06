package talleruned;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilidades {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public static Calendar getFechaActual() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

    public static Calendar getFechaHaceUnAnno() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        return calendar;
    }

    public static Calendar getFecha(int dia, int mes, int año) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(año, mes, dia);
        return calendar;
    }

    public static Calendar parseFecha(String fecha) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(fecha));
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calendar;
    }

    public static String formatFecha(Calendar fecha) {
        return sdf.format(fecha.getTime());
    }

    public static Boolean isPromoBetweenDates(Calendar fechaInicio, Calendar fechaFin) {
        return fechaInicio.after(getFechaActual()) && fechaFin.before(getFechaActual());
    }

    public static String booleanToString(Boolean b) {
        return b ? "Si" : "No";
    }
}
