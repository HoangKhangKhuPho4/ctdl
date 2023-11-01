package lab7.set_student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

public class MainTest {
	public static void main(String[] args) {
		// Testing MyPredicates methods
		System.out.println("\nTesting MyPredicates methods");

		Collection<String> testCollection = new ArrayList<>(Arrays.asList("test", "remove", "predicate", "example"));
		Predicate<String> lengthPredicate = s -> s.length() > 5;

		// Test remove
		MyPredicates.remove(testCollection, lengthPredicate);
		System.out.println("After remove: " + testCollection); // Should not contain "remove" and "predicate"

		// Test retain
		testCollection = new ArrayList<>(Arrays.asList("test", "remove", "predicate", "example"));
		MyPredicates.retain(testCollection, lengthPredicate);
		System.out.println("After retain: " + testCollection); // Should only contain "remove" and "predicate"

		// Test collect
		testCollection = new ArrayList<>(Arrays.asList("test", "remove", "predicate", "example"));
		Set<String> collectedSet = MyPredicates.collect(testCollection, lengthPredicate);
		System.out.println("After collect: " + collectedSet); // Should only contain "remove" and "predicate"

		// Test find
		testCollection = new ArrayList<>(Arrays.asList("test", "remove", "predicate", "example"));
		int index = MyPredicates.find(testCollection, lengthPredicate);
		System.out.println("Index found: " + index); // Should be 1 for "remove
          
		
		
	}
}
