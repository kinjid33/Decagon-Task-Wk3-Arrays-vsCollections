package interfaces;

import entity.Customer;
import entity.Store;

public interface CashierInterface {
//    method to make sale
    void makeSale(Customer customer);
//    method to add to priority queue
    void addToPriorityQ(Customer customer);
//    method to make sales based on queue
    void makeQSales();
//    method to add to FIFO queue
    void addToNQ (Customer customer);
}
