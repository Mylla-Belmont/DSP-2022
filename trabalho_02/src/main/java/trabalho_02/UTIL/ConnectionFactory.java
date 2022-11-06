package trabalho_02.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                                "jdbc:postgresql://localhost/postgres", 
                                "postgres", 
                                "creepypasta"
                            );
    }
}
