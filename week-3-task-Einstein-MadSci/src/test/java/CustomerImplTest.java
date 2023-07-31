import entity.Customer;
import entity.Store;
import entity.Cashier;
import exceptions.ProductInStockIsLessThanOrderException;
import exceptions.ProductOutOfStockException;
import org.junit.Before;
import org.junit.Test;
import services.CashierServiceImpl;
import services.CustomerServiceImpl;
import services.StoreServiceImpl;


import static org.junit.Assert.assertEquals;

public class CustomerImplTest {
    Customer customer;
    Store store;
    Cashier cashier;
    CashierServiceImpl cashServ;
    CustomerServiceImpl custServ;
    StoreServiceImpl storeServ;
    @Before
    public void createCustomer(){
        store = new Store();
        storeServ = new StoreServiceImpl(store);
        storeServ.readProduct();
        customer = new Customer("Adetunji", store);
        cashier = new Cashier("Fadekemi", store);
        cashServ = new CashierServiceImpl(cashier);
        custServ = new CustomerServiceImpl(customer, store);
    }

    @Test
    public void testCustomerHasName(){
        assertEquals("Adetunji", customer.getUserName());
    }
    @Test
    public void testCanBuyProducts(){
        try {
            custServ.buyProducts("Electric Iron", 2);
        } catch (ProductOutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (ProductInStockIsLessThanOrderException e) {
            System.out.println(e.getMessage());
        }
        try {
            custServ.buyProducts("Fanta", 2);
        } catch (ProductOutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (ProductInStockIsLessThanOrderException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, customer.getProductListInCustomer().size());
    }
}
