package com.example.biblioteca.repository;

import com.example.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Consultas personalizadas podem ser adicionadas aqui
}
