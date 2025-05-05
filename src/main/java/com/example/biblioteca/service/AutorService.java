package com.example.biblioteca.service;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public Optional<Autor> obterAutorPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor adicionarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor atualizarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void removerAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
