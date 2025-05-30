package com.TpRelaciones.TpRelaciones.repository;

import com.TpRelaciones.TpRelaciones.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository  extends JpaRepository<Pelicula, Long> {
    public List<Pelicula> findByDirectorNombre(String nombreDirector);
}
