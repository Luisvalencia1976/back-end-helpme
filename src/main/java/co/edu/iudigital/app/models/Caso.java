package co.edu.iudigital.app.models;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Column;

//***@Entity ALMACENA EL OBJETO ANOTADO COMO UNA ENTIDAD JPA***//
//***@Table HACE REFERENCIA A LA TABLA  DE LA BD***//
//***LA SERIALIZACION DE OBJETOS  SE USA PARA CONVERTIRLOS EN BYTES
//Y LUEGO ALMACENARLOS EN LA MEMORIA PERSISTENTE***//
@Entity
@Table(name = "casos")

public class Caso implements Serializable{
//***serialVersionUID SE USA PARA RECORDAR LAS VERSIONES DE UNA CLASE Serializable***//
	private static final long serialVersionUID = 1L;
    //**@id ES LA CLAVE PRINCIPAL DE LA IDENTIDAD CREADA***//
    //***@GeneratedValue SE USA PARA GENERAR VALORES AUTOINCREMENTALES DE LA LLAVE PRIMARIA***//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//**@Column NOS PERMITIR DEFINIR PARAMETROS DE UN ATRIBUTO***//	
	@Column(name = "fecha_hora")
	private LocalDateTime fechaHora;
	
	private float latitud;
	
	private float longitud;
	
	private float altitud;
	
	private Boolean visible;

	private String descripcion;
	
	@Column(name = "url_map")
	private String urlMap;
	
	@Column(name = "rmi_map")
	private String rmiMap;
	
	//***RELACION DE  MUCHOS A UNO***//
	@ManyToOne
	
	//***@JoinColumn ES UNA CLAVE PRINCIPAL***//
	@JoinColumn(name = "usuarios_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "delitos_id")
	private Delito delito;
	
	@PrePersist
	public void prePersist() {
		if(fechaHora == null) {
			fechaHora = LocalDateTime.now();
		}
	}

	//*********GETTER AND SETTERS********//
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	
	public float getLatitud() {
		return latitud;
	}

	
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	
	public float getLongitud() {
		return longitud;
	}

	
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	
	public Boolean getVisible() {
		return visible;
	}

	
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public String getUrlMap() {
		return urlMap;
	}

	
	public void setUrlMap(String urlMap) {
		this.urlMap = urlMap;
	}

	
	public String getRmiMap() {
		return rmiMap;
	}

	
	public void setRmiMap(String rmiMap) {
		this.rmiMap = rmiMap;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public Delito getDelito() {
		return delito;
	}

	
	public void setDelito(Delito delito) {
		this.delito = delito;
	}

	public float getAltitud() {
		return altitud;
	}

	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}

	
	
}