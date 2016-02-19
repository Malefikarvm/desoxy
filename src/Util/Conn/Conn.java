package Util.Conn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Analista on 08/02/2016.
 */
public class Conn {

    public static Connection getConn(String dbName){

            Connection conn = null;

            try{
                Class.forName("com.mysql.jdbc.Driver");
                String server = "jdbc:mysql://localhost/"+dbName;
                String user = "root";
                String password = "";
                conn = DriverManager.getConnection(server, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e, "Error en la conexión a la bd: No se encuentra el driver", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Error en la conexión a la bd", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e, "Error en la conexión a la bd", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                return conn;
            }
    }
}
