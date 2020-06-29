package ar.edu.unju.fi.trackpersonas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Usuario;
import ar.edu.unju.fi.trackpersonas.repository.IUsuarioDAO;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDaoImp;
	@Override
	public void guardarUsuario(Usuario unUsuario) {
		usuarioDaoImp.save(unUsuario);
		
	}

}
