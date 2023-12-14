import java.text.NumberFormat;
import java.util.Random;

public class Motorcycle {
    // Brand, Type, Name, Weight, Height, Cost
    private String brand;
    private String type;
    private String name;
    private double weight;
    private double height;
    private double price;

    // Static, # of motorcycles, tax price
    static private int bikeCount = 0;
    static private int sporBikes = 0;
    static private int stanBikes = 0;
    static private int cruiBikes = 0;

    Random gen = new Random();

    // Money format
    NumberFormat dollar = NumberFormat.getCurrencyInstance();

    // Constructors
    public Motorcycle() {
        this.brand = "";
        this.type = "";
        this.name = "";
        this.weight = 0.0;
        this.height = 0.0;
        this.price = 0.0;
        bikeCount++;
    }// Default Constructor

    public Motorcycle(String inBrand, String inType, String inName, double inWeight, double inHeight, double inPrice) {
        this.brand = inBrand;
        this.type = inType;
        this.name = inName;
        this.weight = inWeight;
        this.height = inHeight;
        this.price = inPrice;
        bikeCount++;
        // what type of bike
        if (type.equals("Sportbike"))
            sporBikes++;
        else if (type.equals("Standard"))
            stanBikes++;
        else if (type.equals("Cruiser"))
            cruiBikes++;
    }// Full Constructor

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    // Setters

    // Brain Methods
    // Discount based on Brand
    // check for brand Kawasaki or Honda
    // Discount deal is 15% off
    public String isDiscount() {
        String output = brand + " does not have a discount, \n the price is ";
        if (brand.equals("Kawasaki") || brand.equals("Honda")) {
            price -= price * 0.15;
            output = brand + " has a discount of " + 15 + "% off, \n The price is now ";
        }
        output += dollar.format(price) + " for the " + name;
        return output;
    }

    // Can buy motorcycle?
    // compare budget to bike cost
    // if budget > cost; Can buy bike
    // if budget < cost; Cannot buy bike
    public String canBuy(double budget) {
        String output = "The " + name + " costs " + dollar.format(price);
        if (budget >= price)
            output += "\n You have enough to buy the " + name +
                    " and will have " + dollar.format(budget - price) + " left over.";
        else
            output += "\n You need " + dollar.format(price - budget) + " more to buy the " + name;
        return output;
    }

    // Static Methods
    // Get bikeCount
    static public String getBikeCount() {
        return ("Bike inventory: " + bikeCount + " motorcycles");
    }

    // SportBikes
    static public String getSporBikes() {
        return ("Number of Sportbikes in-store: " + sporBikes + " out of " + bikeCount);
    }

    // Standards
    static public String getStanBikes() {
        return ("Number of Standard bikes in-store: " + stanBikes + " out of " + bikeCount);
    }

    // Cruisers
    static public String getCruiBikes() {
        return ("Number of Cruiser bikes in-store: " + cruiBikes);
    }

    // toString
    public String toString() {
        return "Brand: " + brand +
                "\nBike Type: " + type +
                "\nName: " + name +
                "\nTotal Weight: " + weight + "lb" +
                "\nSeat Height: " + height + "in" +
                "\nAvg Pricing: " + dollar.format(price);
    }

}