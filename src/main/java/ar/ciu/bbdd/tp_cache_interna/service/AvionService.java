package ar.ciu.bbdd.tp_cache_interna.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.ciu.bbdd.tp_cache_interna.model.Avion;
import ar.ciu.bbdd.tp_cache_interna.repository.AvionRepository;

@Service
public class AvionService {
	
	@Autowired
	private AvionRepository avionRepository;
	
	public Avion findById(UUID idAvion) {
		return this.avionRepository.findById(idAvion).get();
	}
}
