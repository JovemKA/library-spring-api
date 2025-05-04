package com.example.biblioteca.controller;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    // Listar todos os empréstimos
    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();
        return ResponseEntity.ok(emprestimos);
    }

    // Obter empréstimo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> obterEmprestimoPorId(@PathVariable Long id) {
        Optional<Emprestimo> emprestimo = emprestimoService.obterEmprestimoPorId(id);
        return emprestimo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Criar novo empréstimo
    @PostMapping
    public ResponseEntity<Emprestimo> adicionarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoService.adicionarEmprestimo(emprestimo);
        return new ResponseEntity<>(novoEmprestimo, HttpStatus.CREATED);
    }

    // Atualizar empréstimo existente
    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        emprestimo.setId(id);
        Emprestimo emprestimoAtualizado = emprestimoService.atualizarEmprestimo(emprestimo);
        return ResponseEntity.ok(emprestimoAtualizado);
    }

    // Remover empréstimo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEmprestimo(@PathVariable Long id) {
        emprestimoService.removerEmprestimo(id);
        return ResponseEntity.noContent().build();
    }
}