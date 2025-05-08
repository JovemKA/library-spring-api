package com.example.biblioteca.service;

import com.example.biblioteca.dto.CategoriaResumidaDTO;
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

    // Listar todas as categorias como DTO
    public List<CategoriaResumidaDTO> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toCategoriaResumidaDTO)
                .toList();
    }

    // Buscar categoria por ID (entidade)
    public Optional<Categoria> obterCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Converter Categoria em CategoriaResumidaDTO
    public CategoriaResumidaDTO toCategoriaResumidaDTO(Categoria categoria) {
        CategoriaResumidaDTO dto = new CategoriaResumidaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        dto.setDescricao(categoria.getDescricao());
        return dto;
    }

    // Salvar categoria (criação)
    public Categoria adicionarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Atualizar categoria existente
    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Remover categoria
    public void removerCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}