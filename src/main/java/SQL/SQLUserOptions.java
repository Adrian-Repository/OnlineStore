package SQL;

import java.util.Scanner;

public class SQLUserOptions {

    public void userOptions(){

        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        while(isTrue){

            System.out.println(" ===== USER DASHBOARD =====");
            System.out.println("\t #1 : TEST ");
            System.out.println("\t #2 : TEST ");


            int option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println("====== TEST ======");

                    break;

                case 2:
                    System.out.println("====== TEST ======");
                    break;
                default :
                    System.out.println(" OPTION NOT VALID! TRY AGAIN!");


        }

    }
    }

}
