package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
    static String username = "root";
    static String password = "roottoor";
    static String dbUrl="jdbc:mysql://localhost:3306/onlinestore";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,username,password);
    }

}
