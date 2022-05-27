package uebung.uebungspringgemischt.persistence;

import org.springframework.stereotype.Service;
import uebung.uebungspringgemischt.entity.Course;
import uebung.uebungspringgemischt.entity.Grade;
import uebung.uebungspringgemischt.entity.Lecturer;
import uebung.uebungspringgemischt.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class MockData {
    private Set<Student> students;

    {
        Lecturer lecturer1 = new Lecturer(1, "Lektorvn", "Lektornn");

        Course course1 = new Course(1, "Programmieren", 1, lecturer1, new ArrayList<>(Arrays.asList(
                new Grade(2)
        )));
        Course course2 = new Course(2, "Mathe", 2, lecturer1, new ArrayList<>());
        Course course3 = new Course(3, "Mathe", 2, lecturer1, new ArrayList<>());

        Student student1 = new Student(
                1, "Hans", "Huber", "2010aaaaaa", "WEBvz20",
                new HashSet<>(Arrays.asList(course1, course2))
        );
        Student student2 = new Student(
                2, "Maria", "Müller", "2010bbbbbb", "WEBvz20",
                new HashSet<>(Arrays.asList(course3))
        );
        students = new HashSet<>(Arrays.asList(student1, student2));
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
