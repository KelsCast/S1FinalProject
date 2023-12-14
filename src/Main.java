import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    // Instantiate Bikes

    Motorcycle bike1 = new Motorcycle("Kawasaki", "Sportbike", "Ninja 400", 336.0, 30.9, 5699.0);
    Motorcycle bike2 = new Motorcycle("Kawasaki", "Standard", "Z400 ABS", 363.8, 30.9, 5399.0);
    Motorcycle bike3 = new Motorcycle("Yamaha", "Sportbike", "Y2F-R3", 375.0, 30.7, 5499.0);
    Motorcycle bike4 = new Motorcycle("Yamaha", "Standard", "MT-03", 373.0, 30.7, 4999.0);
    Motorcycle bike5 = new Motorcycle("Honda", "Standard", "Grom", 224.0, 30.0, 3599.0);
    Motorcycle bike6 = new Motorcycle("Honda", "Cruiser", "Rebel 500 ABS", 408.0, 27.2, 6799.0);
    Motorcycle bike7 = new Motorcycle("Harley-Davidson", "Cruiser", "Iron 883", 564.0, 25.7, 11249.0);

    public static void main(String[] args) {
        Main publicMethod = new Main();// use to call methods in main

        // Variables
        String userName;
        String userBike = "";
        String userType = "";
        String userBrand = "";
        double userBudget;
        int numGear;
        boolean buyGear;
        boolean valid;

        // New Java Objects
        Scanner scan = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();

        // Welcome + user name
        System.out.println("Welcome to the Motorcycle Dealership!" +
                "\nWhat is your name, valued customer? ");
        userName = scan.next();
        System.out.println(userName + "\n");// output username

        // get user budget
        System.out.print("What is your budget for today? $");
        userBudget = scan.nextDouble();
        System.out.println(money.format(userBudget) + "\n");// output user budget

        // get what type of bike wanted
        valid = false;
        while (!valid)// test if user input is valid
        {
            System.out.println("What bike type are you looking for?" +
                    "\n(Cruiser, Sportbike, or Standard)"); // valid inputs
            userType = scan.next();

            if (userType.equals("Cruiser") || userType.equals("Sportbike") || userType.equals("Standard"))
                valid = true;
            else
                System.out.println("Input Invalid");
        }
        System.out.println(userType + "\n");// output final user type
        publicMethod.bikeInventory(userType);// output bikes based on user type

        // Which bike to buy, Brand and Bike name
        valid = false;
        while (!valid) {
            System.out.println("\nWhich bike would you like?(Enter full name of bike)");
            userBrand = scan.next();
            if (scan.hasNext()) {
                userBike = scan.nextLine();
            }

            // Tests if brand name is valid
            if (userBrand.equals("Honda") || userBrand.equals("Yamaha") || userBrand.equals("Kawasaki")
                    || userBrand.equals("Harley-Davidson")) {
                // Test if user input is valid for bike name
                if (userBike.equals(" Ninja 400") || userBike.equals(" Z400 ABS") || userBike.equals(" Y2F-R3")
                        || userBike.equals(" MT-03")
                        || userBike.equals(" Grom") || userBike.equals(" Rebel 500 ABS") || userBike.equals(" Iron 883")) {
                    valid = true;
                } else
                    System.out.println("Invalid Input");
            } else
                System.out.println("Invalid Input");
        }
        System.out.println(userBrand + userBike + "\n"); // out user's final bike brand and model
        userBike = userBike.substring(1);// Removes space in beginning of String
        publicMethod.buyBike(userBike, userBudget);

        // Buying Gear
        System.out.println("\nWould you like to buy clothes/gear? (true/false)");
        buyGear = scan.nextBoolean();
        if (buyGear) {
            System.out.println("How much gear would you like? (1-5)");
            numGear = scan.nextInt();

            publicMethod.gearDiscount(userName, numGear);
        }

        System.out.println("Thank you for stopping by the Potato Motorcycle Dealership, Goodbye!");

    }// end main method

    public void bikeInventory(String type) {
        // Outputs the Number and Names of bikes according to the type chosen
        if (type.equals("Sportbike")) {
            System.out.println(Motorcycle.getSporBikes());
            System.out.println(bike1.getBrand() + " " + bike1.getName());
            System.out.println(bike3.getBrand() + " " + bike3.getName());
        } else if (type.equals("Standard")) {
            System.out.println(Motorcycle.getStanBikes());
            System.out.println(bike2.getBrand() + " " + bike2.getName());
            System.out.println(bike4.getBrand() + " " + bike4.getName());
            System.out.println(bike5.getBrand() + " " + bike5.getName());
        } else if (type.equals("Cruiser")) {
            System.out.println(Motorcycle.getCruiBikes());
            System.out.println(bike6.getBrand() + " " + bike6.getName());
            System.out.println(bike7.getBrand() + " " + bike7.getName());
        }

    }// end bikeInventory method

    public void buyBike(String bike, double budget) {
        // To output the bike's possible discount and if user can buy bike
        if (bike.equals("Ninja 400")) {
            System.out.println(bike1.isDiscount());
            System.out.println(bike1.canBuy(budget));
        } else if (bike.equals("Z400 ABS")) {
            System.out.println(bike2.isDiscount());
            System.out.println(bike2.canBuy(budget));
        } else if (bike.equals("Y2F-R3")) {
            System.out.println(bike3.isDiscount());
            System.out.println(bike3.canBuy(budget));
        } else if (bike.equals("MT-03")) {
            System.out.println(bike4.isDiscount());
            System.out.println(bike4.canBuy(budget));
        } else if (bike.equals("Grom")) {
            System.out.println(bike5.isDiscount());
            System.out.println(bike5.canBuy(budget));
        } else if (bike.equals("Rebel 500 ABS")) {
            System.out.println(bike6.isDiscount());
            System.out.println(bike6.canBuy(budget));
        } else if (bike.equals("Iron 883")) {
            System.out.println(bike7.isDiscount());
            System.out.println(bike7.canBuy(budget));
        } // End list of if-else statements
    }// end buyBike method

    public void gearDiscount(String name, int num) {
        // Gives user a discount code for however many pieces of gear they buy
        String[] gears = { "helmet", "gloves", "jacket", "pants", "boots" };
        String disGear;
        String discountCode;
        System.out.println("Each piece of gear gives you a discount code for 5% off!!");
        for (int i = 0; i < num; i++) {
            System.out.println("Buying " + gears[i] + "...");
            disGear = gears[i];
            discountCode = name.charAt(name.length() - 1) + disGear.substring(disGear.length() - 3) + i + (i + 2);
            // Creates discount code using last letter of user name, last 3 letters of gear
            // name, i, i+2;
            System.out.println(" Discount code: " + discountCode.toUpperCase());
        }
    }
}