package uebung.uebungspringgemischt.entity;

import java.util.List;

public class Student extends Person {
    private String matriculationNumber; // PKZ
    private String startYear; // Jahrgang
    private List<Semester> semesters;

    public Student(int id, String firstName, String lastName, String matriculationNumber, String startYear) {
        super(id, firstName, lastName);
        this.matriculationNumber = matriculationNumber;
        this.startYear = startYear;
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

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

}
