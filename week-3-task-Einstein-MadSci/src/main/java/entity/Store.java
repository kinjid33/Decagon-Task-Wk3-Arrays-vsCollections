package entity;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> productList = new ArrayList<>();
    //    getter for the product list
    public List<Product> getProductList(){
        return productList;
    }
}
