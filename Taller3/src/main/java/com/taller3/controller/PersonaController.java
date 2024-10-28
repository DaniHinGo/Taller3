package com.taller3.controller;

import com.taller3.model.Persona;
import com.taller3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> obtenerPersonaPorId(@PathVariable Integer id) {
        return personaRepository.findById(id);
    }

    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Integer id, @RequestBody Persona persona) {
        persona.setId(id);
        return personaRepository.save(persona);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Integer id) {
        personaRepository.deleteById(id);
    }
}