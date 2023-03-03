package com.shakhawat.service;

import org.springframework.stereotype.Service;

import com.shakhawat.model.user.User;
import com.shakhawat.repository.user.UserRepository;

@Service
public final class UserServiceImpl implements DefaultService<User, Long>{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	public User save(User obj) {
		return userRepository.save(obj);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

}
