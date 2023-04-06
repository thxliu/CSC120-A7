import java.util.Hashtable;

/**
 * public class that builds a library using methods and attributes inherited from the Building class
 */
public class Library extends Building{

    private Hashtable<String, Boolean> collection; 
    private boolean hasElevator;

    /**
     * Constructor to build a library
     * @param name Library name
     * @param address Library address
     * @param nFloors Number of floors in the library 
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        this.hasElevator = hasElevator;
        System.out.println("You have built a library: 📖");
    }

    /**
     * Checks if the library has an elevator or not
     * @return true if the library does, false if it does not
     */
    public boolean hasElevator(){
        return this.hasElevator;
    }

    /**
     * Adds a book into the library's collection if it isn't already a part of it
     * @param title the title of the book
     */
    public void addTitle(String title){
        if (this.collection.containsKey(title)){
        throw new RuntimeException(title + " is already part of the collection.");
        }
        else{
        this.collection.put(title, true);
        System.out.println(title + " has successfully been added into the collection.");
        }
    }

    /**
     * Removes a title from the library's collection if it's part of it
     * @param title title of the book 
     * @return the title that was removed
     */
    public String removeTitle(String title){ // 
        if (this.collection.containsKey(title)) {
        this.collection.remove(title);
        System.out.println(title + " has successfully been removed from the collection.");
        }
        else{
        System.out.println(title + " is not part of the collection and therefore cannot be removed. Please try a different title.");
        }
        return title;
    } 

    /**
     * Checks out a title if it's part of the library's collection by replacing the value from true to false
     * @param title title of the checked out book
     */
    public void checkOut(String title){ 
        if (this.collection.containsKey(title)){
        this.collection.replace(title, true, false);
        System.out.println(title + " has been successfully checked out.");
        }
        else {
        System.out.println(title + " is not part of the collection and therefore cannot be checked out. Please try a different title.");
        }
    }

    /**
     * Returns a book if its value is false and therefore has been checked out by replacing the value from false to true 
     * @param title
     */
    public void returnBook(String title){
        if (this.collection.containsKey(title)){
        if (this.collection.get(title) == false){
            this.collection.replace(title, false, true);
            System.out.println(title + " has been successfully returned to the collection. Thank you!");
        }
        else{
            System.out.println(title + " was not checked out from the collection.");
        }
        }
        else{
        throw new RuntimeException(title + " is not a part of the collection and therefore cannot be returned. Please try a different title.");
        }
        }

    /**
     * Checks if a title is part of the library's collection
     * @param title title of the book to be checked
     * @return true if the title is part of the collection, false if it is not 
     */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        System.out.println(title + " is a part of the Library's collection");
        return true;
      }
      else {
        System.out.println(title + " is not part of the Library's collection");
        return false;
      }
    } 

    /**
     * Checks if a title is available to be checked out 
     * @param title title of the book
     * @return true if the book is available, false if it is not
     */
    public boolean isAvailable(String title){ 
      if (this.collection.containsKey(title)){
        if (this.collection.contains(true)){
          System.out.println(title + " is currently available");
          return true;
        }
        else{
          System.out.println(title + " is currently unavailable");
          return false;
        }
      }
      else {
        throw new RuntimeException(title + " is not part of the Library's collection.");
      }
    } 

    /**
     * Prints the titles within the library's collection and their checkout status as true if available and false if not
     */
    public void printCollection(){
      for (String title: this.collection.keySet()){
        System.out.println(title + " is available? " + this.collection.get(title));
      }
    } 

    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()\n");
    }

    public void goToFloor(int floorNum){
        super.goToFloor(floorNum);
        if (this.hasElevator == true){
            System.out.println("Cannot go to " + floorNum + ". Please take the elevator.");
        }
    }
  
  
    public static void main(String[] args) {
        Library library = new Library("Neilson", "1 College Way", 4, true);
        library.addTitle("Harry Potter");
        library.addTitle("Percy Jackson");
        library.removeTitle("Hunger Games");
        library.checkOut("Harry Potter");
        library.checkOut("Percy Jackson");
        library.returnBook("Harry Potter");
        library.printCollection();
        library.showOptions();
    }
  
}
