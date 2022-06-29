package uebung.uebungspringgemischt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import uebung.uebungspringgemischt.entity.StudentSemesterCourse;

public interface StudentSemesterCourseDAO extends JpaRepository<StudentSemesterCourse, Integer> {
}
