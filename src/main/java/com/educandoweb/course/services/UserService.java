package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repositorty;

	public List<User> findAll() {
		return repositorty.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repositorty.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repositorty.save(obj);
	}

	public void delete(Long obj) {
		repositorty.deleteById(obj);
	}

	public User update(Long id, User obj) {
		User entity = repositorty.getReferenceById(id);
		updateData(entity, obj);
		return repositorty.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
