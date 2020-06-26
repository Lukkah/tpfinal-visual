package ar.edu.unju.fi.trackpersonas.repository;

import ar.edu.unju.fi.trackpersonas.model.Usuario;

public interface IUsuarioDAO {
	
	public void guardarUsuario();
	public Usuario mostrarUsuario();
	public void eliminarUsuario();
	public Usuario modificarUsuario();
}
