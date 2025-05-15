package com.TpRelaciones.TpRelaciones.controller;

import com.TpRelaciones.TpRelaciones.models.Actor;
import com.TpRelaciones.TpRelaciones.models.Director;
import com.TpRelaciones.TpRelaciones.service.ActorService;
import com.TpRelaciones.TpRelaciones.service.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/directores")
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody Director director){
        Director saved = directorService.save(director);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Director> opt = directorService.getById(id);
        if(opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Director> lista = directorService.getAll();
        if (lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(lista);
    }
}
