package ar.edu.unju.fi.trackpersonas.service;

import java.util.Optional;

import ar.edu.unju.fi.trackpersonas.model.Usuario;

public interface IUsuarioService {
	
	public void guardarUsuario(Usuario unUsuario);
	public void eliminarUsuario(Long id);
	public Optional<Usuario> obtenerUsuario(Long id) ;
	public Iterable<Usuario> obtenerTodos();
	public Usuario modificar(Usuario usuario);
}
