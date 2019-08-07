package SQL;

import Utils.DButils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCreateTable {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButils.getConnection();

            statement = connection.createStatement();
            String sql = "CREATE TABLE ITEMS " +
                    "(id INTEGER  PRIMARY KEY AUTO_INCREMENT, " +
                    " username VARCHAR(255), " +
                    " password VARCHAR(255)) " ;

            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}
