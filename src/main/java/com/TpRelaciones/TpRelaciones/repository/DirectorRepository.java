package com.TpRelaciones.TpRelaciones.repository;

import com.TpRelaciones.TpRelaciones.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
