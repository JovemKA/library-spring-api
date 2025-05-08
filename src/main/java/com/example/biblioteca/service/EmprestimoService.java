package com.example.biblioteca.service;

import com.example.biblioteca.dto.EmprestimoDTO;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<EmprestimoDTO> listarEmprestimos() {
        return emprestimoRepository.findAll().stream()
                .map(this::toEmprestimoDTO)
                .toList();
    }

    public EmprestimoDTO toEmprestimoDTO(Emprestimo emprestimo) {
        EmprestimoDTO dto = new EmprestimoDTO();
        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());
        dto.setTituloLivro(emprestimo.getLivro().getTitulo());

        return dto;
    }

    public Optional<Emprestimo> obterEmprestimoPorId(Long id) {
        return emprestimoRepository.findById(id);
    }

    public Emprestimo adicionarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void removerEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}