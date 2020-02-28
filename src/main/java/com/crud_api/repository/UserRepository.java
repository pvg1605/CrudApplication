package com.crud_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud_api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

		
}
