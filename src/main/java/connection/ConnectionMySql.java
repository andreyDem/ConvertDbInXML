package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql implements ConnectionDB{
    private static final String dataBaseURL = "jdbc:mysql://localhost:3306/employeeList?useSSL=true";
    private static final String mySqlDriver = "com.mysql.jdbc.Driver";
    private static final String login = "root";
    private static final String password = "root";


    private static ConnectionMySql connectionMySql;

    public ConnectionMySql() {
    }



    public static ConnectionMySql getConnectionMySQL() {
        if (connectionMySql == null) {
            connectionMySql = new ConnectionMySql();
            System.out.println("Instance of connectionMySQL created.");
        }
        return connectionMySql;
    }


    public Connection getConnection() throws SQLException {
        System.out.println("Connection to DB");
        return DriverManager.getConnection(dataBaseURL, login, password);
    }
}
