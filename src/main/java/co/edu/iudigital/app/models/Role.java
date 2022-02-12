package co.edu.iudigital.app.models;

//***LIBRERIAS***//
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//***@Entity ALMACENA EL OBJETO ANOTADO COMO UNA ENTIDAD JPA***//
//***@Table HACE REFERENCIA A LA TABLA  DE LA BD***//
//***LA SERIALIZACION DE OBJETOS  SE USA PARA CONVERTIRLOS EN BYTES
//Y LUEGO ALMACENARLOS EN LA MEMORIA PERSISTENTE***//
@Entity
@Table(name = "roles")
public class Role implements Serializable{

	
	private static final long serialVersionUID = 1L;
	//**@id ES LA CLAVE PRINCIPAL DE LA IDENTIDAD CREADA***//
	//***@GeneratedValue SE USA PARA GENERAR VALORES AUTOINCREMENTALES DE LA LLAVE PRIMARIA***//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length = 45)
	private String nombre;
	
	@Column(nullable = true, length = 45)
	private String descripcion;
	
	//***@ManyToMany RELACION DE MUCHOS A MUCHOS ES BIDIRECCIONAL***//
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

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

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
