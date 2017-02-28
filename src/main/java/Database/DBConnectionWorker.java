package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionWorker {

    private final String URL = "jdbc:mysql://localhost:3306/api2cartdbtest";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBConnectionWorker() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connection is established");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't download driver class");
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
