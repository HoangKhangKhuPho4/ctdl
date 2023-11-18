package task1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {

		// Khởi tạo các đối tượng Student
		Student s1 = new Student("SV001", "Nguyen Van An", 2019);
		Student s2 = new Student("SV002", "Tran Thi Binh", 2020);
		Student s3 = new Student("SV003", "Le Van Cuong", 2019);
		Student s4 = new Student("SV004", "Pham Thi Dung", 2021);

		// Khởi tạo các đối tượng Course
		Course c1 = new Course("CO001", "Lập trình hướng đối tượng", "theory", Arrays.asList(s1, s2), "GV001");
		Course c2 = new Course("CO002", "Cơ sở dữ liệu", "practice", Arrays.asList(s1, s3, s4), "GV002");
		Course c3 = new Course("CO003", "Mạng máy tính", "theory", Arrays.asList(s2, s4), "GV001");

		// Khởi tạo đối tượng Faculty
		List<Course> courses = Arrays.asList(c1, c2, c3);
		Faculty fac = new Faculty("CNTT", "Ha Noi", courses);

		// Kiểm tra phương thức getMaxPracticalCourse
		Course maxCourse = fac.getMaxPracticalCourse();
		System.out.println("Học phần thực hành đông SV nhất: " + maxCourse);

		// Kiểm tra phương thức groupStudentsByYear
		Map<Integer, List<Student>> result = fac.groupStudentsByYear();
		System.out.println("Thống kê SV theo năm: " + result);

		// Kiểm tra phương thức filterCourses
		Set<Course> theoryCourses = fac.filterCourses("theory");
		System.out.println("Các học phần lý thuyết: " + theoryCourses);

	}
}
