package ar.ciu.bbdd.tp_cache_interna.dto;

public class AeropuertoDto {
	
	private String nombre;
	private String ciudad;
	private String pais;
	
	public AeropuertoDto() {};
	
	public AeropuertoDto(String nombre, String ciudad, String pais) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
