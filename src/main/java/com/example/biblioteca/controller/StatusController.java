package com.example.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StatusController {

    @GetMapping("/")
    public ResponseEntity<?> status() {
        return ResponseEntity.ok(
                Map.of(
                        "mensagem", "API de Gestão de Biblioteca está online!",
                        "recursos", List.of(
                                "/usuarios",
                                "/livros",
                                "/emprestimos",
                                "/categorias",
                                "/autores"
                        )
                )
        );
    }
}