package com.TpRelaciones.TpRelaciones.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "anioEstreno", nullable = false)
    @NotNull(message =  "El año de estreno no puede ser nulo")
    private Integer AnioEstreno;

    @Column(nullable = false)
    @NotNull(message = "La duracion no puede ser nula")
    @Positive
    private Integer duracion;

    ///  relaciones
    ///
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Genero generoPrincipal;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "subgeneros", joinColumns = @JoinColumn (name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private Set<Genero> subGeneros;

    @ManyToMany(cascade = { CascadeType.MERGE})
    @JoinTable(name = "reparto", joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private Set<Actor> actores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Director director;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Resenia> resenias;



    ///  Constructores
    ///
    ///
    public Pelicula() {
    }

    public Pelicula(String titulo, Integer anioEstreno, Integer duracion) {
        this.titulo = titulo;
        this.AnioEstreno = anioEstreno;
        this.duracion = duracion;
    }

    public Pelicula(String titulo, Integer anioEstreno, Integer duracion, Genero generoPrincipal, Set<Genero> subGeneros, Set<Actor> actores, Director director, Set<Resenia> resenias) {
        this.titulo = titulo;
        this.AnioEstreno = anioEstreno;
        this.duracion = duracion;
        this.generoPrincipal = generoPrincipal;
        this.subGeneros = subGeneros;
        this.actores = actores;
        this.director = director;
        this.resenias = resenias;
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

    public Genero getGeneroPrincipal() {
        return generoPrincipal;
    }

    public void setGeneroPrincipal(Genero generoPrincipal) {
        this.generoPrincipal = generoPrincipal;
    }

    public Set<Genero> getSubGeneros() {
        return subGeneros;
    }

    public void setSubGeneros(Set<Genero> subGeneros) {
        this.subGeneros = subGeneros;
    }

    public Set<Actor> getActores() {
        return actores;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Set<Resenia> getResenias() {
        return resenias;
    }

    public void setResenias(Set<Resenia> resenias) {
        this.resenias = resenias;
    }
}
