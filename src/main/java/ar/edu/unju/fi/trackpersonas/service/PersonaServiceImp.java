package ar.edu.unju.fi.trackpersonas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.repository.IPersonaDAO;

@Service
class PersonaServiceImp implements IPersonaService {
	
	@Autowired
	IPersonaDAO personaDaoImp;
	
	@Override
	public void guardarPersona(Persona persona) {
		personaDaoImp.save(persona);

	}

}
