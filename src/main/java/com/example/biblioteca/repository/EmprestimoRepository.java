package com.example.biblioteca.repository;

import com.example.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    // Consultas personalizadas podem ser adicionadas aqui
}