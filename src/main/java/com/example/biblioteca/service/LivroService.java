package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Criar um novo livro
    public Livro adicionarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    // Listar todos os livros
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // Obter um livro por ID
    public Optional<Livro> obterLivroPorId(Long id) {
        return livroRepository.findById(id);
    }

    // Atualizar um livro existente
    public Livro atualizarLivro(Livro livro) {
        if (livroRepository.existsById(livro.getId())) {
            return livroRepository.save(livro);
        } else {
            throw new RuntimeException("Livro não encontrado com ID: " + livro.getId());
        }
    }

    // Remover um livro
    public void removerLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
    }
}
