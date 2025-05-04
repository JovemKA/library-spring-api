package com.example.biblioteca.service;

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

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obter um usuário por ID
    public Optional<Usuario> obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Adicionar um usuário
    public Usuario adicionarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Atualizar um usuário existente
    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Remover um usuário
    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
