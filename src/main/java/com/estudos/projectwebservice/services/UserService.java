package com.estudos.projectwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudos.projectwebservice.entities.User;
import com.estudos.projectwebservice.repositories.UserRepository;
import com.estudos.projectwebservice.services.exceptions.DatabaseException;
import com.estudos.projectwebservice.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> optional = repository.findById(id);
		return optional.orElseThrow(() -> new ResourceNotFoundException(id));		
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			//apagar um usuário que tem pedidos associados
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		// ainda não passa no banco de dados, prepara/monitora o objeto
		//antes era getOne
		User entity = repository.getReferenceById(id); 
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		// atualiza entity com base no que veio no obj
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}	
}
