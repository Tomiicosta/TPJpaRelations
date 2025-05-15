package com.TpRelaciones.TpRelaciones.service;

import com.TpRelaciones.TpRelaciones.models.Actor;
import com.TpRelaciones.TpRelaciones.models.Director;
import com.TpRelaciones.TpRelaciones.repository.ActorRepository;
import com.TpRelaciones.TpRelaciones.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    ///  agregar un director
    public Director save(Director director){
        return directorRepository.save(director);
    }

    ///  listar directores
    public List<Director> getAll(){
        return directorRepository.findAll();
    }

    ///  buscar por id
    public Optional<Director> getById(Long id){
        return directorRepository.findById(id);
    }


}
