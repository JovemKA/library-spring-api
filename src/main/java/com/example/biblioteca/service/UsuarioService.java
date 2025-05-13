package com.example.biblioteca.service;

import com.example.biblioteca.dto.EmprestimoDTO;
import com.example.biblioteca.dto.UsuarioResumoDTO;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResumoDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(this::toUsuarioDTO)
                .toList();
    }

    public UsuarioResumoDTO toUsuarioDTO(Usuario usuario) {
        UsuarioResumoDTO dto = new UsuarioResumoDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());

        // Mapeia os emprestimos para EmprestimoDTO, evitando incluir o usuário dentro do DTO do emprestimo
        List<EmprestimoDTO> emprestimosDTO = usuario.getEmprestimos().stream()
                .map(this::toEmprestimoDTO)
                .collect(Collectors.toList());

        dto.setEmprestimos(emprestimosDTO); // Supondo que exista o setEmprestimos no DTO do usuário

        return dto;
    }

    private EmprestimoDTO toEmprestimoDTO(Emprestimo emprestimo) {
        EmprestimoDTO dto = new EmprestimoDTO();
        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());
        dto.setTituloLivro(emprestimo.getLivro().getTitulo()); // Supondo que Emprestimo tem getLivro()
        return dto;
    }

    public Optional<Usuario> obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}