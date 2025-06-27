package ar.ciu.bbdd.tp_cache_interna.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ar.ciu.bbdd.tp_cache_interna.dto.AeropuertoDto;
import ar.ciu.bbdd.tp_cache_interna.model.Aeropuerto;
import ar.ciu.bbdd.tp_cache_interna.repository.AeropuertoRepository;
import jakarta.transaction.Transactional;

@Service
public class AeropuertoService {
	@Autowired
	private AeropuertoRepository aeropuertoRepository;
	
	public List<Aeropuerto> findAll() {
		return aeropuertoRepository.findAll();
	}
	
	@Cacheable(cacheNames={"aeropuertosCache"}, key="#idAeropuerto" )
	public Aeropuerto findById(UUID idAeropuerto) {
		return aeropuertoRepository.findById(idAeropuerto).get();
	}
	
	@Transactional
	public Aeropuerto upsertAeropuerto(AeropuertoDto aeropuertoDto) {
		UUID newId = UUID.randomUUID();
		Object[] result = this.aeropuertoRepository.upsertAeropuerto(
							newId,
							aeropuertoDto.getNombre(),
							aeropuertoDto.getCiudad(), 
							aeropuertoDto.getPais());
		
		if(result != null) {
			return this.aeropuertoRepository.findByNombreAndCiudadAndPais(aeropuertoDto.getNombre(), aeropuertoDto.getCiudad(), aeropuertoDto.getPais()).get();
		} else {
			throw new IllegalStateException("Fallo al realizar el UPSERT o al recuperar los datos del aeropuerto");
		}
	}
	
	@Transactional
	public Aeropuerto upsertAeropuerto(UUID id, AeropuertoDto aeropuertoDto) {
		Object[] result = this.aeropuertoRepository.upsertAeropuerto(id, aeropuertoDto.getNombre(), aeropuertoDto.getCiudad(), aeropuertoDto.getPais());
		
		if(result != null) {
			return this.aeropuertoRepository.findByNombreAndCiudadAndPais(aeropuertoDto.getNombre(), 
																		  aeropuertoDto.getCiudad(), 
																		  aeropuertoDto.getPais()).get();
		} else {
			throw new IllegalStateException("Fallo al realizar el UPSERT o al recuperar los datos del aeropuerto");
		}
	}
	
}
