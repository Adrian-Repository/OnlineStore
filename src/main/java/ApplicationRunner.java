import Connection.SQLconnection;
import SQL.SQLAdminOptions;
import SQL.SQLCheckAdmin;
import SQL.SQLInsert;
import SQL.SQLUpdate;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) throws SQLException {


        SQLconnection sqlconnection = new SQLconnection();
        SQLInsert sqlInsert = new SQLInsert();
        SQLUpdate sqlUpdate = new SQLUpdate();
        SQLAdminOptions sqlAdminOptions = new SQLAdminOptions();
        SQLCheckAdmin sqlCheckAdmin = new SQLCheckAdmin();


        System.out.println(" Welcome to the online store application! (!!WIP!!)");
        System.out.println("\tPlease select an option : ");

        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;

        while (isTrue) {

            System.out.println(" ");
            System.out.println("\t# 1: LOG IN ");
            System.out.println("\t# 2: REGISTER ");
            System.out.println("\t# 3: EXIT ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println(" ====== LOG IN ====== ");
                    sqlconnection.connection();

                    System.exit(0);
                    break;
                case 2:
                    System.out.println(" ====== REGISTER ====== ");
                    try {
                        sqlInsert.insertUser();
                    } catch (SQLIntegrityConstraintViolationException ex) {
                        System.out.println(" USER ALREADY USED!! TRY AGAIN! ");
                    }
                    System.exit(0);
                    break;


                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println(" SELECTION IS NOT VALID! TRY AGAIN");

            }
        }


    }

}
