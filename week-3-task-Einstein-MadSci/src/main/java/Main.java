import entity.*;
import exceptions.ApplicantUnderageException;
import exceptions.ProductInStockIsLessThanOrderException;
import exceptions.ProductOutOfStockException;
import org.w3c.dom.ls.LSOutput;
import services.CashierServiceImpl;
import services.CustomerServiceImpl;
import services.ManagerServiceImpl;
import services.StoreServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //        create new store object to relate to objects
        Store store = new Store();
        StoreServiceImpl storeServ = new StoreServiceImpl(store);


        //        read products from csv file
        storeServ.readProduct();

        System.out.println(store.getProductList());
        //        create manager object
        Manager manager = new Manager("Ade", store);

        //        pass manager object to manager service implementation object
        ManagerServiceImpl managerServ = new ManagerServiceImpl(manager);

        //        create new cashier object
        Cashier cashier = new Cashier("Bola", store);

        //        pass cashier object to cashier service implementation object
        CashierServiceImpl cashierServ = new CashierServiceImpl(cashier);

        //        create three customer objects
        Customer customer = new Customer("Chris", store);
        Customer customer1 = new Customer("Fade", store);
        Customer customer2 = new Customer("Felix", store);

        //        pass three customers above to customer service implementation objects
        CustomerServiceImpl customerServ = new CustomerServiceImpl(customer, store);
        CustomerServiceImpl customerServ1 = new CustomerServiceImpl(customer1, store);
        CustomerServiceImpl customerServ2 = new CustomerServiceImpl(customer2, store);

        cashierServ.setStore(store);

        //        create applicant (potential cashier) object
        var applicant = new PotentialCashier("Kale", 20, store);
        var applicant2 = new PotentialCashier("Femi", 16, store);

        //        create array list of customers
        List<Customer> customerList = new ArrayList<>();

        //        hire potential cashier
        try {
            managerServ.hireCashier(applicant);
            managerServ.hireCashier(applicant2);
        } catch (ApplicantUnderageException e) {
            System.out.println(e.getMessage());
        }

//        strike and fire cashier (applicant)
        managerServ.strikeCashier(applicant);
        managerServ.strikeCashier(applicant);
        managerServ.strikeCashier(applicant);
        managerServ.fireCashier(applicant);

        //        customers buy products
        try {
            customerServ.buyProducts("Electric Kettle", 10);
            customerServ.buyProducts("Fanta", 2);
            customerServ.buyProducts("Electric Iron", 1);
            customerServ1.buyProducts("Sprite", 2);
            customerServ1.buyProducts("7Up", 3);
            customerServ2.buyProducts("Maltina", 4);
        } catch (ProductOutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (ProductInStockIsLessThanOrderException e) {
            throw new RuntimeException(e);
        }

//        cashierServ.makeSale(customer);

        //        add customers to priority queue
        cashierServ.addToPriorityQ(customer);
        cashierServ.addToPriorityQ(customer1);
        cashierServ.addToPriorityQ(customer2);
        System.out.println("Customer priority queue: " + cashierServ.getCustomerPQueue().size());

        //        add customers to FIFO queue
        cashierServ.addToNQ(customer2);
        cashierServ.addToNQ(customer1);
        cashierServ.addToNQ(customer);

        //        make sales based on Priority (first set of transactions) and FIFO (second set of transaction)
        cashierServ.makeQSales();

        System.out.println(store.getProductList());
    }


}
