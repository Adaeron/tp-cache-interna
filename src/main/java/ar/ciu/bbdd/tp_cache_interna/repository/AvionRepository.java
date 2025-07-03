package ar.ciu.bbdd.tp_cache_interna.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.ciu.bbdd.tp_cache_interna.model.Avion;

public interface AvionRepository extends JpaRepository<Avion, UUID>{

}
