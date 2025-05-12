package com.TpRelaciones.TpRelaciones.repository;

import com.TpRelaciones.TpRelaciones.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
