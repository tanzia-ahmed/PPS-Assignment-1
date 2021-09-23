public class Computer {

    String brand;
    String model;
    long SN;
    double price;
    protected static int computerCount = 0;

    public Computer() {

        System.out.println("Creating Computer using default constructor");

        brand = "Apple"; model = "MacBook Pro1"; SN = 1; price = 1500;

        computerCount ++;
    }

    public Computer(String brandValue, String modelValue, long SNValue, double priceValue ) {

        System.out.println("Creating Computer using parametrized constructor");

        brand = brandValue;
        model = modelValue;
        SN = SNValue;
        price = priceValue;

        computerCount ++;
    }

    public Computer(Computer c) {

        System.out.println("Creating Computer using copy constructor");

        brand = c.brand;
        model = c.model;
        SN = c.SN;
        price = c.price;

        computerCount ++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("Changing brand of Computer from :" + " " + this.brand + " " + "to " + brand);
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        System.out.println("Changing model of Computer from :" + " " + this.model + " " + "to " + model);
        this.model = model;
    }

    public long getSN() {
        return SN;
    }

    public void setSN(long SN) {
        System.out.println("Changing SN of Computer from :" + " " + this.SN + " " + "to " + SN);
        this.SN = SN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.println("Changing price of Computer from :" + " " + this.price + " " + "to " + price);
        this.price = price;
    }

    public static int findNumberOfCreatedComputers() {

        System.out.println("The number of Computers in the store are :" + " " +computerCount);
        return computerCount;
    }

    @Override
    public String toString() {
        return "Details of this Computer are" + " " + "Brand :" + " "+ brand + " " + "Model :" + " " + model + " "
                + "Serial Number :" + " " + SN + " " + "Price :" + " " + price + " " + "$";
    }

    public static void showComputerInfo(Computer c) {

        System.out.println(c);
    }

    public boolean equals(Object x) {
        if (x == null || this == null || this.getClass() != x.getClass())
            return false;
        else
        {
            Computer c = (Computer)x;
            return (this.brand == c.brand && this.model == c.model && this.price == c.price);
        }
    }
    public static void main(String[] args) {


        Computer c1 = new Computer();
        Computer c2 = new Computer("Lenovo", "Thinkpad", 2, 1000);
        Computer c3 = new Computer(c2);
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
