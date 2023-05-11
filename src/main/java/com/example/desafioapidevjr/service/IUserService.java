package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.dto.UserDTO;
import com.example.desafioapidevjr.entities.Usuario;

import java.util.Optional;

public interface IUserService {
     String createUser(UserDTO request) throws Exception;
     Optional<Usuario> findUserById(int id) throws Exception;
}
