package ar.edu.unju.fi.trackpersonas.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;
import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;
import ar.edu.unju.fi.trackpersonas.service.IBarrioService;
import ar.edu.unju.fi.trackpersonas.service.IPersonaService;
import ar.edu.unju.fi.trackpersonas.service.IRegistroService;
import ar.edu.unju.fi.trackpersonas.service.IValidacionService;

@Controller
@RequestMapping
public class RecorridoController {
	
	@Autowired
	private IRegistroService registroService;
	

	@Autowired
	Persona persona;
	
	@Autowired
	ValidadorCondicionSanitaria validacion;

	@Autowired
	RegistroTracking registro;


	List<RegistroTracking> registros = new ArrayList<RegistroTracking>();

	@Autowired
	Barrio barrio;
	
	
	@GetMapping("/consutaRecorrido")
	public String crearValidacion(Model model) {
		model.addAttribute("persona",persona);
		model.addAttribute("validacion",validacion);
		model.addAttribute("registros",registros);
		model.addAttribute("barrio",barrio);
		return "personaRecorridohtml";
	}
	
	
	
	@PostMapping("/buscarPersonaCosulta")
	public String consultarRecorrido(@ModelAttribute Persona persona, Model model){
		registros = registroService.buscarPersonas(persona);
		model.addAttribute(registros);
		return crearValidacion(model);
	}

}
