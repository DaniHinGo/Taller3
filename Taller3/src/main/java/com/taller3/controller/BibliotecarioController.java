package com.taller3.controller;

import com.taller3.model.Bibliotecario;
import com.taller3.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bibliotecarios")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    @GetMapping
    public List<Bibliotecario> obtenerTodosLosBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Bibliotecario> obtenerBibliotecarioPorId(@PathVariable Integer id) {
        return bibliotecarioRepository.findById(id);
    }

    @PostMapping
    public Bibliotecario crearBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    @PutMapping("/{id}")
    public Bibliotecario actualizarBibliotecario(@PathVariable Integer id, @RequestBody Bibliotecario bibliotecario) {
        bibliotecario.setId(id);
        return bibliotecarioRepository.save(bibliotecario);
    }

    @DeleteMapping("/{id}")
    public void eliminarBibliotecario(@PathVariable Integer id) {
        bibliotecarioRepository.deleteById(id);
    }
}
