package com.example.desafioapidevjr.repository;

import com.example.desafioapidevjr.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario>findByCpf(String cpf);
    Optional<Usuario>findByEmail(String email);
}
