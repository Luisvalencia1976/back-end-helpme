package co.edu.iudigital.app.dto;

//LOS DTO  SIMPLIFICAN EL RENDIMIENTO  A TRAVES DE HTTP Y QUE ENVIAMOS MENOS INFORMACION//
public class DelitoDto {
	private Long id;
	private String nombre;
	private String descripcion;
	
	//*********GETTER AND SETTERS********//
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
