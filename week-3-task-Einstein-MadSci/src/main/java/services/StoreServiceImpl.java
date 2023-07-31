package services;

import entity.Product;
import entity.Store;
import interfaces.StoreInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreServiceImpl {
//    private Product product;
    private Store store;
//    static List<Product> many = new ArrayList<>();

    public StoreServiceImpl(Store store) {
        this.store = store;
    }

//    @Override
    public void readProduct() {
        String csvFilePath = "src/main/resources/Convenience-Store-Inventory-List (1).csv";
        {
            try {
                String line = "";
//                reads product data from csv file
                BufferedReader reader = new BufferedReader((new FileReader(csvFilePath)));
                while ((line = reader.readLine()) != null) {
//                    splits read data into a String array
                    String[] lines = line.split(",");
//                    creates and initialises a product object with the columns in the csv file Inventory number, product name, product description, product price, qty of product in stock, total value of product in stock
                    Product product = new Product(lines[0], lines[1], lines[2], Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), Integer.parseInt(lines[5]));
//                    adds product object to product array list
//                    many.add(product);
                        store.getProductList().add(product);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    public static void main(String[] args) {
//        readProduct();
//        for(Product a : many){
//            System.out.println(a.toString());
//        }
//    }
}
