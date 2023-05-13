package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.Exception.UserAlreadyExistsException;
import com.example.desafioapidevjr.dto.UserDTO;
import com.example.desafioapidevjr.entities.Usuario;
import com.example.desafioapidevjr.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(UserDTO request) throws UserAlreadyExistsException {
        boolean findUserCpf = userRepository.findByCpf(request.getCpf()).isPresent();
        boolean findUserEmail = userRepository.findByEmail(request.getEmail()).isPresent();

        if (findUserCpf) throw new UserAlreadyExistsException("Um usuário com esse CPF já existe!");
        if(findUserEmail) throw new UserAlreadyExistsException("Um usuário com esse e-mail já existe!");
        if(request.getCpf() == null || request.getEmail() == null || request.getNome() == null || Objects.isNull(request.getDataNascimento())){
            throw new IllegalArgumentException("Preencha os campos de usuário corretamente!");
        }

        Usuario user = new Usuario(request.getNome(),request.getEmail(), request.getCpf(), request.getDataNascimento());

        userRepository.save(user);
        return "Usuário criado com sucesso";
    }

    public Optional<Usuario> findUserById(int id){
        var findUser = userRepository.findById(id);
        if(findUser.isEmpty()){
          throw new NoSuchElementException("Usuário com esse ID não existe!");
        }
        return userRepository.findById(id);
    }
}
