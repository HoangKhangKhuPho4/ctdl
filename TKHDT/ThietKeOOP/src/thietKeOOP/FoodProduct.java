package thietKeOOP;

public class FoodProduct extends Product {
    private String expiryDate;
    private String productionDate; // Thêm thuộc tính ngày sản xuất

    public FoodProduct(String productId, String productName, double price, String productionDate, String expiryDate) {
        super(productId, productName, price);
        this.productionDate = productionDate; // Khởi tạo thuộc tính ngày sản xuất
        this.expiryDate = expiryDate;
    }

    // Getter for productionDate
    public String getProductionDate() {
        return productionDate;
    }

    // Getter for expiryDate
    public String getExpiryDate() {
        return expiryDate;
    }
}
