package entity;

public class Cashier extends User {
    //    description of entity
    private final Description description;
    //    store object related to this class
    private Store store;
    //    number of strikes cashier has (3 == fired)
    private int strikeCount;
    //    boolean indicating employment status
    private boolean isFired = false;

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    //    boolean recording whether a customer has been checked out
    private boolean checkOut;
    //    constructor
    public Cashier(String userName, Store store) {
        super(userName);
        this.description = Description.CASHIER;
        this.store = store;
    }
    // getter for strike count
    public int getStrikeCount() {
        return strikeCount;
    }
    //  setter for strike count
    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
    //  getter for employment status boolean
    public boolean isFired() {
        return isFired;
    }
    //  setter for employment status
    public void setFired(boolean fired) {
        isFired = fired;
    }
    //    method for cashier to make sale

    //    getter for checkout boolean
    public boolean isCheckOut() {
        return checkOut;
    }
}
