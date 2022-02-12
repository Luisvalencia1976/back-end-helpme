package co.edu.iudigital.app.models;
//***LIBRERIAS***//
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//***@Entity ALMACENA EL OBJETO ANOTADO COMO UNA ENTIDAD JPA***//
//***@Table HACE REFERENCIA A LA TABLA  DE LA BD***//
//***LA SERIALIZACION DE OBJETOS  SE USA PARA CONVERTIRLOS EN BYTES
//Y LUEGO ALMACENARLOS EN LA MEMORIA PERSISTENTE***//

@Entity
@Table(name = "delitos")
public class Delito implements Serializable{

//***serialVersionUID SE USA PARA RECORDAR LAS VERSIONES DE UNA CLASE Serializable***//
	private static final long serialVersionUID = 1L;
	
//**@id ES LA CLAVE PRINCIPAL DE LA IDENTIDAD CREADA***//
//***@GeneratedValue SE USA PARA GENERAR VALORES AUTOINCREMENTALES DE LA LLAVE PRIMARIA***//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//***@NotEmpty,@NotNull SON ANOTACIONES USADAS PARA VALIDAR QU LOS CAMPOS SEAN REQUERIDOS***//
//**@Column NOS PERMITIR DEFINIR PARAMETROS DE UN ATRIBUTO***//	
	@NotEmpty
	@NotNull
	@Column(nullable = false, length = 45)
	private String nombre;
	
	@Column(nullable = true, length = 120)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "usuarios_id")
	private Usuario usuario;
	
	
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

	
	public Usuario getUsuario() {
		return usuario;
	}

	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
