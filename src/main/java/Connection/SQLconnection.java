package Connection;

import SQL.SQLAdminOptions;
import SQL.SQLCheckAdmin;
import Utils.DButils;
import org.apache.commons.lang.builder.HashCodeBuilder;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLconnection {
    public static void connection() {
        //public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        SQLCheckAdmin check = new SQLCheckAdmin();
        SQLAdminOptions sqlAdminOptions = new SQLAdminOptions();

        try {
            connection = DButils.getConnection();

            Scanner sc = new Scanner(System.in);
            System.out.println(" USERNAME: ");
            String username = sc.next();

            System.out.println(" PASSWORD: ");
            String password = sc.next();

            String sql = "Select * from registration where username = ? AND password =?";
            statement = connection.prepareStatement(sql);

            String hash = String.valueOf(new HashCodeBuilder(17, 37).
                    append(username).
                    append(password).
                    toHashCode());

            System.out.println(" ====== RESULTS ====== ");

            statement.setString(1, username);
            statement.setString(2, hash);

            resultSet = statement.executeQuery();

            boolean isTrue = false;
            int x = 0;

            while (resultSet.next()) {
                isTrue = true;
                int rowNumber = resultSet.getRow();
                String name = resultSet.getString("username");
                System.out.println(rowNumber + ") " + name);
                x++;
                check.checkAdmin();
                if (x == 30) {
                    System.out.println(" am ajuns la 30 de persoane ");
                    break;
                }
            }
            System.out.println(" ====== EXISTA? ====== ");
            if (isTrue) {

                System.out.println(" # DA EXISTA ");

            } else {
                System.out.println(" # NU EXISTA ");
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
