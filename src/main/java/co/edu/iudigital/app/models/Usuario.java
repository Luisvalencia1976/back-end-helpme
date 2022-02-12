package co.edu.iudigital.app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	//**@id ES LA CLAVE PRINCIPAL DE LA IDENTIDAD CREADA***//
	//***@GeneratedValue SE USA PARA GENERAR VALORES AUTOINCREMENTALES DE LA LLAVE PRIMARIA***//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//***@NotEmpty,@NotNull SON ANOTACIONES USADAS PARA VALIDAR QU LOS CAMPOS SEAN REQUERIDOS***//
	//**@Column NOS PERMITIR DEFINIR PARAMETROS DE UN ATRIBUTO***//	
	@NotEmpty(message = "Email es obligatorio")
	@Email(message = "Debe ingresar un email válido")
	@Column(unique = true, length = 120)
	private String username;
	
	@Column(length = 120)
	private String password;
	
	@NotEmpty(message = "nombre es obligatorio")
	@Column(nullable = false, length = 120)
	private String nombre;
	//***@Size ES UNA ANOTACION QUE ESTABLECE UN RANGO DETERMINADO***//
	@NotEmpty(message = "apellido es obligatorio")
	@Size(min = 1, max = 12, message = "Fuera de rango")
	@Column(nullable = true, length = 120)
	private String apellido;
	
	@JsonProperty("fecha_nacimiento")
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	private Boolean enabled;
	
	@Column(name = "red_social")
	private Boolean redSocial;
	
	private String image;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "roles_usuarios",
	joinColumns = {@JoinColumn(name = "usuarios_id")},
	inverseJoinColumns = {@JoinColumn(name = "roles_id")})
	private List<Role> roles;

	//*********GETTER AND SETTERS********//
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApellido() {
		return apellido;
	}

	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	public Boolean getEnabled() {
		return enabled;
	}

	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	public Boolean getRedSocial() {
		return redSocial;
	}

	
	public void setRedSocial(Boolean redSocial) {
		this.redSocial = redSocial;
	}

	
	public String getImage() {
		return image;
	}

	
	public void setImage(String image) {
		this.image = image;
	}

	
	public List<Role> getRoles() {
		return roles;
	}

	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}