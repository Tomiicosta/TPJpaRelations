package com.TpRelaciones.TpRelaciones.repository;

import com.TpRelaciones.TpRelaciones.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
