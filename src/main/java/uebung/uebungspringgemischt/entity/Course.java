package uebung.uebungspringgemischt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
    @OneToMany(mappedBy = "course")
    private List<StudentSemesterCourse> studentSemesterCourses;

    public Course() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<StudentSemesterCourse> getStudentSemesterCourses() {
        return studentSemesterCourses;
    }

    public void setStudentSemesterCourses(List<StudentSemesterCourse> studentSemesterCourses) {
        this.studentSemesterCourses = studentSemesterCourses;
    }
}
