package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.Springboot1UsersEntity;
import com.example.apiwcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<List<Springboot1UsersEntity>> findAllUser() {
        List<Springboot1UsersEntity> lsUser = userService.findAll();
        if(lsUser.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Springboot1UsersEntity>>(lsUser, HttpStatus.OK);
    }






    //userbyname?name=oanh
    @RequestMapping(value = "userbyname", method = RequestMethod.GET)
    public ResponseEntity<List<Springboot1UsersEntity>> findAllUser(@PathParam("name") String name) {
        List<Springboot1UsersEntity> lsUser = userService.findAllByName(name);
        if(lsUser.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Springboot1UsersEntity>>(lsUser, HttpStatus.OK);
    }










    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public ResponseEntity<Springboot1UsersEntity> saveNewUser(@RequestBody Springboot1UsersEntity u) {
        userService.saveUser(u);
        return new ResponseEntity<Springboot1UsersEntity>(u, HttpStatus.OK);
    }

    //http://localhost:8080/updateUser?id=1
    @RequestMapping(value = "updateUser", method = RequestMethod.PUT)
    public ResponseEntity<Springboot1UsersEntity> updateUser(
            @PathParam("id") Integer id,
            @RequestBody Springboot1UsersEntity u) {
        Springboot1UsersEntity oldUser = userService.findById(id);
        oldUser.setEmail(u.getEmail());
        oldUser.setName(u.getName());
        oldUser.setPhone(u.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<Springboot1UsersEntity>(oldUser, HttpStatus.OK);
    }

    @RequestMapping(value = "updateUser2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Springboot1UsersEntity> updateUser2(
            @PathVariable(value = "id") Integer id,
            @RequestBody Springboot1UsersEntity u) {
        Springboot1UsersEntity oldUser = userService.findById(id);
        oldUser.setEmail(u.getEmail());
        oldUser.setName(u.getName());
        oldUser.setPhone(u.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<Springboot1UsersEntity>(oldUser, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteuser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Springboot1UsersEntity> deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
