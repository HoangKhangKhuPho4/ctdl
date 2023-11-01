package lab7.arraylist;

public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private double GPA;

    public Student(String id, String firstName, String lastName, int birthYear, double GPA) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.GPA = GPA;
    }

    // Getters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getBirthYear() { return birthYear; }
    public double getGPA() { return GPA; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
    public void setGPA(double GPA) { this.GPA = GPA; }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", GPA=" + GPA +
                '}';
    }
}