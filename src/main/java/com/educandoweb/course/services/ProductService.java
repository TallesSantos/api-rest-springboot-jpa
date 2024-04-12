package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repositorty;

	public List<Product> findAll() {
		return repositorty.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repositorty.findById(id);
		return obj.get();
	}

}
