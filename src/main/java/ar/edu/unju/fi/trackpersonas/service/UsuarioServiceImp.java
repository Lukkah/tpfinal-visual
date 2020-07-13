package ar.edu.unju.fi.trackpersonas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Usuario;
import ar.edu.unju.fi.trackpersonas.repository.IUsuarioDAO;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDaoImp;
	@Override
	public void guardarUsuario(Usuario unUsuario) {
		String pw= unUsuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unUsuario.setPassword(bCryptPasswordEncoder.encode(pw));
		usuarioDaoImp.save(unUsuario);	
	}
	@Override
	public void eliminarUsuario(Long id) {
		usuarioDaoImp.deleteById(id);
		
	}
	@Override
	public Optional<Usuario> obtenerUsuario(Long id)  {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario= usuarioDaoImp.findById(id);
		return usuario;
	}
	@Override
	public Iterable<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		return usuarioDaoImp.findAll();
	}
	@Override
	public Usuario modificar(Usuario unUsuario){
		// TODO Auto-generated method stub
		Optional<Usuario> usuarioGuardar = obtenerUsuario(unUsuario.getId());
		mapearUsuario(unUsuario, usuarioGuardar.get());		
		return usuarioDaoImp.save(usuarioGuardar.get());
	}
	
	public void mapearUsuario(Usuario desde, Usuario hacia) {
		hacia.setNombreUsuario(desde.getNombreReal());
		hacia.setApellidoReal(desde.getApellidoReal());
		hacia.setNombreReal(desde.getNombreReal());
		hacia.setPassword(desde.getPassword());
	}
}
