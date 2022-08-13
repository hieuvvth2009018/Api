package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Springboot1UsersEntity;

import java.util.List;

public interface UserService {
    public void saveUser(Springboot1UsersEntity u);
    public void deleteUser(Integer id);
    public Springboot1UsersEntity findById(Integer id);
    public List<Springboot1UsersEntity> findAll();

    public List<Springboot1UsersEntity> findAllByName(String name);
}
