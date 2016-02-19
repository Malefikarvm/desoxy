import Components.Country;
import Components.Formatter;
import Models.Users;
import Util.Conn.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;

/**
 * Created by Analista on 28/09/2015.
 */
public class Main {

    public static void main(String[] args){
        Users users = new Users();
        /*String s = "1234567.12";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        System.out.println(new DecimalFormat("###,###,###.##", symbols).format(Double.parseDouble(s)));
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO (");
        query.append("a,b,c");
        query.append(")");
        query.append(" VALUES (");
        query.append(1+","+2+","+3);
        query.append(")");
        System.out.println(query.toString());*/
    }

}
