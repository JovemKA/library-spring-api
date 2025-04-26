
package com.example.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.biblioteca.model.Categoria;
import com.example.biblioteca.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cv")
public class CategoriaController {

    @Autowired
    private CategoriaService CategoriaService;


    @GetMapping("/getallcat")
    public List<Categoria> getAllCategorias() {
        return CategoriaService.getAllCategorias();
    }
    @GetMapping("/getcat/{id}")
    public Categoria getById(@PathVariable Long id) {
        return CategoriaService.getById(id);
    }


    @PostMapping("/postcat")
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return CategoriaService.saveCategoria(categoria);
    }


    @PutMapping("/putcat/{id}")
    public Categoria putCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id); 
        return CategoriaService.putCategoria(categoria);
    }


    @DeleteMapping("/delcat/{id}")
    public void delCategoria(@PathVariable Long id) {
        CategoriaService.delCategoria(id);
    }
}