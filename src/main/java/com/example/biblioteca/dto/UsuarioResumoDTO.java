package com.example.biblioteca.dto;

import lombok.Data;
import java.util.List;

@Data
public class UsuarioResumoDTO {
    private Long id;
    private String nome;
    private String email;
    private List<EmprestimoDTO> emprestimos;
}
