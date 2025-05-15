package com.TpRelaciones.TpRelaciones.service;

import com.TpRelaciones.TpRelaciones.models.Actor;
import com.TpRelaciones.TpRelaciones.models.Genero;
import com.TpRelaciones.TpRelaciones.repository.ActorRepository;
import com.TpRelaciones.TpRelaciones.repository.DirectorRepository;
import com.TpRelaciones.TpRelaciones.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepository;

    ///  agregar un director
    public Genero save(Genero genero){
        return generoRepository.save(genero);
    }

    ///  listar director
    public List<Genero> getAll(){
        return generoRepository.findAll();
    }

    ///  buscar por id
    public Optional<Genero> getById(Long id){
        return generoRepository.findById(id);
    }

}
