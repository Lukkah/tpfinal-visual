package ar.edu.unju.fi.trackpersonas.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase de registo de personas
 * @author Fernando
 *
 */
@Component
public class RegistroTracking {
	//Variables miembro
	private LocalDateTime fechaHora;
	@Autowired
	private Barrio localidad;
	private List<Persona> personas;
	private String detalleLugarRegistro;
	
	//Constructores--------------------------------------------------------------------
	/**
	 * Constructor por defecto
	 */
	public RegistroTracking() {
	}

	
	//Metodos accesores----------------------------------------------------------------
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

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	
	
	
}
