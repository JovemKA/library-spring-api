package com.example.biblioteca.service;

import com.example.biblioteca.dto.UsuarioResumoDTO;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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