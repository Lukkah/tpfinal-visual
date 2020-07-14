package ar.edu.unju.fi.trackpersonas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.service.IPersonaService;

@Controller
@RequestMapping
public class PersonaController {
	
	@Autowired
	IPersonaService personaService;

	@Autowired
	private Persona persona;
	
	@Autowired
	private Persona personaAux;
	
	@RequestMapping("/personas")
	public String getPersonas(Model model) {
		return "Personas";
	}
	
	/**
	 * Carga la pagina para el registro de personas
	 * @param model
	 * @return
	 */
	@GetMapping("/AltaPersona")
	public String agregar(Model model) {
		model.addAttribute("persona",persona);
		model.addAttribute("personaAux",personaAux);
		model.addAttribute("personas",personaService.listarPersonas());
		return "pruebaAlta";
	}
	
	/**
	 * Permite almacenar una persona
	 * @param persona
	 * @param model
	 * @return
	 */
	@PostMapping("/savePersona")
	public String guardar(@ModelAttribute Persona persona, Model model) {
		personaService.guardarPersona(persona);
		return agregar(model);
	}
	
	/**
	 * Permite obtener una persona en especifico
	 * @param personaAux
	 * @param model
	 * @return
	 */
	@PostMapping("/getPersona")
	public String getPersona(@ModelAttribute Persona personaAux, Model model) {
		this.personaAux=personaService.getPersonaByDni(personaAux.getDocumento());
		model.addAttribute(this.personaAux);
		return agregar(model);
	}

	
}
