package com.example.biblioteca.service;

import com.example.biblioteca.dto.EmprestimoDTO;
import com.example.biblioteca.dto.UsuarioResumoDTO;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    // Listar todos os empréstimos em DTO
    public List<EmprestimoDTO> listarEmprestimos() {
        return emprestimoRepository.findAll().stream()
                .map(this::toEmprestimoDTO)
                .toList();
    }

    // Buscar um empréstimo por ID em DTO
    public Optional<EmprestimoDTO> obterEmprestimoPorId(Long id) {
        return emprestimoRepository.findById(id)
                .map(this::toEmprestimoDTO);
    }

    // Adicionar novo empréstimo (retorna a entidade)
    public Emprestimo adicionarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    // Atualizar empréstimo existente (retorna a entidade)
    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) {
        if (emprestimoRepository.existsById(emprestimo.getId())) {
            return emprestimoRepository.save(emprestimo);
        } else {
            throw new RuntimeException("Empréstimo não encontrado com ID: " + emprestimo.getId());
        }
    }

    // Remover empréstimo por ID
    public void removerEmprestimo(Long id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empréstimo não encontrado com ID: " + id);
        }
    }

    // Conversão de entidade para DTO
    public EmprestimoDTO toEmprestimoDTO(Emprestimo emprestimo) {
        EmprestimoDTO dto = new EmprestimoDTO();
        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());

        Usuario usuario = emprestimo.getUsuario();
        if (usuario != null) {
            UsuarioResumoDTO usuarioResumo = new UsuarioResumoDTO();
            usuarioResumo.setId(usuario.getId());
            usuarioResumo.setNome(usuario.getNome());
            dto.setUsuario(usuarioResumo);
        } else {
            dto.setUsuario(null);
        }

        dto.setTituloLivro(
            emprestimo.getLivro() != null ? emprestimo.getLivro().getTitulo() : null
        );
        // Adicione campos extras no DTO conforme necessário (como informações resumidas do usuário)
        return dto;
    }
}