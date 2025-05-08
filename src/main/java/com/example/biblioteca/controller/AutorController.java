package com.example.biblioteca.controller;

import com.example.biblioteca.dto.AutorResumidoDTO;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Listar todos os autores (Agora usando DTO)
    @GetMapping
    public ResponseEntity<List<AutorResumidoDTO>> listarAutores() {
        return ResponseEntity.ok(autorService.listarAutores());
    }

    // Buscar autor por id (opcionalmente pode usar um DTO também se desejar)
    @GetMapping("/{id}")
    public ResponseEntity<AutorResumidoDTO> obterAutorPorId(@PathVariable Long id) {
        Optional<Autor> autor = autorService.obterAutorPorId(id);
        return autor.map(a -> ResponseEntity.ok(autorService.toAutorResumidoDTO(a)))
                    .orElse(ResponseEntity.notFound().build());
    }

    // Criar um novo Autor
    @PostMapping
    public ResponseEntity<Autor> adicionarAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.adicionarAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
    }

    // Atualizar um autor existente
    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        autor.setId(id);
        Autor autorAtualizado = autorService.atualizarAutor(autor);
        return ResponseEntity.ok(autorAtualizado);
    }

    // Remover autor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAutor(@PathVariable Long id) {
        autorService.removerAutor(id);
        return ResponseEntity.noContent().build();
    }
}