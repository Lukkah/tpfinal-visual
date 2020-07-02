package ar.edu.unju.fi.trackpersonas.service;

import java.util.List;

import ar.edu.unju.fi.trackpersonas.model.Usuario;

public interface IUsuarioService {
	
	public void guardarUsuario(Usuario unUsuario);
	public void eliminarUsuario(Long id);
	public Usuario modificarUsuario(Usuario unUsuario) throws Exception;
	public Usuario mostrarUsuario(Long id) throws Exception;
	public List<Usuario> obtenerTodos();

}
