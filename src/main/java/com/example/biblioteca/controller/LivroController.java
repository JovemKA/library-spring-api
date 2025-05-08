package com.example.biblioteca.controller;

import com.example.biblioteca.dto.LivroDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Criar um novo livro
    @PostMapping
    public ResponseEntity<LivroDTO> adicionarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.adicionarLivro(livro);
        LivroDTO livroDTO = livroService.toLivroDTO(novoLivro);
        return new ResponseEntity<>(livroDTO, HttpStatus.CREATED);
    }

    // Listar todos os livros, com filtros opcionais
    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String nomeAutor,
            @RequestParam(required = false) String sobrenomeAutor,
            @RequestParam(required = false) String nomeCompletoAutor,
            @RequestParam(required = false) Integer anoPublicacao,
            @RequestParam(required = false) Boolean disponivel) {

        List<LivroDTO> livros;

        if (nomeAutor != null && sobrenomeAutor != null) {
            livros = livroService.buscarPorAutor(nomeAutor, sobrenomeAutor);
        } else if (nomeCompletoAutor != null) {
            livros = livroService.buscarPorNomeAutorCompleto(nomeCompletoAutor);
        } else if (titulo != null) {
            livros = livroService.buscarPorTitulo(titulo);
        } else if (anoPublicacao != null) {
            livros = livroService.buscarPorAnoPublicacao(anoPublicacao);
        } else if (disponivel != null) {
            livros = livroService.buscarPorDisponibilidade(disponivel);
        } else {
            livros = livroService.listarLivros();
        }

        return ResponseEntity.ok(livros);
    }

    // Obter um livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> obterLivroPorId(@PathVariable Long id) {
        Optional<LivroDTO> livroDTO = livroService.obterLivroPorId(id);
        return livroDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Atualizar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        Livro livroAtualizado = livroService.atualizarLivro(livro);
        LivroDTO livroDTO = livroService.toLivroDTO(livroAtualizado);
        return ResponseEntity.ok(livroDTO);
    }

    // Remover um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivro(@PathVariable Long id) {
        livroService.removerLivro(id);
        return ResponseEntity.noContent().build();
    }
}