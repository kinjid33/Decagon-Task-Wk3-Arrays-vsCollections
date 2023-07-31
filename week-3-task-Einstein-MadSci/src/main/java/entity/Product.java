package entity;

public class Product {
    private String inventoryId;
    private String name;
    private String description;
    private int unitPrice;
    private int qtyInStock;
    private int inventoryValue;

    public Product(String inventoryId, String name, String description, int unitPrice, int qtyInStock, int inventoryValue) {
        this.inventoryId = inventoryId;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyInStock = qtyInStock;
        this.inventoryValue = inventoryValue;
    }

    public Product(String name, int qtyInStock) {
        this.name = name;
        this.qtyInStock = qtyInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyInStock=" + qtyInStock +
                '}';
    }




//    public String getInventoryId() {
//        return inventoryId;
//    }

//    public void setInventoryId(String inventoryId) {
//        this.inventoryId = inventoryId;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getDescription() {
//        return description;
//    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public int getUnitPrice() {
        return unitPrice;
    }

//    public void setUnitPrice(int unitPrice) {
//        this.unitPrice = unitPrice;
//    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock -= qtyInStock;
    }
//
//    public int getInventoryValue() {
//        return inventoryValue;
//    }
//
//    public void setInventoryValue(int inventoryValue) {
//        this.inventoryValue = inventoryValue;
//    }
}