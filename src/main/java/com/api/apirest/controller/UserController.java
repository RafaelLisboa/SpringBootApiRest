package com.api.apirest.controller;

import com.api.apirest.model.UserModel;
import com.api.apirest.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping(path = "/api/user/{id}" )
    public ResponseEntity consult (@PathVariable("id") Integer id) {
        return (ResponseEntity) repository.findById(id)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/user/save")
    public UserModel save (@RequestBody UserModel user) {
        return (UserModel) repository.save(user);
    }
}
