package services;

import entity.Customer;
import entity.Product;
import entity.Store;
import exceptions.ProductInStockIsLessThanOrderException;
import exceptions.ProductOutOfStockException;
import interfaces.CustomerInterface;

public class CustomerServiceImpl implements CustomerInterface {
    private Customer customer;
    private Store store;
    public CustomerServiceImpl(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    @Override
    public void buyProducts(String productToBuy, int qtyToBuy) throws ProductOutOfStockException, ProductInStockIsLessThanOrderException {
//        Logic for buying products
//        Iterate through product list gotten from store class
        for(Product a: store.getProductList()){
//            If product name is found in product list gotten from store class
            if(a.getName().equals(productToBuy)) {
//                check if product is in stock
                if (a.getQtyInStock() < 1) {
                    throw new ProductOutOfStockException(a.getName().toUpperCase() + " IS OUT OF STOCK"); //product is out of stock
                }
//                check if quantity to buy is greater than quantity in stock
                else if (qtyToBuy > a.getQtyInStock()) {
                    throw new ProductInStockIsLessThanOrderException("Sorry only " + a.getQtyInStock() + " available"); //quantity to buy is more than quantity in stock
                } else{
                    System.out.println(productToBuy+" successfully added to cart."); //all checks passed
//                    Adds product customer wants to buy to product list
                    customer.getProductListInCustomer().add(new Product(a.getName(), qtyToBuy));
//                    sets quantity to buy to the given value (passed as argument)
//                    customer.setQuantityToBuy(qtyToBuy);
                }
            }
        }
    }
}
