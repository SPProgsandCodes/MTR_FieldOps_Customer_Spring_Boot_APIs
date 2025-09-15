package in.sptech.mtr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
// strength 10 is default; increase for stronger hashes (higher CPU)
        return new BCryptPasswordEncoder();
    }
}
