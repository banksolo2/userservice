package com.bankstech.userservice.controller;

import com.bankstech.userservice.form.*;
import com.bankstech.userservice.model.Role;
import com.bankstech.userservice.model.User;
import com.bankstech.userservice.service.UserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userServiceImpl.getUsers());
    }

    @GetMapping("/user/find/{username}")
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable("username") String username){
        return ResponseEntity.ok().body(userServiceImpl.getUser(username));
    }

    @PostMapping("/user/save")
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveUser(user));
    }

    @PostMapping("/role/save")
    @ResponseBody
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userServiceImpl.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }


}
