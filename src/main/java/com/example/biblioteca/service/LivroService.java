package com.example.biblioteca.service;

import com.example.biblioteca.dto.*;
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

    // Busca livros pelo nome do autor completo
    public List<LivroDTO> buscarPorNomeAutorCompleto(String nomeCompleto) {
        return livroRepository.buscarPorNomeAutorCompleto(nomeCompleto).stream()
                .map(this::toLivroDTO)
                .toList();
    }

    // Busca por título contendo trecho
    public List<LivroDTO> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo).stream()
                .map(this::toLivroDTO)
                .toList();
    }

    // Busca por autor nome e sobrenome
    public List<LivroDTO> buscarPorAutor(String nome, String sobrenome) {
        return livroRepository.findByAutor_NomeIgnoreCaseAndAutor_SobrenomeIgnoreCase(nome, sobrenome).stream()
                .map(this::toLivroDTO)
                .toList();
    }

    // Buscar livros por ano de publicação
    public List<LivroDTO> buscarPorAnoPublicacao(Integer ano) {
        return livroRepository.findByAnoPublicacao(ano).stream()
                .map(this::toLivroDTO)
                .toList();
    }

    // Buscar livros por disponibilidade
    public List<LivroDTO> buscarPorDisponibilidade(boolean disponivel) {
        return livroRepository.findByDisponivel(disponivel).stream()
                .map(this::toLivroDTO)
                .toList();
    }

    // Listar todos os livros
    public List<LivroDTO> listarLivros() {
        return livroRepository.findAll().stream()
                .map(this::toLivroDTO)
                .toList();
    }

    // Criar um novo livro
    public Livro adicionarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    // Obter um livro por ID
    public Optional<LivroDTO> obterLivroPorId(Long id) {
        return livroRepository.findById(id)
                .map(this::toLivroDTO);
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

    // Conversão de entidade para DTO
    public LivroDTO toLivroDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAnoPublicacao(livro.getAnoPublicacao());
        dto.setDisponivel(livro.isDisponivel());

        AutorResumidoDTO autorDto = new AutorResumidoDTO();
        autorDto.setId(livro.getAutor().getId());
        autorDto.setNome(livro.getAutor().getNome());
        autorDto.setSobrenome(livro.getAutor().getSobrenome());
        autorDto.setBiografia(livro.getAutor().getBiografia());
        dto.setAutor(autorDto);

        CategoriaResumidaDTO categoriaDto = new CategoriaResumidaDTO();
        categoriaDto.setId(livro.getCategoria().getId());
        categoriaDto.setNome(livro.getCategoria().getNome());
        categoriaDto.setDescricao(livro.getCategoria().getDescricao());
        dto.setCategoria(categoriaDto);

        return dto;
    }
}