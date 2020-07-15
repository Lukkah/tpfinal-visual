package ar.edu.unju.fi.trackpersonas.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;
import ar.edu.unju.fi.trackpersonas.model.Usuario;
import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;
import ar.edu.unju.fi.trackpersonas.service.IBarrioService;
import ar.edu.unju.fi.trackpersonas.service.IPersonaService;
import ar.edu.unju.fi.trackpersonas.service.IRegistroService;
import ar.edu.unju.fi.trackpersonas.service.IUsuarioService;
import ar.edu.unju.fi.trackpersonas.service.IValidacionService;

@Controller
@RequestMapping
public class ConsultaController {
	
	@Autowired
	Barrio barrio;
	
	@Autowired
	Persona persona;
	
	@Autowired
	ValidadorCondicionSanitaria validadorCondicionSanitaria;
	
	@Autowired
	IBarrioService barrioService;
	
	@Autowired
	IRegistroService registroService;
	
	@Autowired
	IValidacionService validadorService;
	
	@Autowired
	IPersonaService personaService;
	
	@Autowired
	RegistroTracking registro;
	
	@Autowired
	RegistroTracking registroAux;
	
	LocalDateTime desde;
	LocalDateTime hasta;
	
	
	List<Persona> personas = new ArrayList<Persona>();
	List<Persona> personas2 = new ArrayList<Persona>();
	@RequestMapping("/personasLocalidad")
	public String obtenerUsuarios(Model model) {
		return "personasLocalidad";
	}
	/**
	 * Carga la pagina para la gestion de usuarios
	 * @param model
	 * @return
	 */
	@GetMapping("/obtenerPersonasLocalidad")
	public String cargarCampos(Model model) {
		model.addAttribute("localidades",barrioService.obtenerBarrios());
		model.addAttribute("barrio",barrio);
		model.addAttribute("personas", personas2=obtenerPersonasPorLocalidadHoraFecha());
		model.addAttribute("registro", registro);
		model.addAttribute("registroAux", registroAux);
		return "personasLocalidad";
	}
	
	public ValidadorCondicionSanitaria asignacionPersona(Long validador){
			validadorCondicionSanitaria=validadorService.buscarPorId(validador);
			persona = personaService.obtenerPersonaId(validadorCondicionSanitaria.getPersona().getId()).get();
			validadorCondicionSanitaria.setPersona(persona);
			personas.add(persona);
			return validadorCondicionSanitaria;
	}
	
	public List<Persona> obtenerPersonasPorLocalidadHoraFecha(){
		
		for (RegistroTracking registro : registroService.obtenerRegistroEntreFechasLocalidad(LocalDateTime.of(2020, 6, 15, 00, 19,47), LocalDateTime.of(2020, 7, 15, 21, 21, 00),barrioService.obtenerBarrioNombre("Tilcara"))) {
			for (ValidadorCondicionSanitaria validador : registro.getValidaciones()) {
				validador= asignacionPersona(validador.getId());
			}
		}
		
		return personas;
	}
	
//	//@PostMapping("/guardarDatos")
//	public String guardarDatos(@Valid @ModelAttribute RegistroTracking registroAux, Model model) {
//		//for (RegistroTracking registro : registroService.obtenerRegistroEntreFechasLocalidad(LocalDateTime.of(2020, 6, 15, 00, 19,47), LocalDateTime.of(2020, 7, 15, 21, 21, 00),registroAux.getLocalidad())) {
//			//for (ValidadorCondicionSanitaria validador : registro.getValidaciones()) {
//				//validador= asignacionPersona(validador.getId());
//			//}
//		//}
//		model.addAttribute(personas2=obtenerPersonasPorLocalidadHoraFecha(registroAux.getLocalidad()));
//		//model.addAttribute(personas);
//	
//		
//		return cargarCampos(model);
//	}
	
	
	
	


}
