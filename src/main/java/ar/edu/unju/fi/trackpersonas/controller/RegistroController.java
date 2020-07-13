package ar.edu.unju.fi.trackpersonas.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;
import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;
import ar.edu.unju.fi.trackpersonas.service.IBarrioService;
import ar.edu.unju.fi.trackpersonas.service.IPersonaService;
import ar.edu.unju.fi.trackpersonas.service.IRegistroService;
import ar.edu.unju.fi.trackpersonas.service.IValidacionService;

@Controller
public class RegistroController {

	@Autowired
	private IValidacionService validacionService;
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IRegistroService registroService;
	
	@Autowired
	private IBarrioService barrioService;

	@Autowired
	Persona persona;
	
	@Autowired
	ValidadorCondicionSanitaria validacion;

	@Autowired
	RegistroTracking registro;

	@Autowired
	Barrio barrio;
	

	List<ValidadorCondicionSanitaria> validaciones = new ArrayList<ValidadorCondicionSanitaria>();
	
	
	@GetMapping("/createRegistro")
	public String crearValidacion(Model model) {
		List<Barrio> localidades = barrioService.obtenerBarrios();
		model.addAttribute("localidades",localidades);
		model.addAttribute("persona",persona);
		model.addAttribute("validacion",validacion);
		model.addAttribute("registro",registro);
		model.addAttribute("barrio",barrio);
		return "RegistroForm";
	}

	@PostMapping("/saveValidacionRegistro")
	public String guardarValidacion(@ModelAttribute ValidadorCondicionSanitaria validacion) {
		validaciones.add(validacion);
		validacionService.guardarValidacion(validacion);
		System.out.println("Validacion guardada");
		return "redirect:/createRegistro";
	}
	
	
	@PostMapping("/getPersonaRegistro")
	public String getPersonaValidacion(@ModelAttribute Persona personaAux, Model model) {
		this.persona = new Persona();
		this.persona=personaService.getPersonaByDni(personaAux.getDocumento());
		this.validacion.setPersona(this.persona);
		model.addAttribute("validacion",validacion);
		model.addAttribute("registro",registro);
		//return "RegistroForm";
		return cargarPersonaEcontrada(model);
	}
	
	@GetMapping("/guardarValidacionRegistro")
	public String cargarPersonaEcontrada(Model model) {
		
		return "RegistroForm";
	}
	
//	@PostMapping("/getBarrio")
//	public String getPersonaValidacion(@ModelAttribute Barrio barrioM, Model model) {
//		this.barrio = new Barrio();
//		this.barrio=barrioService.obtenerBarrioNombre(barrioM.getNombre());
//		this.registro.setLocalidad(barrioM);
//		model.addAttribute("registro",registro);
//		//return "RegistroForm";
//		return cargarBarrioEcontrado(model) ;
//
//	}
	
	
	@PostMapping("/saveRegistro")
	public String guardarRegistro(@ModelAttribute RegistroTracking registro) {
		registro.setFechaHora(LocalDateTime.now());
		registro.setValidaciones(validaciones);
		registroService.guardarRegistro(registro);
		System.out.println("Registro guardado");
		return "redirect:/createRegistro";
	}
	
}
