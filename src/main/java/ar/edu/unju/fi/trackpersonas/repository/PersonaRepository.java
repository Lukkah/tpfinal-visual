package ar.edu.unju.fi.trackpersonas.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.trackpersonas.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona,Long>{
	
	 @Query("select p from Persona p where p.documento = :dni ")
	  Persona findByDNI(String dni);
	 
	 Persona findByDocumento(String documento);
	 
	  

}
