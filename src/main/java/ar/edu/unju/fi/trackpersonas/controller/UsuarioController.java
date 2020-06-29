package ar.edu.unju.fi.trackpersonas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.trackpersonas.model.Usuario;
import ar.edu.unju.fi.trackpersonas.service.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	private Usuario usuario;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	@RequestMapping("/usuarios")
	public String getUsuarioForm(Model model) {
		return "usuarios";
	}
	@GetMapping("/altaUsuario")
	public String agregar(Model model) {
		model.addAttribute("usuario", usuario);
		return "usuariosForm";
	}
	@PostMapping("/saveUsuario")
	public String guardar(@Valid Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/usuarios";
		
		
	}
	
	
}
