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

/**
 * Computer Class
 * Atrributes : brand, model, Serial Number, price, computer count
 */
public class Computer {

    String brand;
    String model;
    long SN;
    double price;
    protected static int computerCount = 0;

    /**
     * Parametrized Constructor for Computer
     * @param brandValue brand
     * @param modelValue model
     * @param SNValue Serial Number
     * @param priceValue Price
     */
    public Computer(String brandValue, String modelValue, long SNValue, double priceValue ) {

        brand = brandValue;
        model = modelValue;
        SN = SNValue;
        price = priceValue;

        computerCount ++;
    }

    /**
     * default constructor
     */
    public Computer() {

        this("Apple", "MacBook Pro1", 1, 1500 );
    }

    /**
     * Copy Constructor
     * @param c computer object to copy
     */
    public Computer(Computer c) {
        this(c.brand, c.model, c.SN, c.price);

    }

    /**
     * Getter for brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter for brand
     * @param brand brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter for model
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for model
     * @param model model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter for Sn
     * @return SN
     */
    public long getSN() {
        return SN;
    }

    /**
     * Setter for SN
     * @param SN Sn
     */
    public void setSN(long SN) {
        this.SN = SN;
    }

    /**
     * Getter for price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Static method to find number of computers at any time
     * @return number of computers
     */
     static int findNumberOfCreatedComputers() {
        return computerCount;
    }

    /**
     * To string method to display computer information
     * @return Computer information
     */
    @Override
    public String toString() {
        return  "Brand :" + " "+ brand + "\n" +
                "Model :" + " " + model + "\n" +
                "SN :" + " " + SN + "\n" +
                "Price :" + " $" + price;
    }

    /**
     * Method to show information of a particular computer
     * @param c computer object
     */
    public static void showComputerInfo(Computer c) {

        System.out.println(c);
    }

    /**
     * Method to check if two computers are same
     * @param x Any Object
     * @return True if Object is the same computer else False
     */
    public boolean equals(Object x) {
        if (x == null || this == null || this.getClass() != x.getClass())
            return false;
        else
        {
            Computer c = (Computer)x;
            return (this.brand == c.brand && this.model == c.model && this.price == c.price);
        }
    }

    /**
     * Main Method to create computer objects and use functionality
     * @param args args
     */
    public static void main(String[] args) {


        Computer c1 = new Computer();
        Computer c2 = new Computer("Lenovo", "Thinkpad", 2, 1000);
        Computer c3 = new Computer(c1);
        Computer c4 = new Computer();
        c4.setBrand("Dell"); c4.setModel("Inspiron"); c4.setSN(4); c4.setPrice(1200);

        showComputerInfo(c1);
        showComputerInfo(c2);
        showComputerInfo(c3);
        showComputerInfo(c4);

        findNumberOfCreatedComputers();

        if(c2.equals(c3))
            System.out.println("Computers are the same");
        else
            System.out.println("Computers are different");

        if(c1.equals(c3))
            System.out.println("Computers are the same");
        else
            System.out.println("Computers are different");
    }

}
