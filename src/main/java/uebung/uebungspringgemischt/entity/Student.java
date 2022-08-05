package uebung.uebungspringgemischt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends Person {

    private String matriculationNumber; // PKZ
    private String className;
    @OneToMany(mappedBy = "student")
    private List<StudentSemester> studentSemesters;
    @OneToOne(mappedBy = "student")
    private User user;

    public Student() {
        super();
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
