package com.api.apirest.repository;

import com.api.apirest.model.UserModel;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    
}
