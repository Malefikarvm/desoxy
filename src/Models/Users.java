package Models;

import Components.Model.Model;
import Util.Conn.Conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Created by Analista on 09/02/2016.
 */
public class Users extends Model {

    private static final String DB_NAME= "local";

    public Users(){
        super("users",DB_NAME);
        generate();
    }

    private void generate(){
        super.db = Conn.getConn(DB_NAME);
        createModel();
    }

}
