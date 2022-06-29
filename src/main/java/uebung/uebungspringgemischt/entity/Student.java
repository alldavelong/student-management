package uebung.uebungspringgemischt.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends Person {

    @Column(name = "matriculation_number")
    private String matriculationNumber; // PKZ

    private String password;

    @ManyToMany
    @JoinTable(
            name = "student_authority",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;

    private String startYear; // Jahrgang

    @ManyToMany
    @JoinTable(
            name = "student_semester",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "semester_id")
    )
    private List<Semester> semesters;

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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
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
