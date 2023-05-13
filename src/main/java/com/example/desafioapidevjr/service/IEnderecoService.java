package com.example.desafioapidevjr.service;

import com.example.desafioapidevjr.dto.EnderecoDTO;
import com.example.desafioapidevjr.entities.Endereco;

public interface IEnderecoService {
    Endereco createAddress(EnderecoDTO request) throws Exception;

}
