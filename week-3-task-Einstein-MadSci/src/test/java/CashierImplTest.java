import entity.Cashier;
import entity.Customer;
import entity.Store;
import exceptions.ProductInStockIsLessThanOrderException;
import exceptions.ProductOutOfStockException;
import org.junit.Before;
import org.junit.Test;
import services.CashierServiceImpl;
import services.CustomerServiceImpl;
import services.StoreServiceImpl;

import java.util.PriorityQueue;

import static org.junit.Assert.assertTrue;

public class CashierImplTest {
    Cashier cashier;
    Store store;
    Customer customer;
    CashierServiceImpl cashServ;
    CustomerServiceImpl custServ;
    StoreServiceImpl storeServ;
    PriorityQueue<Customer> customerPQ;
    @Before
    public void createCashier(){
        store = new Store();
        storeServ = new StoreServiceImpl(store);
        storeServ.readProduct();
        cashier = new Cashier("Adebayo", store);
        customer = new Customer("Bamidele", store);
        cashServ = new CashierServiceImpl(cashier);
        cashServ.setStore(store);
        custServ = new CustomerServiceImpl(customer, store);

    }
    @Test
    public void testCashierCanMakeSales(){
        try {
            custServ.buyProducts("Sprite", 2);
        } catch (ProductOutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (ProductInStockIsLessThanOrderException e) {
            System.out.println(e.getMessage());
        }
        cashServ.makeSale(customer);
        assertTrue(cashier.isCheckOut());
    }
    @Test
    public void canAddToPriorityQueue(){
        cashServ.addToPriorityQ(customer);
        assertTrue(cashServ.getCustomerPQueue().poll().equals(customer));
    }
    @Test
    public void canAddToFIFOQueue(){
        cashServ.addToNQ(customer);
        assertTrue(cashServ.getCustomerNQueue().poll().equals(customer));
    }
}