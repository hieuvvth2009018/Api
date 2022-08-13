package com.example.apiwcrud.controller;
import com.example.apiwcrud.model.ClassEntity;
import com.example.apiwcrud.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

    @RestController
    public class ClassCotroller {
        @Autowired
        ClassService classService;

        @RequestMapping(value = "Class", method = RequestMethod.GET)
        public ResponseEntity<List<ClassEntity>> findAllUser() {
            List<ClassEntity> lsUser = classService.findAll();
            if(lsUser.size() == 0) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<ClassEntity>>(lsUser, HttpStatus.OK);
        }






        //userbyname?name=
        @RequestMapping(value = "name", method = RequestMethod.GET)
        public ResponseEntity<List<ClassEntity>> findAllUser(@PathParam("name") String name) {
            List<ClassEntity> lsUser = classService.findAllByName(name);
            if(lsUser.size() == 0) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<ClassEntity>>(lsUser, HttpStatus.OK);
        }










        @RequestMapping(value = "saveuser", method = RequestMethod.POST)
        public ResponseEntity<ClassEntity> saveNewUser(@RequestBody ClassEntity u) {
            classService.saveUser(u);
            return new ResponseEntity<ClassEntity>(u, HttpStatus.OK);
        }

        //http://localhost:8080/updateUser?id=1
        @RequestMapping(value = "updateUser", method = RequestMethod.PUT)
        public ResponseEntity<ClassEntity> updateUser(
                @PathParam("id") Integer id,
                @RequestBody ClassEntity u) {
            ClassEntity oldUser = classService.findById(id);
            oldUser.setEmail(u.getEmail());
            oldUser.setName(u.getName());
            oldUser.setPhone(u.getPhone());
            classService.saveUser(oldUser);
            return new ResponseEntity<ClassEntity>(oldUser, HttpStatus.OK);
        }

        @RequestMapping(value = "updateUser2/{id}", method = RequestMethod.PUT)
        public ResponseEntity<ClassEntity> updateUser2(
                @PathVariable(value = "id") Integer id,
                @RequestBody ClassEntity u) {
            ClassEntity oldUser = classService.findById(id);
            oldUser.setEmail(u.getEmail());
            oldUser.setName(u.getName());
            oldUser.setPhone(u.getPhone());
            classService.saveUser(oldUser);
            return new ResponseEntity<ClassEntity>(oldUser, HttpStatus.OK);
        }

        @RequestMapping(value = "deleteuser/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<ClassEntity> deleteUser(@PathVariable(value = "id") Integer id) {
            classService.deleteUser(id);
            return ResponseEntity.ok().build();
        }
    }

}
