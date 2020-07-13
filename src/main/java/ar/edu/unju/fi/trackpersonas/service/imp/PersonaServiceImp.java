package ar.edu.unju.fi.trackpersonas.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.repository.PersonaRepository;
import ar.edu.unju.fi.trackpersonas.service.IPersonaService;

@Service
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public void guardarPersona(Persona persona) {
		personaRepository.save(persona);
		
	}
	
	@Override
	public List<Persona> listarPersonas() {
		return (List<Persona>) personaRepository.findAll();
	}

	@Override
	public Persona getPersonaByDni(String dni) {
		return personaRepository.findByDocumento(dni);
	}


}
