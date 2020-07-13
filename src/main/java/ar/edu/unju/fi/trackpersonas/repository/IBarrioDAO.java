package ar.edu.unju.fi.trackpersonas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
/**
 * 
 * @author kry_m
 *
 */
public interface IBarrioDAO extends JpaRepository<Barrio, Long>{
	public Optional <Barrio> findByNombre(String nombre); 
}
