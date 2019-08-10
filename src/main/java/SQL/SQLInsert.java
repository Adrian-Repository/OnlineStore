package SQL;

import Utils.DButils;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class SQLInsert {

  public static void insertUser() throws SQLException {
 //public static void main(String[] args) throws SQLException {


       Connection connection = DButils.getConnection();
       Scanner sc = new Scanner(System.in);

       System.out.println(" USERNAME: ");
       String username = sc.next();
       System.out.println(" PASSWORD: ");
       String password = sc.next();
       String sql ="Insert into registration(username,password) values(?,?)";
       PreparedStatement statement = connection.prepareStatement(sql);
       String hash = String.valueOf(new HashCodeBuilder(17, 37).
               append(username).
               append(password).
               toHashCode());
       System.out.println("  ====== RESULTS ====== ");

       statement.setString(1,username);
       statement.setString(2,hash);

       int result = statement.executeUpdate();
       System.out.println("Registration successful!"+" code:  "+result);

       sc.close();
       statement.close();
       connection.close();

   }

   }


