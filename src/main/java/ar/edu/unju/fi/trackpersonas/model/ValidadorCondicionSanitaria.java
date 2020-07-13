/**
 * paquetes necesarios
 */
package ar.edu.unju.fi.trackpersonas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author GRUPO 3
 *Creacion de la clase ValidadorCondicionSanitaria
 */
@Component
@Entity
@Table(name = "validaciones")
public class ValidadorCondicionSanitaria implements Serializable{
	private static final long serialVersionUID = 1L;

	//variables miembro
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Autowired
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "PERSONA_ID")
	private Persona persona;
	
	@Column(name = "USA_TAPABOCA", nullable = false)
	private Boolean usaTapaboca;
	
	@Column(name = "CUMPLE_TERMINACION_DNI", nullable = false)
	private Boolean cumpleTerminacionDni;
	
	@Column(name = "POSEE_PERMISO_CIRCULACION", nullable = false)
	private Boolean poseePermisoCirculacion;
	
	@Column(name = "ESTA_ACOMPANIADO", nullable = false)
	private Boolean estaAcompaniado;

	
	//Constructors
	
	/**
	 * constructor 
	 */
	public ValidadorCondicionSanitaria() {
		
	}

	/**
	 * @param persona
	 * @param usaTapaboca
	 * @param cumpleTerminacionDNI
	 * @param poseePermisoCirculacion
	 * @param estaAcompaniado
	 */
	public ValidadorCondicionSanitaria(Persona persona, Boolean usaTapaboca, Boolean cumpleTerminacionDNI,
			Boolean poseePermisoCirculacion, Boolean estaAcompaniado) {
		this.persona = persona;
		this.usaTapaboca = usaTapaboca;
		this.cumpleTerminacionDni = cumpleTerminacionDNI;
		this.poseePermisoCirculacion = poseePermisoCirculacion;
		this.estaAcompaniado = estaAcompaniado;
	}
	


	//GETTERS AND SETTERS
	
	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the usaTapaboca
	 */
	public Boolean getUsaTapaboca() {
		return usaTapaboca;
	}

	/**
	 * @param usaTapaboca the usaTapaboca to set
	 */
	public void setUsaTapaboca(Boolean usaTapaboca) {
		this.usaTapaboca = usaTapaboca;
	}

	/**
	 * @return the cumpleTerminacionDNI
	 */
	public Boolean getCumpleTerminacionDNI() {
		return cumpleTerminacionDni;
	}

	/**
	 * @param cumpleTerminacionDNI the cumpleTerminacionDNI to set
	 */
	public void setCumpleTerminacionDNI(Boolean cumpleTerminacionDNI) {
		this.cumpleTerminacionDni = cumpleTerminacionDNI;
	}

	/**
	 * @return the poseePermisoCirculacion
	 */
	public Boolean getPoseePermisoCirculacion() {
		return poseePermisoCirculacion;
	}

	/**
	 * @param poseePermisoCirculacion the poseePermisoCirculacion to set
	 */
	public void setPoseePermisoCirculacion(Boolean poseePermisoCirculacion) {
		this.poseePermisoCirculacion = poseePermisoCirculacion;
	}

	/**
	 * @return the estaAcompaniado
	 */
	public Boolean getEstaAcompaniado() {
		return estaAcompaniado;
	}

	/**
	 * @param estaAcompaniado the estaAcompaniado to set
	 */
	public void setEstaAcompaniado(Boolean estaAcompaniado) {
		this.estaAcompaniado = estaAcompaniado;
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
