package com.estudos.projectwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.projectwebservice.entities.Product;
import com.estudos.projectwebservice.repositories.ProductRepository;
import com.estudos.projectwebservice.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> optional = repository.findById(id);
		return optional.orElseThrow(() -> new ResourceNotFoundException(id));		
	}
}
