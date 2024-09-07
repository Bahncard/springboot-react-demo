package github.bahncard.demo.todo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Test the PasswordEncoder with BCryptPasswordEncoder
public class PasswordEncoderImpl {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("ramesh"));

        System.out.println(passwordEncoder.encode("admin"));
    }
}
