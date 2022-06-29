package uebung.uebungspringgemischt.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends Person {

    private String matriculationNumber; // PKZ
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) // not supposed to be done like this (https://stackoverflow.com/questions/11746499/how-to-solve-the-failed-to-lazily-initialize-a-collection-of-role-hibernate-ex#:~:text=the%20problem%20and-,MISLEADING,-.%20To%20future%20readers)
    @JoinTable(
            name = "student_to_authority",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;
    private String className;
    @OneToMany(mappedBy = "student")
    private List<StudentSemester> studentSemesters;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<StudentSemester> getStudentSemesters() {
        return studentSemesters;
    }

    public void setStudentSemesters(List<StudentSemester> semesters) {
        this.studentSemesters = semesters;
    }

}
