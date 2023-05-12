package com.example.desafioapidevjr.controller;

import com.example.desafioapidevjr.dto.EnderecoDTO;
import com.example.desafioapidevjr.entities.Endereco;
import com.example.desafioapidevjr.service.EnderecoService;
import com.example.desafioapidevjr.service.viaCep.ViaCepResponse;
import com.example.desafioapidevjr.service.viaCep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final ViaCepService viaCepService;
    private final EnderecoService enderecoService;

    public EnderecoController(ViaCepService viaCepService, EnderecoService enderecoService) {
        this.viaCepService = viaCepService;
        this.enderecoService = enderecoService;
    }

    @PostMapping()
    public Endereco newAddress(@RequestBody EnderecoDTO request) throws Exception {
        var cepAPI = viaCepService.getCepById(request.getCep());

        var create = enderecoService.createAddress(request, cepAPI);
        return create;
    }
}
