package com.example.securitydummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class Contro {
	@Autowired
	private Repo repo;
	
	
	@GetMapping("/getByusername/{username}")
	public User getByusername(@PathVariable String username) {
	User user=	repo.findByUsername(username);
		return user;
	}
	
	
	@PostMapping("/insert")
	public String Insert(@RequestBody User user)
	{
		repo.save(user);
		return "Done";
	}
	
	

}
