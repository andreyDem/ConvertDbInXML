package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql implements ConnectionDB {
    //I have timezone error when connect to db
    private static final String dataBaseURL = "jdbc:mysql://localhost:3306/employeeList" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    private static final String mySqlDriver = "com.mysql.cj.jdbc.Driver";
    private static final String login = "root";
    private static final String password = "root";

    private static ConnectionMySql connectionMySql;

    public ConnectionMySql() {
    }

    static {
        try {
            Class.forName(mySqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
