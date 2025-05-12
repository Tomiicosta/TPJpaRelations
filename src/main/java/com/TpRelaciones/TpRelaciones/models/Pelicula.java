package com.TpRelaciones.TpRelaciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "El titulo no puede ser nulo")
    private String titulo;

    @Column(nullable = false)
    @NotNull(message =  "El año de estreno no puede ser nulo")
    private Integer AnioEstreno;

    @Column(nullable = false)
    @NotNull(message = "La duracion no puede ser nula")
    @Positive
    private Integer duracion;

    ///  Constructores

    public Pelicula(String titulo, Integer anioEstreno, Integer duracion) {
        this.titulo = titulo;
        AnioEstreno = anioEstreno;
        this.duracion = duracion;
    }

    ///  Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioEstreno() {
        return AnioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        AnioEstreno = anioEstreno;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
}
