package exceptions;

public class ProductInStockIsLessThanOrderException extends Exception {
    public ProductInStockIsLessThanOrderException(){
        super("Product in stock is less than your order!");
    }
    public ProductInStockIsLessThanOrderException(String message){
        super(message);
    }
}
