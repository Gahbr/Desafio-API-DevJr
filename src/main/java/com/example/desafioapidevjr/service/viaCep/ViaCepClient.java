package com.example.desafioapidevjr.service.viaCep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "viaApiClient", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping(value = "/{cep}/json/")
    ViaCepResponse getCepById(@PathVariable("cep") String cep);
}
