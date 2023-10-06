package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		this.items = items;
		Arrays.sort(this.items, Comparator.comparing(o -> o.getProduct().getId()));
	}

	public double cost() {
		double totalCost = 0.0;
		for (OrderItem item : items) {
			totalCost += item.getProduct().getPrice() * item.getQuantity();
		}
		return totalCost;
	}

	public boolean contains(Product p) {
		int left = 0, right = items.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (items[mid].getProduct().getId().equals(p.getId())) {
				return true;
			} else if (items[mid].getProduct().getId().compareTo(p.getId()) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	public Product[] filter(String type) {
		List<Product> filteredProducts = new ArrayList<>();
		for (OrderItem item : items) {
			if (item.getProduct().getType().equals(type)) {
				filteredProducts.add(item.getProduct());
			}
		}
		return filteredProducts.toArray(new Product[0]);
	}

	public static void main(String[] args) {
		Product p1 = new Product("1", "Apple", 0.5, "Fruit");
		Product p2 = new Product("2", "Banana", 0.2, "Fruit");
		Product p3 = new Product("3", "Carrot", 0.3, "Vegetable");

		OrderItem item1 = new OrderItem(p1, 10);
		OrderItem item2 = new OrderItem(p2, 5);
		OrderItem item3 = new OrderItem(p3, 7);

		Order order = new Order(new OrderItem[] { item1, item2, item3 });

		System.out.println("Total cost: " + order.cost());
		System.out.println("Order contains Apple: " + order.contains(p1));
		System.out.println("Fruit products: " + Arrays.toString(order.filter("Fruit")));
	}
}
