package com.taller3.controller;

import com.taller3.model.Libro;
import com.taller3.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Libro> obtenerLibroPorId(@PathVariable Integer id) {
        return libroRepository.findById(id);
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Integer id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroRepository.save(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Integer id) {
        libroRepository.deleteById(id);
    }
}
