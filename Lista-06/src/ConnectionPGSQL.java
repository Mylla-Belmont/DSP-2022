import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPGSQL {
   
    Connection connection = null;

    public void connect (String url, String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso");
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update (String sql){
        try {
            Statement stmt = (Statement) connection.createStatement();
            int res = ((java.sql.Statement) stmt).executeUpdate(sql);
            connection.close();
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet select (String sql){
        try {
            Statement stmt = (Statement) connection.createStatement(); 
            ResultSet res = ((java.sql.Statement) stmt).executeQuery(sql);
            connection.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
