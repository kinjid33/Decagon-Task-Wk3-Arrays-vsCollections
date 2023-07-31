import entity.Product;
import entity.Store;
import org.junit.Before;
import org.junit.Test;
import services.StoreServiceImpl;

import static org.junit.Assert.assertTrue;

public class ProductTest {
    Product product;
    Store store;
    StoreServiceImpl storeServ;
    @Before
    public void createProduct(){
        store = new Store();
        storeServ = new StoreServiceImpl(store);
        storeServ.readProduct();
    }
    @Test
    public void canReadProduct(){
        assertTrue(store.getProductList().size() > 1);
    }
}
