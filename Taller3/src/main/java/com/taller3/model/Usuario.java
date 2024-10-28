package com.taller3.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Persona {

    private int prestamos;

    // Getters y Setters
    public int getPrestamos() { return prestamos; }
    public void setPrestamos(int prestamos) { this.prestamos = prestamos; }
}

