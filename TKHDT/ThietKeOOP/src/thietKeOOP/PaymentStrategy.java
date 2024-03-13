package thietKeOOP;

interface PaymentStrategy {
    double calculateTotalPrice(double totalPrice, int loyaltyPoints);

}

class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateTotalPrice(double totalPrice, int loyaltyPoints) {
        // Chỉ giảm 10% tổng thành tiền khi thanh toán bằng tiền mặt
        return totalPrice * 0.9;
    }
}

class BankTransferPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateTotalPrice(double totalPrice, int loyaltyPoints) {
        // Chỉ giảm 5% tổng thành tiền khi thanh toán bằng chuyển khoản
        return totalPrice * 0.95;
    }
}

