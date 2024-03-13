package thietKeOOP;

class ElectronicProduct extends Product {
	private int warrantyPeriod;
	private int voltage;
	private int power;

	public ElectronicProduct(String productId, String productName, double price, int warrantyPeriod, int voltage,
			int power) {
		super(productId, productName, price);
		this.warrantyPeriod = warrantyPeriod;
		this.voltage = voltage;
		this.power = power;
	}

	// Getters for additional attributes
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public int getVoltage() {
		return voltage;
	}

	public int getPower() {
		return power;
	}
}