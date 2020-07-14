package ar.edu.unju.fi.trackpersonas.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.repository.PersonaRepository;
import ar.edu.unju.fi.trackpersonas.service.IPersonaService;

@Service
public class PersonaServiceImp implements IPersonaService {

	/**
	 * Objeto del repository que permite usar métodos de CrudRepository
	 */
	@Autowired
	private PersonaRepository personaRepository;
	
	/**
	 * Permite guardar un objeto Persona
	 */
	@Override
	public void guardarPersona(Persona persona) {
		personaRepository.save(persona);
		
	}
	
	/**
	 * Obtiene la lista de todos los objetos de tipo Persona
	 */
	@Override
	public List<Persona> listarPersonas() {
		return (List<Persona>) personaRepository.findAll();
	}

	/**
	 * Obtiene un objeto de tipo persona buscando por dni
	 */
	@Override
	public Persona getPersonaByDni(String dni) {
		return personaRepository.findByDocumento(dni);
	}


}
