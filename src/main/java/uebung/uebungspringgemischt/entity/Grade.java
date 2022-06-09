package uebung.uebungspringgemischt.entity;

import uebung.uebungspringgemischt.controller.GradeOutOfRangeException;

public class Grade {
    private int grade;
    public static final int LOWEST_GRADE = 1;
    public static final int HIGHEST_GRADE = 5;

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
}
