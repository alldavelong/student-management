package uebung.uebungspringgemischt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudentSemesterCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_semester_id")
    private StudentSemester studentSemester;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "studentSemesterCourse")
    private List<Grade> grades;

    public StudentSemesterCourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentSemester getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(StudentSemester studentSemester) {
        this.studentSemester = studentSemester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
    public boolean hasGrade() {
        return !this.grades.isEmpty();
    }
}
