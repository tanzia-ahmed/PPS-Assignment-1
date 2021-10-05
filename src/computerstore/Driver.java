// -----------------------------------------------------
// Assignment 1
// © Tanzia Ahmed
// © Abdul Shaik
// Written by: 40166924 Tanzia Ahmed
//             40182726 Abdul Shaik
// -----------------------------------------------------
/*
        This program has a Computer class with the required specifications (attributes, accessors and mutators,
        constructors) and a Driver class which has a various methods for different functions a computer store requires.
 */
package computerstore;

import java.util.Scanner;

import static computerstore.Computer.findNumberOfCreatedComputers;

/**
 * Driver Class
 */
public class Driver {

    private static String password;
    private static Scanner scanner1;
    private static Scanner scanner2;
    private static int maxComputers; //max number of computers that can be added
    private static Computer[] inventory; //array of computers

    /**
     * Main method
     * @param args args
     */
    public static void main(String[] args) {

        password = "password";

        // WELCOME MESSAGE
        System.out.println("Welcome to the computer tracking app!");
        System.out.println();
        System.out.println("How many computers (at maximum) can be stored in your computer store?");

        scanner1 = new Scanner(System.in);
        scanner2 = new Scanner(System.in);

        try {
            //PROMPT
            maxComputers = scanner1.nextInt();
            inventory = new Computer[maxComputers];

            Menu();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Display menu for the user/owner check password, various cases for different methods handled
     */
    private static void Menu() {
        int option = 0; //user input value
        while (option != 5) {
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
                //SEARCH BY BRAND
                case 3:
                    System.out.println("Enter the brand name you want to search:");
                    //PROMPT
                    String brand = scanner2.next();
                    findComputersBy(brand);
                    break;
                //SEARCH BY PRICE
                case 4:
                    System.out.println("Enter price to see all computers within the price :");
                    double pricelessthan = scanner2.nextDouble();
                    findCheaperThan(pricelessthan);
                    break;
                //QUIT
                case 5:
                    System.out.print("Good Bye! :)");
                    System.exit(0);

            }
        }
    }

    /**
     * Menu Options
     */
    private static void DisplayMenuOptions() {
        System.out.println("What do you want to do?\n" +
                "1. Enter new computers (password required)\n" +
                "2. Change information of a computer (password required)\n" +
                "3. Display all computers by a specific brand\n" +
                "4. Display all computers under a certain a price.\n" +
                "5. Quit\n" +
                "Please enter your choice >");
    }

    /**
     * Method to check if password is correct
     * @param givenPassword password entered
     * @return True if match else false
     */
    private static boolean checkPassword(String givenPassword) {
        boolean result = false;

        if (givenPassword.equals(password)) { //MATCHED
            result = true;
        } else {
        }
        return result;
    }

    /**
     * Method to ask user number of computers they wish to store
     */
    private static void EnterNewComputers() {
        if (findNumberOfCreatedComputers() == maxComputers) {
            System.out.println("HOUSEFULL!!");
        } else {
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

    /**
     * Update computer info
     */
    private static void UpdateComputer() {
        System.out.println("What computer number do you want to update?");


        //PROMPT
        int compIndex = scanner1.nextInt();

        if (compIndex < findNumberOfCreatedComputers() && compIndex > -1) {
            System.out.println("Computer # " + compIndex + "\n" +
                    inventory[compIndex].toString());
            UpdateMenu(inventory[compIndex]);
        } else {
            System.out.println("Sorry, this number is not registered with a computer.\n" +
                    "Do you want to enter a new computer (1) OR go back (0)?");
            //PROMPT
            int op = scanner1.nextInt();
            switch (op) {
                case 1:
                    EnterNewComputers();
                    break;
                case 0:
                    return;
            }
        }
    }

    /**
     * Menu options for updating various attributes of a computer
     * @param computer computer object to update
     */
    private static void UpdateMenu(Computer computer) {
        int option = 0; //user input value
        while (option != 5) {
            DisplayUpdateMenuOptions();

            //PROMPT
            option = scanner2.nextInt();
            switch (option) {
                case 1:
                    //BRAND
                    System.out.println("Change brand name " + computer.getBrand() + " to:");
                    UpdateBrand(computer);
                    System.out.println(computer);
                    break;
                case 2:
                    //MODEL
                    System.out.println("Change model name " + computer.getModel() + " to:");
                    UpdateModel(computer);
                    System.out.println(computer);
                    break;
                case 3:
                    //SN
                    System.out.println("Change serial number " + computer.getSN() + " to:");
                    UpdateSN(computer);
                    break;
                case 4:
                    //PRICE
                    System.out.println("Change price " + computer.getPrice() + " to:");
                    UpdatePrice(computer);
                    break;
                case 5:
                    //QUIT
                    return;
            }
        }
    }

    /**
     * Menu display
     */
    private static void DisplayUpdateMenuOptions() {
        System.out.println("What information would you like to change?\n" +
                "1. brand\n" +
                "2. model\n" +
                "3. SN\n" +
                "4. price\n" +
                "5. Quit\n" +
                "Enter your choice >");
    }

    /**
     * Method to update brand
     * @param computer computer object
     */
    private static void UpdateBrand(Computer computer) {
        Scanner sc = new Scanner(System.in);
        //PROMPT
        String brand = sc.nextLine();
        computer.setBrand(brand);
    }

    /**
     * Method to update model
     * @param computer computer object
     */
    private static void UpdateModel(Computer computer) {
        Scanner sc = new Scanner(System.in);
        //PROMPT
        String model = sc.nextLine();
        computer.setModel(model);
    }

    /**
     * Method to update Sn
     * @param computer computer object
     */
    private static void UpdateSN(Computer computer) {
        //PROMPT
        Long sn = scanner2.nextLong();
        computer.setSN(sn);
        System.out.println(computer);
    }

    /**
     * Method to update price
     * @param computer computer object
     */
    private static void UpdatePrice(Computer computer) {
        //PROMPT
        double price = scanner2.nextDouble();
        computer.setPrice(price);
        System.out.println(computer);
    }

    /**
     * Method to find computer by brand
     * @param brand brand
     */
    private static void findComputersBy(String brand) {
        boolean flag = false;
        for (int i = 0; i < findNumberOfCreatedComputers(); i++) {
            if (inventory[i].getBrand().equals(brand)) {
                System.out.println(inventory[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No such brands in the house! :(");
        }

    }

    /**
     * Method to find computers less than a particular price
     * @param pricelessthan price
     */
    private static void findCheaperThan(double pricelessthan) {
        boolean flag = false;
        for (int i = 0; i < findNumberOfCreatedComputers(); i++) {
            if (inventory[i].getPrice() < pricelessthan) {
                System.out.println(inventory[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Sorry ! No computers available below this price");
        }
    }
}