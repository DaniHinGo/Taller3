package com.taller3.service;

import com.taller3.model.Bibliotecario;
import com.taller3.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    @Autowired
    public BibliotecarioService(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    public List<Bibliotecario> findAll() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<Bibliotecario> findById(int id) {
        return bibliotecarioRepository.findById(id);
    }

    public Bibliotecario save(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public void deleteById(int id) {
        bibliotecarioRepository.deleteById(id);
    }
}
