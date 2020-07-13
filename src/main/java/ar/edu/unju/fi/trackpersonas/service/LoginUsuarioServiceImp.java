package ar.edu.unju.fi.trackpersonas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Usuario;
import ar.edu.unju.fi.trackpersonas.repository.IUsuarioRepository;

@Service
public class LoginUsuarioServiceImp implements UserDetailsService{
	
	@Autowired
	IUsuarioRepository iUsuario;

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
				//ojo si usan la clase User ya que spring security tiene una igual
				//Usuario usuario = iUsuario.findById(id);
				Usuario usuarioEncontrado = iUsuario.findByNombreUsuario(nombreUsuario).orElseThrow(()-> new UsernameNotFoundException("Datos invalidos"));
				
				List<GrantedAuthority> tipos = new ArrayList<>();
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario()); 
				tipos.add(grantedAuthority);
				
				UserDetails user = (UserDetails) new User(nombreUsuario, usuarioEncontrado.getPassword(),tipos);
				return user;
	}

}
