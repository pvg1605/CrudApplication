package com.crud_api.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud_api.model.User;
import com.crud_api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		Iterable<User> iterable = userRepository.findAll();
		List<User> users = new ArrayList<>();
		iterable.forEach(e -> users.add(e));

		return users;
	}

	@Override
	public User get(Integer id) throws ResourceNotFoundException {
		User user = userRepository.findOne(id);
		if (user != null) { 
		return user;
		} else {
			throw new ResourceNotFoundException("id="+id, null);
		}
	}

	@Override
	public ResponseEntity<String> create(User user) {
		userRepository.save(user);
		return ResponseEntity.ok("User data is valid");
	}

	@Override
	public ResponseEntity<String> update(Integer id, User user) {
		userRepository.save(user);
		return ResponseEntity.ok("Successfull");
	}

	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
	}

}
