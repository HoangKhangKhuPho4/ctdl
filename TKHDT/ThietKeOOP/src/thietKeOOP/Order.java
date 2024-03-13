package thietKeOOP;

import java.util.ArrayList;
import java.util.List;

class Order {
	private List<Product> products = new ArrayList<>();
	private Customer customer;
	private PaymentStrategy paymentStrategy;

	public Order(Customer customer, PaymentStrategy paymentStrategy) {
		this.customer = customer;
		this.paymentStrategy = paymentStrategy;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public double calculateTotalPrice() {
		double totalPrice = 0;
		for (Product product : products) {
			totalPrice += product.getPrice();
		}
		return paymentStrategy.calculateTotalPrice(totalPrice, customer.getLoyaltyPoints());
	}
	
	public void updateLoyaltyPoints() {
	    double totalPrice = calculateTotalPrice();
	    // Bỏ giảm giá ra khỏi tính toán giá trị để cập nhật điểm
	    if (totalPrice < 1000000) {
	        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + 5);
	    } else {
	        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + 10);
	    }
	}

	
	public void finalizeOrder() {
	    printOrderDetails(); // In chi tiết đơn hàng trước khi cập nhật điểm
	    updateLoyaltyPoints(); // Cập nhật điểm tích lũy sau khi đã in chi tiết đơn hàng
	}

	
	

	// Method to print order details 
	public void printOrderDetails() {
	    System.out.println("Mã Khách Hàng: " + customer.getCustomerId());
	    System.out.println("Tên Khách Hàng: " + customer.getCustomerName());
	    System.out.println("Điểm thưởng: " + customer.getLoyaltyPoints());
	    // Giả sử bạn có thể xác định hình thức thanh toán thông qua kiểu của paymentStrategy
	    System.out.println("Hình thức thanh toán: " + (paymentStrategy instanceof CashPaymentStrategy ? "Tiền Mặt" : "Chuyển Khoản"));
	    System.out.println("Danh sách các mặt hàng đã mua:");
	    System.out.println("STT\tMã hàng\tTên Hàng\tĐơn Giá");
	    int count = 1;
	    for (Product product : products) {
	        System.out.println(count++ + "\t" + product.getProductId() + "\t" + product.getProductName() + "\t" + product.getPrice());
	    }
	    System.out.println("Tổng tiền: " + calculateTotalPrice());
	}

}