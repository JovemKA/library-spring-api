package com.example.biblioteca.repository;

import com.example.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Buscar por título contendo uma palavra ou trecho, ignorando maiúsculas/minúsculas
    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    // Buscar livros por nome do autor (nome + sobrenome)
    List<Livro> findByAutor_NomeIgnoreCaseAndAutor_SobrenomeIgnoreCase(String nome, String sobrenome);

    // Buscar livros por autor completo usando JPQL
    @Query("SELECT l FROM Livro l WHERE CONCAT(l.autor.nome, ' ', l.autor.sobrenome) LIKE %:nomeCompleto%")
    List<Livro> buscarPorNomeAutorCompleto(@Param("nomeCompleto") String nomeCompleto);

    // Buscar livros por ano de publicação
    List<Livro> findByAnoPublicacao(Integer ano);

    // Buscar livros por disponibilidade
    List<Livro> findByDisponivel(boolean disponivel);

}
