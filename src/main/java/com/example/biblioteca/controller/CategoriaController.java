package com.example.biblioteca.controller;

import com.example.biblioteca.dto.CategoriaResumidaDTO;
import com.example.biblioteca.model.Categoria;
import com.example.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Listar todas as categorias (DTO)
    @GetMapping
    public ResponseEntity<List<CategoriaResumidaDTO>> listarCategorias() {
        List<CategoriaResumidaDTO> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    // Buscar categoria por ID (DTO)
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResumidaDTO> obterCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.obterCategoriaPorId(id);
        return categoria.map(c -> ResponseEntity.ok(categoriaService.toCategoriaResumidaDTO(c)))
                        .orElse(ResponseEntity.notFound().build());
    }

    // Criar nova categoria (entidade na entrada/saída)
    @PostMapping
    public ResponseEntity<Categoria> adicionarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.adicionarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    // Atualizar categoria existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria categoriaAtualizada = categoriaService.atualizarCategoria(categoria);
        return ResponseEntity.ok(categoriaAtualizada);
    }

    // Remover categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCategoria(@PathVariable Long id) {
        categoriaService.removerCategoria(id);
        return ResponseEntity.noContent().build();
    }
}