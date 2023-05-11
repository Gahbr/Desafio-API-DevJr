package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.dto.EnderecoDTO;
import com.example.desafioapidevjr.entities.Endereco;
import com.example.desafioapidevjr.entities.Usuario;
import com.example.desafioapidevjr.repository.EnderecoRepository;
import com.example.desafioapidevjr.repository.UserRepository;
import com.example.desafioapidevjr.service.viaCep.ViaCepResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService implements IEnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final UserRepository userRepository;
    private final IUserService userService;

    public EnderecoService(EnderecoRepository enderecoRepository, UserRepository userRepository, IUserService userService) {
        this.enderecoRepository = enderecoRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public Endereco createAddress(EnderecoDTO request, ViaCepResponse apiResponse) throws Exception {
        Optional<Usuario> optUsuario = userService.findUserById(request.getUsuarioId());
        var user = optUsuario.get();

        Usuario usuario = new Usuario();
       // usuario.set(request.getUsuarioId());

        Endereco endereco = new Endereco(request.getCep(),request.getComplemento(),request.getNumero());
        endereco.setBairro(apiResponse.getBairro());
        endereco.setUser(user);
        endereco.setCidade(apiResponse.getLocalidade());
        endereco.setEstado(apiResponse.getUf());
        endereco.setLogradouro(apiResponse.getLogradouro());
       // user.getEndereco().add(endereco);


        return enderecoRepository.save(endereco);
    }
}