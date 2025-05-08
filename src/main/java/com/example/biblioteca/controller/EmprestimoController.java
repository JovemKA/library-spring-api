package com.example.biblioteca.controller;

import com.example.biblioteca.dto.EmprestimoDTO;
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

    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> listarEmprestimos() {
        return ResponseEntity.ok(emprestimoService.listarEmprestimos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> obterEmprestimoPorId(@PathVariable Long id) {
        Optional<Emprestimo> emprestimo = emprestimoService.obterEmprestimoPorId(id);
        return emprestimo.map(e -> ResponseEntity.ok(emprestimoService.toEmprestimoDTO(e)))
                         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Emprestimo> adicionarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoService.adicionarEmprestimo(emprestimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEmprestimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        emprestimo.setId(id);
        Emprestimo emprestimoAtualizado = emprestimoService.atualizarEmprestimo(emprestimo);
        return ResponseEntity.ok(emprestimoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEmprestimo(@PathVariable Long id) {
        emprestimoService.removerEmprestimo(id);
        return ResponseEntity.noContent().build();
    }
}