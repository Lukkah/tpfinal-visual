package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ar.edu.unju.fi.trackpersonas.model.Usuario;
import ar.edu.unju.fi.trackpersonas.service.IUsuarioService;

@SpringBootApplication
public class TpFinalGrupo3Application implements CommandLineRunner{
	@Autowired
	Usuario usuario;
	
	@Autowired
	IUsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(TpFinalGrupo3Application.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		// inicializo las las variables de mi objeto usuario
		//usuario.setApellidoReal("root");
		//usuario.setPassword("12345678");
		//usuario.setNombreUsuario("root");
		//usuario.setNombreReal("root");
		//usuario.setTipoUsuario("DB");
		//usuarioService.guardarUsuario(usuario);
	}
}
