package ar.edu.unju.fi.trackpersonas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
	
	@ManyToMany(fetch =FetchType.LAZY)
	@JoinTable(name = "validaciones_registros",
	joinColumns = @JoinColumn(name = "REGISTROTRACKING_ID"),
	inverseJoinColumns = @JoinColumn(name = "VALIDADORCONDICIONSANITARIA_ID"))
	private List<ValidadorCondicionSanitaria> validaciones;
	
	//Constructores--------------------------------------------------------------------
	/**
	 * Constructor por defecto
	 */
	public RegistroTracking() {
		
	}

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

	public Barrio getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Barrio localidad) {
		this.localidad = localidad;
	}

	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	public List<ValidadorCondicionSanitaria> getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(List<ValidadorCondicionSanitaria> validaciones) {
		this.validaciones = validaciones;
	}

	@Override
	public String toString() {
		return "RegistroTracking [id=" + id + ", fechaHora=" + fechaHora + ", localidad=" + localidad
				+ ", detalleLugarRegistro=" + detalleLugarRegistro + ", validaciones=" + validaciones + "]";
	}
	
	//Metodos accesores----------------------------------------------------------------

	
	
	
	
	
}
