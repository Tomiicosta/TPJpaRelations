package com.TpRelaciones.TpRelaciones.controller;

import com.TpRelaciones.TpRelaciones.models.Director;
import com.TpRelaciones.TpRelaciones.models.Resenia;
import com.TpRelaciones.TpRelaciones.service.DirectorService;
import com.TpRelaciones.TpRelaciones.service.ReseniaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/resenias")
public class ReseniaController {
    @Autowired
    ReseniaService reseniaService;

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody Resenia resenia) {
        Resenia saved = reseniaService.save(resenia);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Resenia> opt = reseniaService.getById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Resenia> lista = reseniaService.getAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(lista);
    }
}
