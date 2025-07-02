package ar.ciu.bbdd.tp_cache_interna.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.ciu.bbdd.tp_cache_interna.model.Aeropuerto;
import jakarta.transaction.Transactional;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, UUID>{
    
    @Modifying 
    @Transactional
    @Query(value = """
            INSERT INTO aeropuerto (id, nombre, ciudad, pais)
            VALUES (:id, :nombre, :ciudad, :pais)
            ON CONFLICT (nombre, ciudad, pais) DO UPDATE SET
                nombre = :nombre,
                ciudad = :ciudad,
                pais = :pais
            RETURNING id, nombre, ciudad, pais, optlock
            """, nativeQuery = true)
    Object[] upsertAeropuerto(@Param("id") UUID id,
    						  @Param("nombre") String nombre,
                              @Param("ciudad") String ciudad,
                              @Param("pais") String pais);
    
    Optional<Aeropuerto> findByNombreAndCiudadAndPais(String nombre, String ciudad, String pais);

}
