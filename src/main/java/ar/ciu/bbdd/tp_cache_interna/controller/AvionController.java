package ar.ciu.bbdd.tp_cache_interna.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.ciu.bbdd.tp_cache_interna.model.Avion;
import ar.ciu.bbdd.tp_cache_interna.service.AvionService;

@Controller
@RequestMapping("/aviones")
public class AvionController {
	@Autowired
	private AvionService avionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Avion> getAvion(@PathVariable UUID idAvion) {
		return ResponseEntity.ok(this.avionService.findById(idAvion));
	}
}
