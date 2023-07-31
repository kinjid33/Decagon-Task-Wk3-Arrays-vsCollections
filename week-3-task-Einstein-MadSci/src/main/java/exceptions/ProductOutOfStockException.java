package exceptions;

public class ProductOutOfStockException extends Exception {
    public ProductOutOfStockException(){
        super("PRODUCT IS OUT OF STOCK!!");
    }
    public ProductOutOfStockException(String message){
        super(message);
    }
}
