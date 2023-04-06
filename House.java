import java.util.ArrayList;

/**
 * public class that builds a house using methods and attributes inherited from the Building class
 */
public class House extends Building {
  
    private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
    private boolean hasDiningRoom;
    private boolean hasElevator;

    /* Default constructor */
    public House() {
        super("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* Overloaded constructor with address only */
    public House(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    public House(String name, String address) {
        super(name, address); // Call full constructor with hard-coded # floors
    }

    /* Overloaded constructor with name, address, number of floors */
    public House(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Final constructor to build a house
     * @param name House name
     * @param address House address
     * @param nFloors Number of floors in the house
     * @param hasDiningRoom whether or not the house has an active dining room
     * @param hasElevator whether or not the house has an elevator
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        this(name, address, nFloors);
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        System.out.println("You have built a house: 🏠");
  }

    /**
     * Checks if the house has an active dining room or not
     * @return true if the house has an active dining room, false if not 
     */
    public boolean hasDiningRoom(){
        return this.hasDiningRoom;
  }

    /**
     * Checks if the house has an elevator or not
     * @return true if the house has an elevator, false if not
     */
    public boolean hasElevator(){
        return this.hasElevator;
  }

    /**
     * Gives the number of residents within the house 
     * @return the number of residents by getting the number of elements within the ArrayList residents
     */
    public int nResidents(){
        return this.residents.size();
  }

    /**
     * Moves a new resident into the house if the student is not already a resident of the house 
     * @param name Name of the student to be moved in
     */
    public void moveIn(String name){
        if (this.residents.contains(name)){
        throw new RuntimeException(name + " is already a resident of the house. Please try a different name.");
        }
        else{
        residents.add(name);
        System.out.println(name + " has successfully moved into the house.");
        }
  }

    /**
     * Moves a resident out of the house if the student is already a resident of the house
     * @param name Name of the student to be moved out
     * @return the name of the student to be moved out 
     */
    public String moveOut(String name){ 
        if (residents.contains(name)){
        residents.remove(name);
        System.out.println("Resident " + name + " has successfully moved out.");
        }
        else{
        throw new RuntimeException(name + " is not a resident of the house and therefore cannot move out. Please try a different name.");
        }
        return name;
  } 

    /**
     * Checks if a given student is a resident of the house or not
     * @param person Name of the student being checked
     * @return true if the student is a resident of the house
     */
    public boolean isResident(String person){    //as well as a boolean method that tells us whether or not a given person is a resident of the `House` (for security reasons, we don't want to provide direct access to the entire list of residents)
        if (this.residents.contains(person)){
        System.out.println(person + " is a resident of the house.");
        return true;
        }
        else{
        throw new RuntimeException(person + " is not a resident of the house.");
        }
  }

    /**
     * Overrides the toString() method to give a formatted description of the house
     */
    public String toString(){
        String description = super.toString();
        description = "There are currently " + this.nResidents() + " people living in this house.";

        if (this.hasDiningRoom == true){
        description = "This house has an active dining room.";
        }
        else{
        description = "This house does not have an active dining room";
        }

        return description;
  }

    public void showOptions() {
        super.showOptions();
        System.out.println(" + hasDiningRoom() \n + moveIn() \n + moveOut() \n + isResident()\n");
    }

    public void goToFloor(int floorNum){
        super.goToFloor(floorNum);
        if (this.hasElevator == true){
            System.out.println("You are now on " + floorNum + ".");
        }
        else{
            System.out.println("Cannot go to " + floorNum + " without an elevator. Sorry.");
        }
    }

    public static void main(String[] args) {
        House house = new House("Ziskind House", "1 Henshaw Ave", 3, true, true);
        house.moveIn("Tana");
        house.moveIn("Robbie");
        house.moveOut("Tana");
        // house.moveOut("Angela");
        house.isResident("Robbie");
        System.out.println(house.toString());
        house.showOptions();
  }

}