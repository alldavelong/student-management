package uebung.uebungspringgemischt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudentSemester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @OneToMany(mappedBy = "studentSemester")
    private List<StudentSemesterCourse> studentSemesterCourses;

    public StudentSemester() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public List<StudentSemesterCourse> getStudentSemesterCourses() {
        return studentSemesterCourses;
    }

    public void setStudentSemesterCourses(List<StudentSemesterCourse> studentSemesterCourses) {
        this.studentSemesterCourses = studentSemesterCourses;
    }
}
