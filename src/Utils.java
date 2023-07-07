import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils
{
    static NumberFormat formataNumeros = new DecimalFormat("##0");
    static SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToString(Date data) {
        return Utils.formataData.format(data);
    }

    public static String doubleToString(Double valor) {
        return Utils.formataNumeros.format(valor);
    }
}
