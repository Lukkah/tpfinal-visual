package ar.edu.unju.fi.trackpersonas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Usuario;
import ar.edu.unju.fi.trackpersonas.repository.IUsuarioDAO;

@Service
public class IUsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO iUsuario;

	@Override
	public void guardarUsuario() {
		iUsuario.guardarUsuario();

	}

	@Override
	public Usuario mostrarUsuario() {
		Usuario usuario = iUsuario.mostrarUsuario();
		return usuario;
	}

	@Override
	public void eliminarUsuario() {
		iUsuario.eliminarUsuario();

	}

	@Override
	public Usuario modificarUsuario() {
		Usuario usuario= iUsuario.modificarUsuario();
		return usuario;
	}

}
