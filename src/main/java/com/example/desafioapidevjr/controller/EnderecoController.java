package com.example.desafioapidevjr.controller;

import com.example.desafioapidevjr.dto.EnderecoDTO;
import com.example.desafioapidevjr.entities.Endereco;
import com.example.desafioapidevjr.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController( EnderecoService enderecoService) {this.enderecoService = enderecoService;}

    @PostMapping()
    public ResponseEntity<Endereco> newAddress(@RequestBody EnderecoDTO request) {
        try {
            var response = enderecoService.createAddress(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception error){
            return ResponseEntity.badRequest().header("Error-Message", error.getMessage()).build();
        }
    }
}
