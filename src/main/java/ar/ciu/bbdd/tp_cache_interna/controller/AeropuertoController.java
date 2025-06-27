package ar.ciu.bbdd.tp_cache_interna.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.ciu.bbdd.tp_cache_interna.dto.AeropuertoDto;
import ar.ciu.bbdd.tp_cache_interna.model.Aeropuerto;
import ar.ciu.bbdd.tp_cache_interna.service.AeropuertoService;

@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController {

	@Autowired
	private AeropuertoService aeropuertoService;
	
	@GetMapping
	public List<Aeropuerto> getAeropuertos() {
		return aeropuertoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aeropuerto> getAeropuerto(@PathVariable UUID id) {
		Aeropuerto aeropuertoEncontrado = this.aeropuertoService.findById(id);
		return ResponseEntity.ok(aeropuertoEncontrado);
	}
	
	@PostMapping
	public ResponseEntity<Aeropuerto> crearAeropuerto(@RequestBody AeropuertoDto aeropuertoDto) {
		Aeropuerto aeropuertoGuardado = aeropuertoService.upsertAeropuerto(aeropuertoDto);
		return ResponseEntity.ok(aeropuertoGuardado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aeropuerto> updateAeropuerto(@PathVariable UUID id,@RequestBody AeropuertoDto aeropuertoDto) {
		Aeropuerto aeropuertoActualizado = this.aeropuertoService.upsertAeropuerto(id, aeropuertoDto);
		return ResponseEntity.ok(aeropuertoActualizado);
	}
}
