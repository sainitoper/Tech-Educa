package com.example.securitydummy;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SecuritydummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritydummyApplication.class, args);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	        		.requestMatchers(HttpMethod.POST, "/users/insert").permitAll()

	            .requestMatchers("/users/getByusername/**").authenticated()
	            .anyRequest().denyAll() 
	        )
	        .httpBasic(withDefaults())
	        .formLogin(withDefaults());
            
	    return http.build();
	    
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}

}
