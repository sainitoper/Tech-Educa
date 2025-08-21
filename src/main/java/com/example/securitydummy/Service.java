package com.example.securitydummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class Service implements UserDetailsService{
	  @Autowired
	    private Repo userRepository;

	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);
	        if (user != null) {
	            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
	                .username(user.getUsername())
	                .password(user.getPassword())
	             
	                .build();

	            return userDetails;
	        }

	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }

	
}

