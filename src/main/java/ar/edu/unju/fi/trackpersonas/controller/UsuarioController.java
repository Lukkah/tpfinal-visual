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
	
	/**
	 * Carga la pagina para la gestion de usuarios
	 * @param model
	 * @return
	 */
	@GetMapping("/gestionUsuarios")
	public String cargarGestion(Model model) {
		model.addAttribute("usuario", usuario);
		model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
		model.addAttribute("formTab", "active");
		return "usuarios";
	}
	
	/**
	 * Permite almacenar un usuario desde la vista
	 * @param usuario
	 * @param result
	 * @param model
	 * @return
	 */
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
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuario", usuario);
				model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
				model.addAttribute("formTab", "active");
			}
		}
	return "usuarios";
	}
	
	/**
	 * Cancela la operacion que se estaba realizando
	 * @param model
	 * @return
	 */
	@GetMapping("/cancelar")
	public String cancelarEditarUsuario(Model model) {
		return "redirect:/gestionUsuarios";
	}
	
	/**
	 * Prepara los datos de un usuario específico para su modificacion
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable(name="id") Long id,Model model) {
		Optional<Usuario> usuario= usuarioService.obtenerUsuario(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");
		
		return "usuarios";
	}
	
	/**
	 * Permite guardar datos modificados de un usuario
	 * @param usuario
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/editar")
	public String postEditarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("usuario",usuario);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		} else {
			try {
				usuarioService.modificar(usuario);
				model.addAttribute("usuario",this.usuario);
				model.addAttribute("listTab","active");
				model.addAttribute("editMode","false");
			}catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuario", usuario);
				model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
				model.addAttribute("formTab", "active");
				model.addAttribute("editMode","true");
			}
		}
		model.addAttribute("listarUsuarios", usuarioService.obtenerTodos());
		return cargarGestion(model);
	}
	
	/**
	 * Elimina un usuario desde la vista
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable(name="id") Long id,Model model) {
		usuarioService.eliminarUsuario(id);
		return cargarGestion(model);
	}
	
}
