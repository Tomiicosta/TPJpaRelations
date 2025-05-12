package com.TpRelaciones.TpRelaciones.repository;

import com.TpRelaciones.TpRelaciones.models.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, Long> {
}
