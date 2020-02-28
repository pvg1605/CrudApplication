package com.crud_api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud_api.model.User;

public interface CRUDService<T> {

	List<T> getAll();
	
	User get(Integer id);
	
	ResponseEntity<String> create(T entity);
	
	ResponseEntity<String> update(Integer id, T entity);
	
	void delete(Integer id);
}
