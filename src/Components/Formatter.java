package Components;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Analista on 09/11/2015.
 */
public class Formatter {

    public String getMoney(Double value){

        System.out.println("Este es el valor antes del formato " + value);
        String money = "$";
        NumberFormat numberFormatter;
        numberFormatter = NumberFormat.getNumberInstance(Locale.US);
        money += numberFormatter.format(value);
        System.out.println("este es el valor desùes del formato " + value);
        return money;
    }
}
