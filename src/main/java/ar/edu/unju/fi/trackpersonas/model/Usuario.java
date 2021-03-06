package ar.edu.unju.fi.trackpersonas.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * Creacion de la clase Usuario   
 * con sus atributos
 * @author Grupo 3
 *
 */
@Component
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Declaracion de atributos o variables miembro
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotBlank(message = "nombre de usuario requerido")
	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;
	
	@NotBlank
	@Size(min=8, message = "Su contraseña debe tener minimo 8 caracteres")
	@Column(name="PASSWORD")
	private String password;
	
	@NotBlank(message = "Nombre real requerido")
	@Column(name="NOMBRE_REAL")
	private String nombreReal;
	
	@NotBlank(message = "Apellido requerido")
	@Column(name="APELLIDO_REAL")
	private String apellidoReal;
	
	@NotBlank(message = "seleccione un tipo de usuario")
	@Column(name="TIPO_USUARIO")
	private String tipoUsuario; 
	
	// Constructors
	public Usuario() {
		
	}

	/**
	 * @param nombreUsuario
	 * @param password
	 * @param nombreReal
	 * @param apellidoReal
	 * @param tipoUsuario
	 */
	public Usuario(String nombreUsuario, String password, String nombreReal, String apellidoReal, String tipoUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreReal = nombreReal;
		this.apellidoReal = apellidoReal;
		this.tipoUsuario = tipoUsuario;
	}
	
	//GETTERS AND SETTERS

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombreReal
	 */
	public String getNombreReal() {
		return nombreReal;
	}

	/**
	 * @param nombreReal the nombreReal to set
	 */
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	/**
	 * @return the apellidoReal
	 */
	public String getApellidoReal() {
		return apellidoReal;
	}

	/**
	 * @param apellidoReal the apellidoReal to set
	 */
	public void setApellidoReal(String apellidoReal) {
		this.apellidoReal = apellidoReal;
	}

	/**
	 * @return the tipoUsuario
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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


}
