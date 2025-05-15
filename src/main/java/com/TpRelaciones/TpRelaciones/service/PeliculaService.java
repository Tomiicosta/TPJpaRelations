package com.TpRelaciones.TpRelaciones.service;

import com.TpRelaciones.TpRelaciones.Exception.BussinesException;
import com.TpRelaciones.TpRelaciones.Exception.NotFoundException;
import com.TpRelaciones.TpRelaciones.models.Pelicula;
import com.TpRelaciones.TpRelaciones.models.Resenia;
import com.TpRelaciones.TpRelaciones.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    ///  guardar/agregar una pelicula
    public Pelicula guardarPelicula(Pelicula pelicula){
        return peliculaRepository.save(pelicula);
    }

    ///  buscar pelicula por nombre director
    public List<Pelicula> buscarPeliculasPorDirector(String nombreDirector){
        return peliculaRepository.findByDirectorNombre(nombreDirector);
    }

    ///  agregar reseña
    public Pelicula agregarResenia(Long id, Resenia resenia){
        Optional<Pelicula> opt = peliculaRepository.findById(id);
        if (opt.isEmpty()){ throw new NotFoundException("No existe la pelicula"); }

            Pelicula pelicula = opt.get();

            pelicula.getResenias().add(resenia);
            resenia.setPelicula(pelicula);

           return peliculaRepository.save(pelicula);
    }
    /// listar todas las peliculas
    public List<Pelicula> obtenerPeliculas(){
        return peliculaRepository.findAll();
    }

    /// obtener por id
    public Optional<Pelicula>  obtenerPeliculaPorId(Long id){
        return peliculaRepository.findById(id);
    }

}
