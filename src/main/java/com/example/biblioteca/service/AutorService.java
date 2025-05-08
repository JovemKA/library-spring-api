package com.example.biblioteca.service;

import com.example.biblioteca.dto.AutorResumidoDTO;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorResumidoDTO> listarAutores() {
        return autorRepository.findAll().stream()
            .map(this::toAutorResumidoDTO)
            .toList();
    }

    public AutorResumidoDTO toAutorResumidoDTO(Autor autor) {
        AutorResumidoDTO dto = new AutorResumidoDTO();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        dto.setSobrenome(autor.getSobrenome());
        dto.setBiografia(autor.getBiografia());
        return dto;
    }

    public Optional<Autor> obterAutorPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor adicionarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor atualizarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void removerAutor(Long id) {
        autorRepository.deleteById(id);
    }
}