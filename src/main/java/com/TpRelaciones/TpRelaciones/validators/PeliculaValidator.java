package com.TpRelaciones.TpRelaciones.validators;

import com.TpRelaciones.TpRelaciones.Exception.BussinesException;
import com.TpRelaciones.TpRelaciones.models.Actor;
import com.TpRelaciones.TpRelaciones.models.Director;
import com.TpRelaciones.TpRelaciones.models.Genero;
import com.TpRelaciones.TpRelaciones.models.Pelicula;
import com.TpRelaciones.TpRelaciones.repository.ActorRepository;
import com.TpRelaciones.TpRelaciones.repository.DirectorRepository;
import com.TpRelaciones.TpRelaciones.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PeliculaValidator
{
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    GeneroRepository generoRepository;

    public void validarYSetearDirector(Pelicula pelicula){
        Optional<Director> director = directorRepository.findById(pelicula.getDirector().getId());
        if(director.isPresent()){
            pelicula.setDirector(director.get());
        }
        else{
            throw new BussinesException("El director no existe");
        }

    }

    public void validayYsetearGeneroPrincipal(Pelicula pelicula){
        Optional<Genero> genero = generoRepository.findById(pelicula.getGeneroPrincipal().getId());
        if(genero.isPresent()){
            pelicula.setGeneroPrincipal(genero.get());
        }
        else{
            throw new BussinesException("El genero principal no existe");
        }

    }

    public void validarYSetearActores(Pelicula pelicula){
        Set<Actor> actores = pelicula.getActores().stream()
                .map(actor -> actorRepository.findById(actor.getId())
                        .orElseThrow(() -> new BussinesException("El actor con id " + actor.getId() + " no existe.")))
                .collect(Collectors.toSet());
        pelicula.setActores(actores);

    }

    public void validarYSetearSubgeneros(Pelicula pelicula){
        Set<Genero> subGeneros = pelicula.getSubGeneros().stream()
                .map(subGenero -> generoRepository.findById(subGenero.getId())
                        .orElseThrow(() -> new BussinesException("El genero con id " + subGenero.getId() + "no existe")))
                .collect(Collectors.toSet());
        pelicula.setSubGeneros(subGeneros);

    }
}

