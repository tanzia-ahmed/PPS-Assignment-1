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
        int maxComputers = scanner.nextInt(); //max number of computers that can be added
        Computer[] inventory = new Computer[maxComputers]; //array of computers
        int compAdded = 0; //counter for number of computers added

        int option = 0; //user input value
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
                    System.out.print("Enter Password: ");
                    for(int i=0; i<3; i++) {
                        //PROMPT
                        String givenPassword = scanner.next();
                        //CHECKING PASSWORD
                        boolean pwPassed = checkPassword(givenPassword);
                        if(pwPassed){ //MATCHED
                            System.out.println("How many computers do you want to enter?");
                            //PROMPT
                            int numComp = scanner.nextInt();
                            //CHECKING FOR AVAILABLE CAPACITY
                            if(numComp <= (maxComputers-compAdded)){
                                //CREATING NEW COMPUTERS
                                for(int j = 0; j<numComp; j++){
                                    Computer newComputer = new Computer();
                                    compAdded++;
                                    inventory[compAdded-1] = newComputer;
                                }
                            }else{
                                System.out.println("Sorry, you cannot enter more than "+(maxComputers-compAdded)+" computers");
                            }
                            break;
                        }else{
                            System.out.println("Oops!! Wrong Password!");
                            System.out.println();
                            if(i<2)
                            System.out.print("Enter Password Again: ");
                        }

                    }
                case 2:
                    System.out.print("Enter Password: ");
                    for(int i=0; i<3; i++) {
                        //PROMPT
                        String givenPassword = scanner.next();
                        //CHECKING PASSWORD
                        boolean pwPassed = checkPassword(givenPassword);
                        if(pwPassed){ //MATCHED
                            System.out.println("What computer number do you want to update?");
                            //PROMPT
                            String compIndex = scanner.next();
                            break;
                        }else{
                            System.out.println("Oops!! Wrong Password!");
                            System.out.println();
                            if(i<2)
                                System.out.print("Enter Password Again: ");
                        }

                    }
            }
        }


    }

    private static boolean checkPassword(String givenPassword) {
        boolean result = false;

        if(givenPassword.equals(password)){ //MATCHED
            result = true;
        }else{ }
        return result;
    }
}