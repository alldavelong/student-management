package uebung.uebungspringgemischt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uebung.uebungspringgemischt.entity.Student;
import uebung.uebungspringgemischt.persistence.StudentJsonDataService;

import java.util.stream.Collectors;

@Service
public class MyStudentUserDetailsService implements UserDetailsService {

    @Autowired
    StudentJsonDataService studentJsonDataService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student user = studentJsonDataService.getStudentByMatriculationNumber(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getMatriculationNumber(),
                "{bcrypt}" + new BCryptPasswordEncoder().encode(user.getPassword()),
                // unsicheres Demo-Workaround für Plaintext-Passwörter !!!
                user.getAuthorities().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );
    }
}
