package ar.ciu.bbdd.tp_cache_interna.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "numero_serie")
	private String numeroSerie;
	@Column(name = "nombre_tipo_de_avion")
	private String nombreTipoDeAvion;
	@Column(name = "total_de_asientos")
	private Integer totalAsientos;
	
	public Avion() {}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getNombreTipoDeAvion() {
		return nombreTipoDeAvion;
	}

	public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
		this.nombreTipoDeAvion = nombreTipoDeAvion;
	}

	public Integer getTotalAsientos() {
		return totalAsientos;
	}

	public void setTotalAsientos(Integer totalAsientos) {
		this.totalAsientos = totalAsientos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	};
	
}
