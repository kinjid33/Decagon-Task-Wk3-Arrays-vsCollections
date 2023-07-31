package entity;

public class Manager extends User {

    //    store related to the class
    private Store store;

    //    description of class
    private final Description description;

    //constructor for initializing manager objects
    public Manager(String userName, Store store) {
        super(userName);
        this.description = Description.MANAGER;
        this.store = store;
    }
}
