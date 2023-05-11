package com.example.desafioapidevjr.service.viaCep;

import org.springframework.stereotype.Service;


@Service
public class ViaCepService {
    private final ViaCepClient viaCepClient;

    public ViaCepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public ViaCepResponse getCepById(String cep) {
        return viaCepClient.getCepById(cep);
    }
}
