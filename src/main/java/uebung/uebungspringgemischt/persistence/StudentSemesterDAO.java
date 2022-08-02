package uebung.uebungspringgemischt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uebung.uebungspringgemischt.entity.Student;
import uebung.uebungspringgemischt.entity.StudentSemester;

import java.util.Optional;

public interface StudentSemesterDAO extends JpaRepository<StudentSemester, Integer> {
    @Query("SELECT stuSem from StudentSemester stuSem WHERE stuSem.student = :student AND stuSem.semester.season = :semesterSeason AND stuSem.semester.startYear = :semesterStartYear")
    Optional<StudentSemester> findByStudentAndSemester(Student student, String semesterSeason, int semesterStartYear);
}
