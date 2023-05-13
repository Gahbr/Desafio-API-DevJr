package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.dto.EnderecoDTO;
import com.example.desafioapidevjr.entities.Endereco;
import com.example.desafioapidevjr.service.viaCep.ViaCepResponse;

public interface IEnderecoService {
    Endereco createAddress(EnderecoDTO request) throws Exception;

}
