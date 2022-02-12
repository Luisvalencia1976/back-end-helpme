package co.edu.iudigital.app.dto;

import java.time.LocalDateTime;

//LOS DTO SON UTILES CUANDO EL MODELO DE DOMINIO SE COMPONE DE MUCHOS OBJETOS//

public class CasoDto {
	
	private Long id;

	private LocalDateTime fechaHora;

	private float latitud;
	
	private float longitud;
	
	private float altitud;
	
	private Boolean visible;

	private String descripcion;

	private String urlMap;
	
	private String rmiMap;

	private Long usuarioId;

	private String image;
	
	private String nombre;
	
	//*********GETTER AND SETTERS********//
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the latitud
	 */
	public float getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public float getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the altitud
	 */
	public float getAltitud() {
		return altitud;
	}

	/**
	 * @param altitud the altitud to set
	 */
	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}
	/**
	 * @return the visible
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the urlMap
	 */
	public String getUrlMap() {
		return urlMap;
	}

	/**
	 * @param urlMap the urlMap to set
	 */
	public void setUrlMap(String urlMap) {
		this.urlMap = urlMap;
	}

	

	/**
	 * @return the usuarioId
	 */
	public Long getUsuarioId() {
		return usuarioId;
	}

	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public String getRmiMap() {
		return rmiMap;
	}

	public void setRmiMap(String rmiMap) {
		this.rmiMap = rmiMap;
	}
	
	
}