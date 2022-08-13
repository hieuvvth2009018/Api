package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Springboot1UsersEntity;
import com.example.apiwcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(Springboot1UsersEntity u) {
        userRepository.save(u);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Springboot1UsersEntity findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<Springboot1UsersEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Springboot1UsersEntity> findAllByName(String name) {
        return userRepository.findAllByNameContainsIgnoreCase(name);
    }
}
