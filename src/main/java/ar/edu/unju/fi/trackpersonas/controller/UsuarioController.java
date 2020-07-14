package ar.edu.unju.fi.trackpersonas.controller;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String obtenerUsuarios(Model model) {
		return "usuarios";
	}
	
	@GetMapping("/gestionUsuarios")
	public String cargarGestion(Model model) {
		model.addAttribute("usuario", usuario);
		model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
		model.addAttribute("formTab", "active");
		return "usuarios";
	}
	
	@PostMapping("/saveUsuario")
	public String guardar(@Valid @ModelAttribute Usuario usuario,  BindingResult result, Model model) {
		// agregado Valid (en el modelo tambien) y BindingResult
		if (result.hasErrors()) {
			// si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("usuario", usuario);
			model.addAttribute("formTab", "active");
			
			} else {
			try {
				usuarioService.guardarUsuario(usuario);
				//model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
				model.addAttribute("formTab", "active");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuario", usuario);
				model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
				model.addAttribute("formTab", "active");
			}
		}
	return cargarGestion(model);
	}
	@GetMapping("/cancelar")
	public String cancelarEditarUsuario(Model model) {
		return "redirect:/formulario";
	}
	
	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable(name="id") Long id,Model model) {
		Optional<Usuario> usuario= usuarioService.obtenerUsuario(id);
		model.addAttribute("usuario", usuario);
		return cargarGestion(model);
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable(name="id") Long id,Model model) {
		usuarioService.eliminarUsuario(id);
		return cargarGestion(model);
	}
	
}
