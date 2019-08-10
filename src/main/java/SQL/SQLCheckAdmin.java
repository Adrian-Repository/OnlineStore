package SQL;

import Utils.DButils;
import com.mysql.cj.protocol.Resultset;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLCheckAdmin {
    public void checkAdmin() throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        SQLAdminOptions sqlAdminOptions = new SQLAdminOptions();
        SQLUserOptions sqlUserOptions = new SQLUserOptions();
        connection = DButils.getConnection();

     /*   Scanner sc = new Scanner(System.in);
        System.out.println(" USERNAME: ");
        String username = sc.next();

        System.out.println(" PASSWORD: ");
        String password = sc.next();
*/
        String sql = "Select * from registration";//where isAdmin = 1 ";
        statement = connection.prepareStatement(sql);

       /* String hash = String.valueOf(new HashCodeBuilder(17, 37).
                append(username).
                append(password).
                toHashCode());
*/
        System.out.println(" ====== RESULTS ====== ");
        Boolean isAdmin = null;
        resultSet = statement.executeQuery();

        while(resultSet.next()){

        isAdmin = Boolean.valueOf(resultSet.getString("isAdmin"));
            System.out.println(isAdmin);


        if (isAdmin == true) {
            System.out.println(" LOGGED IN AS ADMIN! ");
            sqlAdminOptions.AdminOptions();
            break;
        } else {
            System.out.println(" LOGGED IN AS USER! ");
            sqlUserOptions.userOptions();
            break;

        }
        }

    }
}