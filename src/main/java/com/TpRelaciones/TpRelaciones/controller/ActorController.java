package com.TpRelaciones.TpRelaciones.controller;

import com.TpRelaciones.TpRelaciones.models.Actor;
import com.TpRelaciones.TpRelaciones.models.Pelicula;
import com.TpRelaciones.TpRelaciones.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/actores")
public class ActorController {

    @Autowired
    ActorService actorService;

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody Actor actor){
        Actor saved = actorService.save(actor);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Actor> opt = actorService.getById(id);
        if(opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Actor> listaPeliculas = actorService.getAll();
        if (listaPeliculas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(listaPeliculas);
    }


}
