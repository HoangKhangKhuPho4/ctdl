package thietKeOOP;

public class OrderTest {
    public static void main(String[] args) {
        Customer customer = new Customer("001", "John Doe", "1990-01-01", 10);
        Order order = new Order(customer, new CashPaymentStrategy());
        Product bread = new FoodProduct("bread001", "Bread", 50.00, "2023-01-01", null);
        Product fan = new ElectronicProduct("fan001", "Electric Fan", 1500.00, 2, 220, 50);

        order.addProduct(bread);
        order.addProduct(fan);
        double totalPrice = order.calculateTotalPrice();
        
        // Kiểm tra tổng giá trị sau khi giảm giá
        if (Math.abs(totalPrice - 1395.0) < 0.001) { // 10% off of 1550 is 1395
            System.out.println("Test calculate total price with cash payment: PASSED");
        } else {
            System.out.println("Test calculate total price with cash payment: FAILED");
        }
        
        // Kiểm tra cập nhật điểm tích lũy
        order.updateLoyaltyPoints();
        if (customer.getLoyaltyPoints() == 15) { // Giả sử ban đầu khách hàng có 10 điểm
            System.out.println("Test loyalty points update for orders less than one million: PASSED");
        } else {
            System.out.println("Test loyalty points update for orders less than one million: FAILED");
        }
    }
}
