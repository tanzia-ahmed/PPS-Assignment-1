package computerstore;
public class Computer {

    String brand;
    String model;
    long SN;
    double price;
    protected static int computerCount = 0;

    public Computer(String brandValue, String modelValue, long SNValue, double priceValue ) {

        brand = brandValue;
        model = modelValue;
        SN = SNValue;
        price = priceValue;

        computerCount ++;
    }

    public Computer() {

        this("Apple", "MacBook Pro1", 1, 1500 );
    }

    public Computer(Computer c) {
        this(c.brand, c.model, c.SN, c.price);

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getSN() {
        return SN;
    }

    public void setSN(long SN) {
        this.SN = SN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

     static int findNumberOfCreatedComputers() {
        return computerCount;
    }

    @Override
    public String toString() {
        return  "Brand :" + " "+ brand + "\n" +
                "Model :" + " " + model + "\n" +
                "SN :" + " " + SN + "\n" +
                "Price :" + " $" + price;
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
