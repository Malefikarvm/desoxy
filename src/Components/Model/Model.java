package Components.Model;

import Components.Uroboros.Uroboros;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Created by Santiago Posada on 09/02/2016.
 */
public class Model <E> extends Uroboros<E> {

    private String table;
    protected String dbName;
    private Hashtable<String, String> rowsName = new Hashtable<String, String>();
    private Hashtable<String, String> pk = new Hashtable<String, String>();
    private Uroboros uro = new Uroboros();

    protected Connection db;
    Statement stmnt;

    public Model(String table, String dbName){
        this.table = table;
        this.dbName = dbName;
    }

    /**
     *
     */
    protected void createModel() {
        try {
            this.stmnt = db.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = queryBuilder("SELECT `COLUMN_NAME` ","FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE `TABLE_SCHEMA`='",
                dbName,"' AND `TABLE_NAME`='",table,"'");
        ResultSet rs = null;
        try {
            rs = stmnt.executeQuery(query.toString());
            while(rs.next()){
                String row = rs.getString("COLUMN_NAME");
                rowsName.put(row, row);
            }
            rs.close();
            primaryKey();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void primaryKey() throws SQLException{
        String query = queryBuilder("SHOW KEYS FROM `",table,"` WHERE Key_name = 'PRIMARY'");
        ResultSet rs  = stmnt.executeQuery(query);
        while (rs.next()) {
            String primary = rs.getString("Column_name");
            pk.put(primary, primary);
        }
        rs.close();
    }

    protected void foreignKey() throws SQLException{
        String query = queryBuilder("SHOW KEYS FROM `", table, "` WHERE Key_name = 'PRIMARY'");
        ResultSet rs  = stmnt.executeQuery(query.toString());
        while (rs.next()) {
            String primary = rs.getString("Column_name");
            System.out.println(primary);
            pk.put(primary, primary);
        }
        rs.close();
    }

    private String queryBuilder(String... query){
        StringBuilder helper = new StringBuilder();
        for(String part : query){
            helper.append(part);
        }
        return helper.toString();
    }
}