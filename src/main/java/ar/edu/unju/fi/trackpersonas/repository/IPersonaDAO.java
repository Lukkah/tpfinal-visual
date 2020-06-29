package ar.edu.unju.fi.trackpersonas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.trackpersonas.model.Persona;

public interface IPersonaDAO extends JpaRepository<Persona, Long>{

}
