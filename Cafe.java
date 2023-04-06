/**
 * public class that builds a cafe using methods and attributes from the Building class
 */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory

    private int nSugarPackets; // The number of sugar packets remaining in inventory

    private int nCreams; // The number of "splashes" of cream remaining in inventory

    private int nCups; // The number of cups remaining in inventory 


    /**
     * Constructor to build a cafe
     * @param name Cafe name
     * @param address Cafe address
     * @param nFloors Number of floors in the cafe
     * @param nCoffeeOunces Ounces of coffee available in the cafe 
     * @param nSugarPackets Number of sugar packets available in the cafe 
     * @param nCreams Amount of cream available in the cafe 
     * @param nCups Number of cups available in the cafe
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Restocks the ingredients if the current stock is not enough to fulfill a customer's order
     * @param nCoffeeOunces Ounces of coffee
     * @param nSugarPackets Number of sugar packets
     * @param nCreams Amount of cream
     * @param nCups Number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += 50;
        this.nSugarPackets += 20;
        this.nCreams += 20;
        this.nCups += 15;
    }

    /**
     * Sells a coffee according to the customer's request for size, amount of sugar, and amount of coffee and restocks the ingredients if there aren't enough for the order
     * @param size Requested coffee size in ounces
     * @param nSugarPackets Requested amount of sugar
     * @param nCreams Requested amount of cream 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < nCups){
            restock(this.nCoffeeOunces, this.nSugarPackets, this.nCreams, this.nCreams);
            System.out.println("Items have been restocked: Coffee = " + this.nCoffeeOunces + " oz, Sugar packets = " + this.nSugarPackets + " packets, Creams = " + this.nCreams + " splashes of cream, Cups = " + this.nCups + " cups.");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    
        System.out.println("Here is your " + size + " oz coffee with " + nSugarPackets + " sugar packets and " + nCreams + " splashes of cream. Enjoy!");
        
    }

    //Overloaded method for sellCoffee
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int cupsWanted){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || cupsWanted < this.nCups){
            restock(this.nCoffeeOunces, this.nSugarPackets, this.nCreams, this.nCreams);
            System.out.println("Items have been restocked: Coffee = " + this.nCoffeeOunces + " oz, Sugar packets = " + this.nSugarPackets + " packets, Creams = " + this.nCreams + " splashes of cream, Cups = " + this.nCups + " cups.");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= -cupsWanted;
    
        if (cupsWanted == 1){
            System.out.println("Here is your " + size + " oz coffee with " + nSugarPackets + " sugar packets and " + nCreams + " splashes of cream. Enjoy!");
        }
        else {
            System.out.println("Here are your " + cupsWanted + " " + size + " oz coffees with " + nSugarPackets + " sugar packets and " + nCreams + " splashes of cream. Enjoy!");
        }
       
        
    }

    public void showOptions() {
        super.showOptions();
        System.out.println(" + restock() \n + sellCoffee() \n");
    }

    public void goToFloor(int floorNum){
        super.goToFloor(activeFloor);
        if (floorNum == 1){
            System.out.println("You are now on " + floorNum + ".");
        }
        else{
            System.out.println("Cannot go to " + floorNum + " -- for employees only. Sorry.");
        }
    }
    
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Compass Cafe", "Library", 4, 50, 50, 50, 10);
        cafe.sellCoffee(12, 3, 3, 1);
        cafe.sellCoffee(45, 53, 12, 12);
        cafe.showOptions();
    }
    
}
