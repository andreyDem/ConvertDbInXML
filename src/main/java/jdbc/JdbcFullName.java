package jdbc;

import connection.ConnectionDB;
import entity.FullName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcFullName {
    private static final String getAllData = "select * from fullName";

    private ConnectionDB connectionDB;

    public JdbcFullName(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    public List<FullName> getAllDataList() {
        List<FullName> fullNameList = new ArrayList<>();
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAllData)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fullNameList.add(new FullName(
                        resultSet.getInt("id"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name")
                ));
            }
            return fullNameList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
