package uebung.uebungspringgemischt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import uebung.uebungspringgemischt.entity.Student;

import java.util.Optional;

public interface StudentDAO extends JpaRepository<Student, Integer> {
    Optional<Student> findByMatriculationNumber(String matriculationNumber);
}
