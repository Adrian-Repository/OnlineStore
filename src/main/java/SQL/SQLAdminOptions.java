package SQL;

import Connection.SQLconnection;

import java.sql.SQLException;
import java.util.Scanner;

public class SQLAdminOptions {
    SQLconnection sqlconnection = new SQLconnection();
    SQLInsert sqlInsert = new SQLInsert();
    SQLUpdate sqlUpdate = new SQLUpdate();

    public void AdminOptions() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        while(isTrue){

            System.out.println(" ===== ADMIN DASHBOARD =====");
            System.out.println("\t #1 : UPDATE ");
            System.out.println("\t #2 : DELETE ");
            System.out.println("\t #3 : INSERT ");
            System.out.println("\t #4 BACK ");
            System.out.println("\t #5 EXIT ");

            int option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println("====== UPDATE ======");
                    sqlUpdate.update();
                    System.exit(0);
                    break;

                case 2:
                    System.out.println("====== DELETE ======");
                    sqlUpdate.update();
                    System.exit(0);
                    break;
                case 3:
                    System.out.println("====== INSERT ======");
                    sqlInsert.insertUser();
                    System.exit(0);
                    break;
                case 4:
                    isTrue = false;
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option is not valid! Try again!");
            }

        }

    }



}
