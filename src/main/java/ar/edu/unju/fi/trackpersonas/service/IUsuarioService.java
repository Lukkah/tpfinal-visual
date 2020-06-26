package ar.edu.unju.fi.trackpersonas.service;

import ar.edu.unju.fi.trackpersonas.model.Usuario;

public interface IUsuarioService {
	
	public void guardarUsuario();
	public Usuario mostrarUsuario();
	public void eliminarUsuario();
	public Usuario modificarUsuario();
	

}
