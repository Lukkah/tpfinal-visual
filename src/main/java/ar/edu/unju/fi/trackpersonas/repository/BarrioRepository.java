package ar.edu.unju.fi.trackpersonas.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.trackpersonas.model.Barrio;

/**
 * 
 * @author kry_m
 *
 */
public interface BarrioRepository extends CrudRepository<Barrio, Long>{
	
	/**
	 * Usa un string nombre para la busqueda de un barrio
	 * @param nombre
	 * @return un objeto Barrio
	 */
	public Barrio findByNombre(String nombre); 
}
