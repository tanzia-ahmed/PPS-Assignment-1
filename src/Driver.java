import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    private static String password = "password";

    public static void main (String [] args){
        // WELCOME MESSAGE
        System.out.println("Welcome to the computer tracking app!");
        System.out.println();
        System.out.println("How many computers (at maximum) can be stored in your computer store?");

        Scanner scanner =  new Scanner(System.in);

        //PROMPT
        int maxComputers = scanner.nextInt(); //max number of computers
        ArrayList<Computer> inventory = new ArrayList<>();

        int option = 0;
        while(option !=5){
            System.out.println("What do you want to do?\n" +
                    "1. Enter new computers (password required)\n" +
                    "2. Change information of a computer (password required)\n" +
                    "3. Display all computers by a specific brand\n" +
                    "4. Display all computers under a certain a price.\n" +
                    "5. Quit\n" +
                    "Please enter your choice >");
            //PROMPT
            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.print("Password: ");
                    for(int i=0; i<3; i++) {
                        String givenPassword = scanner.next();
                        if(givenPassword == password){
                            Computer newComputer = new Computer();
                        }
                    }
            }
        }


    }
}