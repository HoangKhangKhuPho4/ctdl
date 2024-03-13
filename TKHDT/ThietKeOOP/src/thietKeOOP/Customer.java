package thietKeOOP;

public class Customer {
    private String customerId;
    private String customerName;
    private String birthDate;
    private int loyaltyPoints;

    public Customer(String customerId, String customerName, String birthDate, int loyaltyPoints) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.birthDate = birthDate;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getters and setters
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

}