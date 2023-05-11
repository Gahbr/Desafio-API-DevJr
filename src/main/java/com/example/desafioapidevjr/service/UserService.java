package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.dto.UserDTO;
import com.example.desafioapidevjr.entities.Usuario;
import com.example.desafioapidevjr.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(UserDTO request) throws Exception {
        Optional<Usuario> optUser = userRepository.findByCpf(request.getCpf());

        if (optUser.isPresent()) {
            throw new Exception("Um usuário com esse CPF já existe!");
        }

        Usuario user = new Usuario(request.getNome(),request.getEmail(), request.getCpf(), request.getDataNascimento());

        System.out.println(user);
        userRepository.save(user);
        return "Usuário criado com sucesso";
    }

    public Optional<Usuario> findUserById(int id) throws Exception {
        var optUser = userRepository.findById(id);
        if(optUser.isEmpty()){
          throw new Exception("Usuário não existe!");
        }
        return userRepository.findById(id);
    }
}
