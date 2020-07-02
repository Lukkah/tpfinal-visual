package ar.edu.unju.fi.trackpersonas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * Clase de registo de personas
 * @author Fernando
 *
 */
@Component
@Entity
@Table(name = "registros")
public class RegistroTracking implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Variables miembro
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID",nullable = false)
	private Long id;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime fechaHora;
	
	@Autowired
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "LOCALIDAD_ID")
	private Barrio localidad;
	

	@Column(name = "DETALLE_REGISTRO", nullable = false)
	private String detalleLugarRegistro;
	
	@ManyToMany
	@JoinTable(name = "validaciones_registros",
	joinColumns = @JoinColumn(name = "REGISTROTRACKING_ID"),
	inverseJoinColumns = @JoinColumn(name = "VALIDADORCONDICIONSANITARIA_ID"))
	private List<ValidadorCondicionSanitaria> validaciones = new ArrayList<ValidadorCondicionSanitaria>();
	
	//Constructores--------------------------------------------------------------------
	/**
	 * Constructor por defecto
	 */
	public RegistroTracking() {
		
	}
	
	//Metodos accesores----------------------------------------------------------------

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
	 * @return the localidad
	 */
	public Barrio getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(Barrio localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the detalleLugarRegistro
	 */
	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	/**
	 * @param detalleLugarRegistro the detalleLugarRegistro to set
	 */
	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	
	
	
}
