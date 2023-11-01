package lab7.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Clazz {

    private String name;
    private String year;
    private ArrayList<Student> students = new ArrayList<>();

    public Clazz(String name, String year) {
        this.name = name;
        this.year = year;
    }

    // Add a student to the class
    public void addStudent(Student student) {
        students.add(student);
    }

    // sort students according to the given comparator c
    public void sortStudents(Comparator<Student> c) {
        students.sort(c);
    }

    // get top n students with highest GPA
    public ArrayList<Student> getTopNStudents(int n) {
        return students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()))
                .limit(n)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // get random n students from the list of students
    public ArrayList<Student> getRandomNStudents(int n) {
        ArrayList<Student> shuffled = new ArrayList<>(students);
        Collections.shuffle(shuffled);
        return new ArrayList<>(shuffled.subList(0, Math.min(n, shuffled.size())));
    }

    // remove a student with a given id
    public boolean removeStudent(String id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    // get all students who were born in a given birth year.
    public ArrayList<Student> getStudentByBirthYear(int birthYear) {
        return students.stream()
                .filter(student -> student.getBirthYear() == birthYear)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Display method
    public void display() {
        System.out.println("Class Name: " + name);
        System.out.println("Year: " + year);
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}