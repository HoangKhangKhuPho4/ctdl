package thietKeOOP;

class HouseholdProduct extends Product {
    private int warrantyPeriod;

    public HouseholdProduct(String productId, String productName, double price, int warrantyPeriod) {
        super(productId, productName, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    // Getter for warrantyPeriod
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}