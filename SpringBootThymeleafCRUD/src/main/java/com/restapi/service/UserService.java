package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.User;
import com.restapi.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public List<User> findAllUser() {
		return (List<User>) userRepository.findAll();

	}

	public User getUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		return user;
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
