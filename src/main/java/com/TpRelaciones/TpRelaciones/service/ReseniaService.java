package com.TpRelaciones.TpRelaciones.service;

import com.TpRelaciones.TpRelaciones.models.Actor;
import com.TpRelaciones.TpRelaciones.models.Resenia;
import com.TpRelaciones.TpRelaciones.repository.ActorRepository;
import com.TpRelaciones.TpRelaciones.repository.ReseniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReseniaService {

    @Autowired
    ReseniaRepository reseniaRepository;

    ///  agregar un resenia
    public Resenia save(Resenia resenia){
        return reseniaRepository.save(resenia);
    }

    ///  listar resenia
    public List<Resenia> getAll(){
        return reseniaRepository.findAll();
    }

    ///  buscar por id
    public Optional<Resenia> getById(Long id){
        return reseniaRepository.findById(id);
    }

}
