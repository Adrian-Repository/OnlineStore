package SQL;

import Utils.DButils;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLUpdate {

    public static void update() throws SQLException {
        Connection connection = DButils.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.print("First name: ");
        String username = sc.next();
        System.out.print("Update password: ");
        String password = sc.next();

        String sql = "update registration set password = ? where username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        String hash = String.valueOf(new HashCodeBuilder(17, 37).
                append(username).
                append(password).
                toHashCode());
        System.out.println(" ====== RESULTS ====== ");
        System.out.println("[Test] hash is : " + hash );
        statement.setString(2,username);
        statement.setString(1,hash);

        int result = statement.executeUpdate();
        System.out.println("Update successful!"+" code:  "+result);

        sc.close();
        statement.close();
        connection.close();


    }
    }

