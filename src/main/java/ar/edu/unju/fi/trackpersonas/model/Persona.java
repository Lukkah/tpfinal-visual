package ar.edu.unju.fi.trackpersonas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Creacion de la clase Persona
 * @author kry_m  
 *
 */
@Entity
@Table(name ="personas")
public class Persona {
//Declaracion de atributos o variables miembro
	
	@Id
	@Column(name = "DOCUMENTO", nullable = true)
	private String documento;
	
	@Column(name="APELLIDO")
	private String apellido;
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "Nombres")
	private String nacionalidad;

//constructor por defecto
public Persona() {
	
}

/**
 * muestra el documento
 * @return the documento
 */
public String getDocumento() {
	return documento;
}

/**
 * se le puede asignar 
 * un numero de documento
 * @param documento the documento to set
 */
public void setDocumento(String documento) {
	this.documento = documento;
}

/**
 * devuelve el apellido
 * @return the apellido
 */
public String getApellido() {
	return apellido;
}

/**
 * se puede modificar el apellido
 * @param apellido the apellido to set
 */
public void setApellido(String apellido) {
	this.apellido = apellido;
}

/**
 * devuelve el nombre
 * @return the nombres
 */
public String getNombres() {
	return nombres;
}

/**
 * se puede modificar el nombre
 * @param nombres the nombres to set
 */
public void setNombres(String nombres) {
	this.nombres = nombres;
}

/**
 * devuelve la nacionalidad
 * @return the nacionalidad
 */
public String getNacionalidad() {
	return nacionalidad;
}

/**
 * se puede modificar la nacionalidad
 * @param nacionalidad the nacionalidad to set
 */
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}

}

