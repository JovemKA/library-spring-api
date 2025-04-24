package com.example.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne // Relacionamento muitos-para-um com Autor
    @JoinColumn(name = "autor_id", nullable = false) // Define a coluna de chave estrangeira
    private Autor autor;

    @ManyToOne // Relacionamento muitos-para-um com Categoria
    @JoinColumn(name = "categoria_id", nullable = false) // Define a coluna de chave estrangeira
    private Categoria categoria;

    @Column(name = "ano_publicacao") // Nome da coluna no banco de dados
    private Integer anoPublicacao; // Usar Integer para representar o ano

    @Column(nullable = false) // Disponibilidade não pode ser nula
    private boolean disponivel;
}
