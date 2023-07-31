package interfaces;

import exceptions.ProductInStockIsLessThanOrderException;
import exceptions.ProductOutOfStockException;

public interface CustomerInterface {
//    method to buy products
    void buyProducts(String productToBuy, int qtyToBuy)
            throws ProductOutOfStockException, ProductInStockIsLessThanOrderException;
}
