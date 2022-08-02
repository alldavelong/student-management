package uebung.uebungspringgemischt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String season; // SS (Sommersemester) / WS (Wintersemester)
    private int startYear;
    @OneToMany(mappedBy = "semester")
    private List<StudentSemester> students;

    public Semester() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public List<StudentSemester> getStudents() {
        return students;
    }

    public void setStudents(List<StudentSemester> students) {
        this.students = students;
    }

    @JsonIgnore
    public String getName() {
        return this.season + this.startYear;
    }
}
