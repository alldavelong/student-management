package uebung.uebungspringgemischt.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import uebung.uebungspringgemischt.entity.Student;

import java.io.File;
import java.io.IOException;
import java.util.Set;

@Service
public class StudentJsonDataService {
    private final File STUDENTS_FILE = new File("students.json");

    public void saveStudents(Set<Student> students) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(STUDENTS_FILE, students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Student> getStudents() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(STUDENTS_FILE, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentByMatriculationNumber(String matriculationNumber) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Set<Student> students = objectMapper.readValue(STUDENTS_FILE, new TypeReference<>() {});
            return students.stream().filter(s -> s.getMatriculationNumber().equals(matriculationNumber)).findFirst().get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
