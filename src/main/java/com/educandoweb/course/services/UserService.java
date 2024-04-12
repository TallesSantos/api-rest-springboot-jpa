package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repositorty;

	public List<User> findAll() {
		return repositorty.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repositorty.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return repositorty.save(obj);
	}

	public void delete(Long obj) {
		repositorty.deleteById(obj);
	}

}
