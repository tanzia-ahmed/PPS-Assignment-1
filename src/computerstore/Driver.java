package computerstore;
import java.util.Scanner;

import static computerstore.Computer.findNumberOfCreatedComputers;

public class Driver {

    private static String password;
    private static Scanner scanner1;
    private static Scanner scanner2;
    private static int maxComputers; //max number of computers that can be added
    private static Computer[] inventory; //array of computers
    public static void main (String [] args){

        password = "password";

        // WELCOME MESSAGE
        System.out.println("Welcome to the computer tracking app!");
        System.out.println();
        System.out.println("How many computers (at maximum) can be stored in your computer store?");

        scanner1 = new Scanner(System.in);
        scanner2 = new Scanner(System.in);

        //PROMPT
        maxComputers = scanner1.nextInt();
        inventory = new Computer[maxComputers];

        Menu();

    }

    private static void Menu(){
        int option = 0; //user input value
        while(option !=5) {
            DisplayMenuOptions();
            //PROMPT
            option = scanner1.nextInt();
            switch (option) {
                // ENTER NEW COMPUTERS
                case 1:
                    System.out.print("Enter Password: ");
                    for (int i = 0; i < 3; i++) {
                        //PROMPT
                        String givenPassword = scanner1.next();
                        //CHECKING PASSWORD
                        boolean pwPassed = checkPassword(givenPassword);
                        if (pwPassed) { //MATCHED
                            EnterNewComputers();
                            break;
                        } else {
                            System.out.println("Oops!! Wrong Password!");
                            System.out.println();
                            if (i < 2)
                                System.out.print("Enter Password Again: ");
                        }

                    }
                    break;
                // UPDATE INFORMATION OF A COMPUTER
                case 2:
                    System.out.print("Enter Password: ");
                    for (int i = 0; i < 3; i++) {
                        //PROMPT
                        String givenPassword = scanner1.next();
                        //CHECKING PASSWORD
                        boolean pwPassed = checkPassword(givenPassword);
                        if (pwPassed) { //MATCHED
                            UpdateComputer();
                            break;
                        } else {
                            System.out.println("Oops!! Wrong Password!");
                            System.out.println();
                            if (i < 2)
                                System.out.print("Enter Password Again: ");
                        }

                    }
                    break;
                case 3:
                    System.out.println("Enter the brand name you want to search:");
                    String brand = scanner2.next();
                    findComputersBy(brand);
                    break;
                // QUIT
                case 5:
                    System.out.print("Good Bye! :)");
                    System.exit(0);
            }
        }
    }

    private static void DisplayMenuOptions(){
        System.out.println("What do you want to do?\n" +
                "1. Enter new computers (password required)\n" +
                "2. Change information of a computer (password required)\n" +
                "3. Display all computers by a specific brand\n" +
                "4. Display all computers under a certain a price.\n" +
                "5. Quit\n" +
                "Please enter your choice >");
    }
    private static boolean checkPassword(String givenPassword) {
        boolean result = false;

        if(givenPassword.equals(password)){ //MATCHED
            result = true;
        }else{ }
        return result;
    }
    private static void EnterNewComputers(){
        if(findNumberOfCreatedComputers() == maxComputers){
            System.out.println("HOUSEFULL!!");
        }else {
            System.out.println("How many computers do you want to enter?");
            //PROMPT
            int numComp = scanner1.nextInt();
            //CHECKING FOR AVAILABLE CAPACITY
            if (numComp <= (maxComputers - findNumberOfCreatedComputers())) {
                //CREATING NEW COMPUTERS
                for (int j = 0; j < numComp; j++) {
                    Computer newComputer = new Computer();
                    inventory[j] = newComputer;
                    System.out.println(inventory[j]);
                }
                System.out.println(findNumberOfCreatedComputers() + " computers were created successfully!");
            } else {
                System.out.println("Sorry, you cannot enter more than " + (maxComputers - findNumberOfCreatedComputers()) + " computers");
            }
        }
    }
    private static void UpdateComputer() {
        System.out.println("What computer number do you want to update?");
        //PROMPT
        int compIndex = scanner1.nextInt();
        if (compIndex < findNumberOfCreatedComputers()){
            System.out.println("Computer # "+ compIndex + "\n" +
                    inventory[compIndex].toString());
            UpdateMenu(inventory[compIndex]);
        }else{
            System.out.println("Sorry, this number is not registered with a computer.\n"+
                    "Do you want to enter a new computer (1) OR go back (0)?");
            int op = scanner1.nextInt();
            switch(op){
            case 1:
                EnterNewComputers();
                break;
            case 0:
                return;
            }
        }
    }
    private static void UpdateMenu(Computer computer){
        int option = 0; //user input value
        while(option !=5) {
            DisplayUpdateMenuOptions();
            //PROMPT
            option = scanner2.nextInt();
            switch (option) {
                case 1:
                    //BRAND
                    System.out.println("Change brand name "+ computer.getBrand() + " to:");
                    UpdateBrand(computer);
                    break;
                case 2:
                    //MODEL
                    System.out.println("Change model name "+ computer.getModel() + " to:");
                    UpdateModel(computer);
                    break;
                case 3:
                    //SN
                    System.out.println("Change serial number "+ computer.getSN() + " to:");
                    UpdateSN(computer);
                    break;
                case 4:
                    //PRICE
                    System.out.println("Change price "+ computer.getPrice() + " to:");
                    UpdatePrice(computer);
                    break;
                case 5:
                    //QUIT
                    return;
            }
        }
    }

    private static void DisplayUpdateMenuOptions(){
        System.out.println("What information would you like to change?\n" +
                "1. brand\n" +
                "2. model\n" +
                "3. SN\n" +
                "4. price\n" +
                "5. Quit\n" +
                "Enter your choice >");
    }
    private static void UpdateBrand(Computer computer) {
        System.out.println("Im brand");
        String brand = scanner2.next();
        computer.setBrand(brand);
        System.out.println(computer);
    }
    private static void UpdateModel(Computer computer) {
        System.out.println("Im model");
        String model = scanner2.next();
        computer.setModel(model);
        System.out.println(computer);
    }
    private static void UpdateSN(Computer computer) {
        Long sn = scanner2.nextLong();
        computer.setSN(sn);
        System.out.println(computer);
    }
    private static void UpdatePrice(Computer computer) {
        double price = scanner2.nextDouble();
        computer.setPrice(price);
        System.out.println(computer);
    }
    private static void findComputersBy(String brand){
        for(int i=0; i< inventory.length; i++){
            if(inventory[i].getBrand().equals(brand))
                System.out.println(inventory[i]);
        }

    }
}