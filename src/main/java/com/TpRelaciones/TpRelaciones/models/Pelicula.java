package com.TpRelaciones.TpRelaciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.engine.internal.Cascade;

import java.util.List;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id")
    private Genero generoPrincipal;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "subgeneros", joinColumns = @JoinColumn (name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private Set<Genero> subGeneros;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "reparto", joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private Set<Actor> actores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(mappedBy = "peliculas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Resenia> resenias;


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
