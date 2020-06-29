package ar.edu.unju.fi.trackpersonas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@RequestMapping("/personas")
	public String getPersonas(Model model) {
		return "Personas";
	}
	
	@GetMapping("/AltaPersonas")
	public String agregar(Model model) {
		model.addAttribute("persona",persona);
		return "personaForm";
	}
	
	@PostMapping("/savePersona")
	public String guardar(@Valid Persona persona, Model model) {
		personaService.guardarPersona(persona);
		return "redirect:/personas";
	}

	
}
