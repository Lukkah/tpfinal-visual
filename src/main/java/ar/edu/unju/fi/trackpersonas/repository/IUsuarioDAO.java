package ar.edu.unju.fi.trackpersonas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.trackpersonas.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	
}
