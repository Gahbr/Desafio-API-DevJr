package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.Exception.UserAlreadyExistsException;
import com.example.desafioapidevjr.dto.UserDTO;
import com.example.desafioapidevjr.entities.Usuario;

import java.util.Optional;

public interface IUserService {
     String createUser(UserDTO request) throws UserAlreadyExistsException;
     Optional<Usuario> findUserById(int id);
}
