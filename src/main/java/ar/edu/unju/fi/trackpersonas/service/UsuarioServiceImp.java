package ar.edu.unju.fi.trackpersonas.service;

import java.util.List;

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
	@Override
	public void eliminarUsuario(Long id) {
		usuarioDaoImp.deleteById(id);
		
	}
	@Override
	public Usuario modificarUsuario(Usuario unUsuario) throws Exception{
		Usuario usuarioGuardar= mostrarUsuario(unUsuario.getId());
		mapearUsuario(unUsuario, usuarioGuardar);
		return usuarioDaoImp.save(usuarioGuardar);
	}

	@Override
	public Usuario mostrarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioDaoImp.findById(id).orElseThrow(()->new Exception("el usuario no se encuentra"));
	}
	@Override
	public List<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		return usuarioDaoImp.findAll();
	}
	
	public void mapearUsuario(Usuario desde, Usuario hacia) {
		hacia.setApellidoReal(desde.getApellidoReal());
		hacia.setNombreReal(desde.getNombreReal());
		hacia.setNombreUsuario(desde.getNombreUsuario());
		hacia.setPassword(desde.getPassword());
		hacia.setTipoUsuario(desde.getTipoUsuario());
	}
	
}
