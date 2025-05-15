package com.TpRelaciones.TpRelaciones.controller;

import com.TpRelaciones.TpRelaciones.models.Pelicula;
import com.TpRelaciones.TpRelaciones.models.Resenia;
import com.TpRelaciones.TpRelaciones.service.PeliculaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody  Pelicula pelicula){
        Pelicula saved = peliculaService.guardarPelicula(pelicula);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
       List<Pelicula> listaPeliculas = peliculaService.obtenerPeliculas();
       if (listaPeliculas.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.ok(listaPeliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Pelicula> opt = peliculaService.obtenerPeliculaPorId(id);
        if(opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }


    @GetMapping("/director/{nombre}")
    public ResponseEntity<?> getByNombreDirector(@PathVariable String nombreDirector){
        List<Pelicula> peliculas = peliculaService.buscarPeliculasPorDirector(nombreDirector);
        if (peliculas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(peliculas);
    }

    @PostMapping("/id/{resenias}")
    public ResponseEntity<?> agregarResenia(@PathVariable Long id, @Valid @RequestBody Resenia resenia){

        Pelicula peliculaActualizada = peliculaService.agregarResenia(id, resenia);
        return ResponseEntity.ok(peliculaActualizada);
    }

}
