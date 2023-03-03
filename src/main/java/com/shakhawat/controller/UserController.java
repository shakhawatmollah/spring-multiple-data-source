package com.shakhawat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakhawat.model.user.User;
import com.shakhawat.service.DefaultService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final DefaultService<User,Long> defaultService;

    public UserController(DefaultService<User, Long> defaultService) {
        this.defaultService = defaultService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return defaultService.save(user);
    }
    
    @GetMapping("/find-user/{id}")
    public User getUser(@PathVariable Long id) {
      //  return defaultService.findById(id);\
    	
    	Iterable<User> users = defaultService.findAll();
    	
    	List<User> list = Streamable.of(users).toList();
    	
    	Optional<User> rs = list.stream().filter(a -> a.getId()==id).findFirst();
    	User u = rs.orElse(null);
    	
    	return u;
    }
    
}
