package uebung.uebungspringgemischt.entity;

import java.util.Set;

public class Student extends Person {
    private String matriculationNumber; // PKZ
    private String year; // Jahrgang
    private Set<Course> courses;

    public Student(int id, String firstName, String lastName, String matriculationNumber, String year, Set<Course> courses) {
        super(id, firstName, lastName);
        this.matriculationNumber = matriculationNumber;
        this.year = year;
        this.courses = courses;
    }

    public Student() {
        super();
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
