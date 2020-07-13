package ar.edu.unju.fi.trackpersonas.service;

import java.util.List;

import ar.edu.unju.fi.trackpersonas.model.Persona;

public interface IPersonaService {
	
	public void guardarPersona(Persona persona);
	
	List <Persona> listarPersonas();
	
	Persona getPersonaByDni(String dni);

}
