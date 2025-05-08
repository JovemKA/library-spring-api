package com.example.biblioteca.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoDTO {
    private Long id;
    private LocalDate dataDevolucao;
    private LocalDate dataEmprestimo;

    private String tituloLivro;
}
