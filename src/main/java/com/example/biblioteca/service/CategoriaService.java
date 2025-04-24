package com.example.biblioteca.service;

import com.example.biblioteca.model.Categoria;
import com.example.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getById(Long id) {
        return categoriaRepository.findById(id)
                         .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + id));
    }

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public Categoria putCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void delCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
    
}