package lab7.arraylist;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try {
			ArrayList<Student> students = StudentUtils.loadStudents("students.txt");
			Clazz clazz = new Clazz("Mathematics", "2023");

			for (Student student : students) {
				clazz.addStudent(student);
			}

			// Example usage of the Clazz methods
			clazz.display();
			ArrayList<Student> topStudents = clazz.getTopNStudents(5);
			System.out.println("Top 5 Students:");
			for (Student student : topStudents) {
				System.out.println(student);
			}

			// Random students example
			ArrayList<Student> randomStudents = clazz.getRandomNStudents(3);
			System.out.println("Random 3 Students:");
			for (Student student : randomStudents) {
				System.out.println(student);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
