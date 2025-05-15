package com.TpRelaciones.TpRelaciones.service;

import com.TpRelaciones.TpRelaciones.models.Actor;
import com.TpRelaciones.TpRelaciones.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    ///  agregar un actor
    public Actor save(Actor actor){
        return actorRepository.save(actor);
    }

    ///  listar actores
    public List<Actor> getAll(){
        return actorRepository.findAll();
    }

    ///  buscar por id
    public Optional<Actor> getById(Long id){
        return actorRepository.findById(id);
    }


}
