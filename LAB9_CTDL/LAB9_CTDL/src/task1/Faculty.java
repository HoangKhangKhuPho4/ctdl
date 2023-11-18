package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	// Trong lớp Faculty

	public Course getMaxPracticalCourse() {
		int maxStudents = 0;
		Course maxCourse = null;

		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			if (course.getType().equals("practice")) {
				int numStudents = course.getStudents().size();
				if (numStudents > maxStudents) {
					maxStudents = numStudents;
					maxCourse = course;
				}
			}
		}

		return maxCourse;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {

		Map<Integer, List<Student>> result = new HashMap<>();

		for (Course course : courses) {
			List<Student> students = course.getStudents();

			for (Student student : students) {
				int year = student.getYear();

				if (!result.containsKey(year)) {
					result.put(year, new ArrayList<>());
				}

				result.get(year).add(student);
			}
		}

		return result;
	}

	public Set<Course> filterCourses(String type) {

		Set<Course> result = new TreeSet<>((c1, c2) -> {
			int s1 = c1.getStudents().size();
			int s2 = c2.getStudents().size();
			return Integer.compare(s2, s1);
		});

		for (Course course : courses) {
			if (course.getType().equals(type)) {
				result.add(course);
			}
		}

		return result;

	}

	@Override
	public String toString() {
		return name + " - " + address;
	}

}
