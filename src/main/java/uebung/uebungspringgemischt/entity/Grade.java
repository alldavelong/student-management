package uebung.uebungspringgemischt.entity;

public class Grade {
    private int grade;

    public Grade(int grade) {
        this.grade = grade;
    }

    public Grade() {}

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + grade +
                '}';
    } // TODO
}
