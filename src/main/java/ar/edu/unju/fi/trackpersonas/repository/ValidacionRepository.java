package ar.edu.unju.fi.trackpersonas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;

@Repository
public interface ValidacionRepository extends JpaRepository<ValidadorCondicionSanitaria, Long>{
	
	public List<ValidadorCondicionSanitaria> findByPersona(Persona persona);
	

}
