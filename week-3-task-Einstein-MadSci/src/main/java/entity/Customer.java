package entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer extends User implements Comparable<Customer> {
    //    description of entity
    private final Description description;

    //    cash in customers hand, initialised to $20,000 in constructor
    private int cashInHand;

    //    Store object related to the class
    private Store store;

    //    array list of products in customer class
    private List<Product> productListInCustomer = new ArrayList<>();

    //    quantity of product customer wants to buy
    private int quantityToBuy;

    public Customer(String userName, Store store) {
        super(userName);
        this.description = Description.CUSTOMER;
        this.cashInHand = 20_000;
        this.productListInCustomer = productListInCustomer;
        this.store = store;
    }

    //    setter for quantity to buy
    public void setQuantityToBuy(int quantityToBuy) {
        this.quantityToBuy = quantityToBuy;
    }

    //    setter for cash in hand (cash in hand is $20,000 by default, this method subtracts from cash in hand
    //    and updates the value in cash in hand)
    public void setCashInHand(int amount) {
        this.cashInHand -= amount;
    }

    //    getter for product to buy list (cart)
    public List<Product> getProductListInCustomer() {
        return productListInCustomer;
    }

    //    getter for quantity to buy
    public int getQuantityToBuy() {
        return quantityToBuy;
    }

    //    getter for cash in hand
    public int getCashInHand() {
        return cashInHand;
    }

    //    logic to compare objects in priority queue
    @Override
    public int compareTo(Customer other) {
        return other.productListInCustomer.size() - this.productListInCustomer.size();
    }

    //    toString method to allow printing parameters in the object
    @Override
    public String toString() {
        return "Customer " + getUserName();
    }
}