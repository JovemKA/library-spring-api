package com.example.biblioteca.controller;

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

    // Listar todos os autores
    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        return ResponseEntity.ok(autorService.listarAutores());
    }

    // Buscar autor por id
    @GetMapping("/{id}")
    public ResponseEntity<Autor> obterAutorPorId(@PathVariable Long id) {
        Optional<Autor> autor = autorService.obterAutorPorId(id);
        return autor.map(ResponseEntity::ok)
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
    public ResponseEntity<Void> removerAutor(@PathVariable Long id) {
        autorService.removerAutor(id);
        return ResponseEntity.noContent().build();
    }
}
