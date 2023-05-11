package com.example.desafioapidevjr.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

//O primeiro passo deve ser a construção de um cadastro de usuários, sendo obrigatório dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e CPF devem ser únicos.
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;


    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Endereco> Endereco;


    // getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<com.example.desafioapidevjr.entities.Endereco> getEndereco() {
        return Endereco;
    }

    public void setEndereco(List<com.example.desafioapidevjr.entities.Endereco> endereco) {
        Endereco = endereco;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Long getId() {
        return id;
    }

    //construtores
    public Usuario() {

    }

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento, List<Endereco> endereco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        Endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
