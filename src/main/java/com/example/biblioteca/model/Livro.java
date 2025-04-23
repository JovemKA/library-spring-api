package com.example.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String categoria;

    private int anoPublicacao;
    private boolean disponivel;
}
