package uebung.uebungspringgemischt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import uebung.uebungspringgemischt.entity.StudentSemester;

public interface StudentSemesterDAO extends JpaRepository<StudentSemester, Integer> {
}
