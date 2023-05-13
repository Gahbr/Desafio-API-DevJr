package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.dto.EnderecoDTO;
import com.example.desafioapidevjr.entities.Endereco;
import com.example.desafioapidevjr.entities.Usuario;
import com.example.desafioapidevjr.repository.EnderecoRepository;
import com.example.desafioapidevjr.service.viaCep.ViaCepService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EnderecoService implements IEnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final IUserService userService;
    private final ViaCepService viaCepService;

    public EnderecoService(EnderecoRepository enderecoRepository,ViaCepService viaCepService, IUserService userService) {
        this.enderecoRepository = enderecoRepository;
        this.userService = userService;
        this.viaCepService = viaCepService;
    }

    @Override
    public Endereco createAddress(EnderecoDTO request) throws Exception {
        Optional<Usuario> findUserId = userService.findUserById(request.getUsuarioId());
        Endereco endereco = new Endereco(request.getCep(),request.getComplemento(),request.getNumero());

        if(findUserId.isEmpty())throw new NoSuchElementException("Não existe usuário com esse ID!");

        try {
            var cepAPI = viaCepService.getCepById(request.getCep());
            var user = findUserId.get();

            endereco.setBairro(cepAPI.getBairro());
            endereco.setUser(user);
            endereco.setCidade(cepAPI.getLocalidade());
            endereco.setEstado(cepAPI.getUf());
            endereco.setLogradouro(cepAPI.getLogradouro());

        }catch (Exception error){
            throw new Exception("Houve algum erro ao fazer o cadastro do CEP : " + error.getMessage());
        }
        return enderecoRepository.save(endereco);
    }
}