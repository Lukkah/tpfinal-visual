package ar.edu.unju.fi.trackpersonas.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.trackpersonas.model.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {
	
}
