package com.TpRelaciones.TpRelaciones.controller;

import com.TpRelaciones.TpRelaciones.models.Director;
import com.TpRelaciones.TpRelaciones.models.Genero;
import com.TpRelaciones.TpRelaciones.service.DirectorService;
import com.TpRelaciones.TpRelaciones.service.GeneroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody Genero genero){
        Genero saved = generoService.save(genero);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Genero> opt = generoService.getById(id);
        if(opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Genero> lista = generoService.getAll();
        if (lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(lista);
    }
}
