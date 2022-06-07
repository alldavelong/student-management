package uebung.uebungspringgemischt.entity;

import java.util.List;
import java.util.Set;

public class Student extends Person {
    private String matriculationNumber; // PKZ
    private String password;
    private Set<String> authorities;
    private String startYear; // Jahrgang
    private List<Semester> semesters;

    public Student(int id, String firstName, String lastName, String matriculationNumber,
                   String password, Set<String> authorities, String startYear) {
        super(id, firstName, lastName);
        this.matriculationNumber = matriculationNumber;
        this.password = password;
        this.authorities = authorities;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
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
