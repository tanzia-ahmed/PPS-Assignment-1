// -----------------------------------------------------
// Assignment 1
// © Tanzia Ahmed
// © Abdul Shaik
// Written by: 40166924 - Tanzia Ahmed
//             40182726 - Abdul Shaik
// -----------------------------------------------------
/*
        This program has a Computer class with the required specifications (attributes, accessors and mutators,
        constructors) and a Driver class which has a various methods for different functions a computer store requires.
 */
package AHMED_40166924_SHAIK_40182726;

import java.util.InputMismatchException;
import java.util.Scanner;

import static AHMED_40166924_SHAIK_40182726.Computer.findNumberOfCreatedComputers;
/**
 * Driver Class
 */
public class Driver {

    private static String password;
    private static int maxComputers; //max number of computers that can be added
    private static Computer[] inventory; //array of computers

    /**
     * Main method
     * @author 40166924 - AHMED
     */
    public static void main(String[] args) {

        password = "password";

        // WELCOME MESSAGE
        System.out.println("Welcome to the computer tracking app!");
        System.out.println();

        Scanner s=null;

        boolean matchedInputType = false;
        while(matchedInputType==false) { //prompting until input type matched--expected integer type
            try {
                System.out.println("How many computers (at maximum) can be stored in your computer store?");
                //PROMPT
                s=new Scanner(System.in);
                maxComputers = s.nextInt();
                matchedInputType = true;
            }catch (InputMismatchException e) {
                matchedInputType = false;
                System.out.println(e);
                System.out.println();
            }
            catch (Exception e) {
                System.out.println(e);
                break;
            }
        }

        inventory = new Computer[maxComputers];
        Menu();

    }

    /**
     * Main Menu, various cases for different methods handled
     * @author 40166924 - AHMED
     */
    private static void Menu() {
        int option = 0; //user input value
        while (option != 5) {
            Scanner s=null;
            boolean matchedInputType = false;
            while(matchedInputType==false) { //prompting until input type matched--expected integer type
                try {
                    //PROMPT
                    DisplayMenuOptions();
                    s=new Scanner(System.in);
                    option = s.nextInt();
                    matchedInputType = true;
                } catch (InputMismatchException e) {
                    matchedInputType = false;
                    System.out.println(e);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e);
                    break;
                }
            }
            switch (option) {
                //1. ENTER NEW COMPUTERS
                case 1:
                    System.out.print("Enter Password: ");
                    for (int i = 0; i < 3; i++) { //check password 3 times
                        Scanner scanner = new Scanner(System.in);
                        //PROMPT
                        String givenPassword = scanner.next();
                        //CHECKING PASSWORD
                        boolean pwPassed = checkPassword(givenPassword);
                        if (pwPassed) { //MATCHED
                            EnterNewComputers();
                            break;
                        } else { //DIDN'T MATCH
                            System.out.println("Oops!! Wrong Password!");
                            System.out.println();
                            if (i < 2)
                                System.out.print("Enter Password Again: ");
                        }

                    }
                    break;
                //2. UPDATE INFORMATION OF A COMPUTER
                case 2:
                    System.out.print("Enter Password: ");
                    for (int i = 0; i < 3; i++) { //check password 3 times
                        Scanner scanner = new Scanner(System.in);
                        //PROMPT
                        String givenPassword = scanner.next();
                        //CHECKING PASSWORD
                        boolean pwPassed = checkPassword(givenPassword);
                        if (pwPassed) { //MATCHED
                            UpdateComputer();
                            break;
                        } else { //DIDN'T MATCH
                            System.out.println("Oops!! Wrong Password!");
                            System.out.println();
                            if (i < 2)
                                System.out.print("Enter Password Again: ");
                        }

                    }
                    break;
                //3. SEARCH BY BRAND
                case 3:
                    System.out.println("Enter the brand name you want to search:");
                    Scanner scanner = new Scanner(System.in);
                    //PROMPT
                    String brand = scanner.next();
                    findComputersBy(brand);
                    break;
                //4. SEARCH BY PRICE
                case 4:
                    Scanner s2=null;
                    boolean matchedInputType2 = false;
                    double pricelessthan = 0;
                    while(matchedInputType2==false) { //prompting until input type matched--expected double type
                        try {
                            //PROMPT
                            System.out.println("Enter price to see all computers within the price :");
                            s2=new Scanner(System.in);
                            pricelessthan = s2.nextDouble();
                            matchedInputType = true;
                            break;

                        } catch (InputMismatchException e) {
                            matchedInputType = false;
                            System.out.println(e);
                            System.out.println();
                        } catch (Exception e) {
                            System.out.println(e);
                            break;
                        }
                    }
                    findCheaperThan(pricelessthan);
                    break;
                //5. QUIT
                case 5:
                    System.out.print("Good Bye! :)");
                    System.exit(0);

            }
        }
    }

    /**
     * Display main menu options
     * @author 40166924 - AHMED
     */
    private static void DisplayMenuOptions() {
        System.out.println("What do you want to do?\n" +
                "1. Enter new computers (password required)\n" +
                "2. Change information of a computer (password required)\n" +
                "3. Display all computers by a specific brand\n" +
                "4. Display all computers under a certain price.\n" +
                "5. Quit\n" +
                "Please enter your choice >");
    }

    /**
     *  Method to check if password is correct
     *  @param givenPassword password entered
     *  @return True if match else false
     * @author 40166924 - AHMED
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
     * To enter new computer
     * @author 40166924 - AHMED
     */
    private static void EnterNewComputers() {
        if (findNumberOfCreatedComputers() == maxComputers) {
            System.out.println("HOUSEFULL!!");
        } else {
            Scanner s=null;
            int numComp = 0;
            boolean matchedInputType = false;
            while(matchedInputType==false) { //prompting until input type matched--expected integer type
                try {
                    System.out.println("How many computers do you want to enter?");
                    //PROMPT
                    s = new Scanner(System.in);
                    numComp = s.nextInt();
                    matchedInputType = true;
                }catch (InputMismatchException e) {
                    matchedInputType = false;
                    System.out.println(e);
                    System.out.println();
                }
                catch (Exception e) {
                    System.out.println(e);
                    break;
                }
            }
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
     * To update any computer
     * @author 40166924 - AHMED
     */
    private static void UpdateComputer() {
        Scanner s=null;
        int compIndex = 0;
        boolean matchedInputType = false;
        while(matchedInputType==false) { //prompting until input type matched--expected integer type
            try {
                System.out.println("What computer number do you want to update?");
                s = new Scanner(System.in);
                //PROMPT
                compIndex = s.nextInt();
                matchedInputType = true;
            }catch (InputMismatchException e) {
                matchedInputType = false;
                System.out.println(e);
                System.out.println();
            }
            catch (Exception e) {
                System.out.println(e);
                break;
            }
        }

        if (compIndex < findNumberOfCreatedComputers() && compIndex > -1) { //if computer index is valid
            System.out.println("Computer # " + compIndex + "\n" +
                    inventory[compIndex].toString());
            UpdateMenu(inventory[compIndex]);
        } else { //if computer index is invalid
            System.out.println("Sorry, this number is not registered with a computer.\n" );
            Scanner s2=null;
            boolean matchedInputType2 = false;
            int op = 0;
            while(matchedInputType2==false) { //prompting until input type matched--expected integer type
                try {
                    System.out.println("Do you want to enter a new computer (1) OR go back (0)?");
                    s2 = new Scanner(System.in);
                    //PROMPT
                    op = s2.nextInt();
                    matchedInputType2 = true;
                } catch (InputMismatchException e) {
                    matchedInputType2 = false;
                    System.out.println(e);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e);
                    break;
                }
            }

            switch (op) {
                //1. ENTER NEW COMPUTER
                case 1:
                    EnterNewComputers();
                    break;
                //0. GO BACK TO MENU
                case 0:
                    return;
            }
        }
    }

    /**
     * Updates details of a computer
     * @author 40166924 - AHMED
     */
    private static void UpdateMenu(Computer computer) {
        int option = 0; //user input value
        while (option != 5) {
            Scanner s=null;
            boolean matchedInputType = false;
            while(matchedInputType==false) { //prompting until input type matched--expected integer type
                try {
                    DisplayUpdateMenuOptions();
                    s = new Scanner(System.in);
                    //PROMPT
                    option = s.nextInt();
                    matchedInputType = true;
                    break;
                }catch (InputMismatchException e) {
                    matchedInputType = false;
                    System.out.println(e);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e);
                    break;
                }
            }
            switch (option) {
                case 1:
                    //BRAND
                    UpdateBrand(computer);
                    break;
                case 2:
                    //MODEL
                    UpdateModel(computer);
                    break;
                case 3:
                    //SN
                    UpdateSN(computer);
                    break;
                case 4:
                    //PRICE
                    UpdatePrice(computer);
                    break;
                case 5:
                    //QUIT
                    return; // returns to main menu
            }
        }
    }

    /**
     * Display update menu options
     * @author 40166924 - AHMED
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
     * Updates brand
     * @param computer object
     * @author 40166924 - AHMED
     */
    private static void UpdateBrand(Computer computer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Change brand name " + computer.getBrand() + " to:");
        //PROMPT
        String brand = sc.nextLine();
        computer.setBrand(brand);
        System.out.println(computer);
    }

    /**
     * Updates model
     * @param computer object
     * @author 40166924 - AHMED
     */
    private static void UpdateModel(Computer computer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Change model name " + computer.getModel() + " to:");
        //PROMPT
        String model = sc.nextLine();
        computer.setModel(model);
        System.out.println(computer);
    }

    /**
     * Updates Serial Number (SN)
     * @param computer object
     * @author 40166924 - AHMED
     */
    private static void UpdateSN(Computer computer) {
        Scanner s=null;
        Long sn = Long.valueOf(0);
        boolean matchedInputType = false;
        while(matchedInputType==false) { //prompting until input type matched--expected long type
            try {
                System.out.println("Change serial number " + computer.getSN() + " to:");
                s=new Scanner(System.in);
                //PROMPT
                sn = s.nextLong();
                matchedInputType = true;
            }catch (InputMismatchException e) {
                matchedInputType = false;
                System.out.println(e);
                System.out.println();
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }

        computer.setSN(sn);
        System.out.println(computer);
    }

    /**
     * Updates price
     * @param computer object
     * @author 40166924 - AHMED
     */
    private static void UpdatePrice(Computer computer) {
        Scanner s=null;
        double price = 0;
        boolean matchedInputType = false;
        while(matchedInputType==false) { //prompting until input type matched--expected double type
            try {
                System.out.println("Change price " + computer.getPrice() + " to:");
                s=new Scanner(System.in);
                //PROMPT
                price = s.nextDouble();
                matchedInputType = true;
            }catch (InputMismatchException e) {
                matchedInputType = false;
                System.out.println(e);
                System.out.println();
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }

        computer.setPrice(price);
        System.out.println(computer);
    }

    /**
     * To search computers by brand name
     * @param brand
     * @author 40166924 - AHMED
     */
    private static void findComputersBy(String brand) {
        boolean flag = false;
        for (int i = 0; i < findNumberOfCreatedComputers(); i++) {
            if (inventory[i].getBrand().equalsIgnoreCase(brand)) {
                System.out.println(inventory[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No such brands in the house! :(");
        }

    }
    /**
     * To search computers by price
     * displays computers having price less than the value given
     *  @param pricelessthan
     * @author 40182726 - SHAIK
     * edited by: 40166924 - AHMED
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