package com.example.praticamongo.controller;


import com.example.praticamongo.dto.UserDTO;
import com.example.praticamongo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("/findAll")
    public List<UserDTO> findAllUser(){
        return userService.findAllUser();
    }

    @PutMapping("/edit/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable String id){
        return userService.editUser(userDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
