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
@Table(name = "tipo_de_avion")
public class TipoDeAvion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "nombre")
	private String nombre;
	private String empresa;
	@Column(name = "cantidad_maxima_de_asientos")
	private Integer maximoAsientos;
	
	public TipoDeAvion() {};
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombreTipoAvion) {
		this.nombre = nombreTipoAvion;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getMaximoAsientos() {
		return maximoAsientos;
	}
	public void setMaximoAsientos(Integer maximoAsientos) {
		this.maximoAsientos = maximoAsientos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
