package github.bahncard.demo.todo.security;

import lombok.AllArgsConstructor;
import github.bahncard.demo.todo.entity.User;
import github.bahncard.demo.todo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

//① load user information from the database using the UserDetailsService interface

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository; // Connects to the database

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Load user from DB
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        // Get the roles of the user and convert them to a set of GrantedAuthority objects (Set is a collection that doesn’t allow duplicates)
        // SimpleGrantedAuthority object is a way of Spring Security to represent the roles of a user
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        //Create a new User object that implements the UserDetails interface
        // public User(String username, String password, Collection<? extends GrantedAuthority> authorities)
        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                user.getPassword(),
                authorities
        );
    }
}
