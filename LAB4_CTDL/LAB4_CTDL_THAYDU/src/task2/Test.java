package task2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
    	Product p4 = new Product("01", "D", 10.0, "Other");
		Product p2 = new Product("02", "B", 20.0, "Ruler");
		Product p1 = new Product("03", "A", 100.0, "Pen");
		Product p3 = new Product("04", "C", 50.0, "Book");
		Product p5 = new Product("05", "G", 300.0, "notebook");
		Product p6 = new Product("06", "D", 20.0, "pencil sharpener");
		Product p7 = new Product("07", "F", 70.0, "eraser");
		Product p8 = new Product("08", "T", 80.0, "Book");
		
		OrderItem o1 = new OrderItem(p1, 10);
		OrderItem o2 = new OrderItem(p2, 9);
		OrderItem o3 = new OrderItem(p3, 8);
		OrderItem o4 = new OrderItem(p4, 7);
		OrderItem o5 = new OrderItem(p6, 7);
		OrderItem o6 = new OrderItem(p5, 7);
		OrderItem o7 = new OrderItem(p7, 7);
		
		OrderItem[] listItems = new OrderItem[] {o7,o2,o4,o5,o1,o6,o3}	;
		
		Order order = new Order(listItems);
		
		
		System.out.print("Test Cost: ");
		System.out.println(order.cost());
		
		System.out.print("Test Contain: ");
		System.out.println(order.contains(p8));
		
		
		System.out.println("Test Filter");
		System.out.println(Arrays.toString(order.filter("Book")));
		
		
	}

	}

