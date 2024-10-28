package com.taller3.service;

import com.taller3.model.Libro;
import com.taller3.model.Prestamo;
import com.taller3.model.Usuario;
import com.taller3.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroService libroService;
    private final UsuarioService usuarioService;

    @Autowired
    public PrestamoService(PrestamoRepository prestamoRepository, LibroService libroService, UsuarioService usuarioService) {
        this.prestamoRepository = prestamoRepository;
        this.libroService = libroService;
        this.usuarioService = usuarioService;
    }

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> findById(int id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo save(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void deleteById(int id) {
        prestamoRepository.deleteById(id);
    }

    public void realizarPrestamo(int libroId, int usuarioId) {
        Optional<Libro> libroOpt = libroService.findById(libroId);
        Optional<Usuario> usuarioOpt = usuarioService.findById(usuarioId);

        if (libroOpt.isPresent() && usuarioOpt.isPresent()) {
            Libro libro = libroOpt.get();
            Usuario usuario = usuarioOpt.get();

            if (libro.isDisponible()) {
                libro.setDisponible(false);
                libroService.save(libro);

                Prestamo prestamo = new Prestamo();
                prestamo.setLibro(libro);
                prestamo.setUsuario(usuario);
                prestamo.setFechaPrestamo(new Date());

                prestamoRepository.save(prestamo);
            }
        }
    }

    public void devolverLibro(int prestamoId) {
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(prestamoId);

        if (prestamoOpt.isPresent()) {
            Prestamo prestamo = prestamoOpt.get();
            Libro libro = prestamo.getLibro();
            libro.setDisponible(true);
            libroService.save(libro);

            prestamo.setFechaDevolucion(new Date());
            prestamoRepository.save(prestamo);
        }
    }
}