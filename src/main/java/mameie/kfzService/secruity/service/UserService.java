package mameie.kfzService.secruity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    //Gibt den User für UserDetails zurück
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Password muss mit BCrypt gehasht in der Tabelle abgespeichert werden
        return new User("Markus","$2y$10$rBYhh/2nryL9rqITpvcwx.cCeo25w5mO6/e9X8XsU8dBRcRpp5pxG", new ArrayList<>());
    }
}
