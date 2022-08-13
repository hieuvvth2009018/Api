package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.Springboot1UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends JpaRepository<Springboot1UsersEntity, Integer> {
    List<Springboot1UsersEntity> findAllByName(String name);
    List<Springboot1UsersEntity> findAllByNameContainsIgnoreCase(String name);
    List<Springboot1UsersEntity> findAllByNameAndEmail(String name, String email);
    List<Springboot1UsersEntity> findAllByNameOrderByEmailAsc(String name);
}
