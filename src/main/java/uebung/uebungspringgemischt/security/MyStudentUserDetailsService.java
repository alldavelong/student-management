package uebung.uebungspringgemischt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uebung.uebungspringgemischt.entity.Student;
import uebung.uebungspringgemischt.persistence.StudentDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyStudentUserDetailsService implements UserDetailsService {

    @Autowired
    StudentDAO studentDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return new org.springframework.security.core.userdetails.User(
                    username,
                    "{bcrypt}" + new BCryptPasswordEncoder().encode("admin"),
                    new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_ADMIN")))
                    );
        }

        Optional<Student> optionalStudent = studentDAO.findByMatriculationNumber(username);
        if (optionalStudent.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        Student student = optionalStudent.get();

        return new org.springframework.security.core.userdetails.User(
                student.getMatriculationNumber(),
                "{bcrypt}" + new BCryptPasswordEncoder().encode(student.getPassword()),
                // unsicheres Demo-Workaround für Plaintext-Passwörter !!!
                student.getAuthorities().stream().map(a -> new SimpleGrantedAuthority(a.getName())).collect(Collectors.toList())
        );
    }
}
