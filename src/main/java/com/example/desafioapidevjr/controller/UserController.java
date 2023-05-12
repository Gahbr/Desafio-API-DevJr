package com.example.desafioapidevjr.controller;

import com.example.desafioapidevjr.dto.UserDTO;
import com.example.desafioapidevjr.entities.Usuario;
import com.example.desafioapidevjr.service.IUserService;
import com.example.desafioapidevjr.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
        try {
            var response = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> fetchUserById(@PathVariable int id) {
        try {
            var response = userService.findUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
