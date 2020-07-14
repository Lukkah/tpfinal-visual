package ar.edu.unju.fi.trackpersonas.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.trackpersonas.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona,Long>{
	
	/**
	 * Usa un string documento para la busqueda de una persona 
	 * @param documento
	 * @return un objeto Persona
	 */
	 Persona findByDocumento(String documento);
	 
	  

}
