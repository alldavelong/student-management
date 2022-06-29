package uebung.uebungspringgemischt.entity;

import uebung.uebungspringgemischt.controller.GradeOutOfRangeException;

import javax.persistence.*;

@Entity
public class Grade {
    public static final int LOWEST_GRADE = 1;
    public static final int HIGHEST_GRADE = 5;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grade;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Grade(int grade) throws GradeOutOfRangeException {
        setGrade(grade);
    }

    public Grade() {}

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws GradeOutOfRangeException {
        if (grade < LOWEST_GRADE || grade > HIGHEST_GRADE) {
            throw new GradeOutOfRangeException();
        }
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
