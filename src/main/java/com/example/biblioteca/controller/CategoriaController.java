
package com.example.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.biblioteca.model.Categoria;
import com.example.biblioteca.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService CategoriaService;


    // Listar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = CategoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

    // Obter categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obterCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = Optional.ofNullable(CategoriaService.getById(id));
        return categoria.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Criar nova categoria
    @PostMapping
    public ResponseEntity<Categoria> adicionarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = CategoriaService.saveCategoria(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    // Atualizar categoria existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria categoriaAtualizada = CategoriaService.putCategoria(categoria);
        return ResponseEntity.ok(categoriaAtualizada);
    }

    // Remover categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCategoria(@PathVariable Long id) {
        CategoriaService.delCategoria(id);
        return ResponseEntity.noContent().build();
    }
}