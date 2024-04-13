package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
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

	public void delete(Long id){
	    try {
	        if(!repositorty.existsById(id)) throw new ResourceNotFoundException(id);
	        repositorty.deleteById(id);
	    }catch (ResourceNotFoundException e){
	        throw new ResourceNotFoundException(id);
	    }
	    catch (DataIntegrityViolationException e){
	        throw new DatabaseException(e.getMessage());
	    }
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
