package com.TpRelaciones.TpRelaciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "directores")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull
    private String nombre;

    ///  relacion
    @OneToMany(mappedBy = "director")
    private List<Pelicula> peliculas;

    ///  Constructor
    public Director(String nombre) {
        this.nombre = nombre;
    }

    public Director() {
    }

    /// Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

