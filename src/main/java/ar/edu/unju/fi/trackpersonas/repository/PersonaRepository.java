package ar.edu.unju.fi.trackpersonas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;
@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{
	
	/**
	 * Usa un string documento para la busqueda de una persona 
	 * @param documento
	 * @return un objeto Persona
	 */
	 Persona findByDocumento(String documento);
	
	// public List<Persona> findByRegistroTrakingFechaHoraBetweenAndLocalidad(LocalDateTime fechaHora1,LocalDateTime fechaHora2,Barrio localidad);

}
