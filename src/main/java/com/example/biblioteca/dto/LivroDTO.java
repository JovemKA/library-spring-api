package com.example.biblioteca.dto;

import lombok.Data;

@Data
public class LivroDTO {
    private Long id;
    private String titulo;
    private Integer anoPublicacao;
    private boolean disponivel;

    // Informações referenciadas controladas
    private CategoriaResumidaDTO categoria;
    private AutorResumidoDTO autor;

}
