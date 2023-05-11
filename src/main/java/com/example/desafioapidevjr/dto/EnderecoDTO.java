package com.example.desafioapidevjr.dto;

public class EnderecoDTO {
    private int usuarioId;
    private int numero;
    private String complemento;
    private String cep;


    public EnderecoDTO(int usuarioId, int numero, String complemento, String cep) {
        this.usuarioId = usuarioId;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
