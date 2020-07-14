package ar.edu.unju.fi.trackpersonas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.service.IBarrioService;

/**
 * 
 * @author kry_m
 *ccm
 */
@Controller
@RequestMapping
public class BarrioController {

	@Autowired
	private IBarrioService barrioService;
	
	@Autowired
	private Barrio barrio;
	
	@RequestMapping("/barrios")
	public String obtenerBarrios(Model model) {
		return "barrios";
	}
	
	//@RequestMapping("/barrios")
	//public String getBarrios (Model model) {
	//	return "Barrios";
	//}
	
	/**
	 * Carga la página para la gestion de localidades
	 * @param model
	 * @return
	 */
	@GetMapping("/gestionLocalidades")
	public String agregar(Model model) {
		model.addAttribute("barrio",barrio);
		return "barrios";
	}
	
	/**
	 * Permite almacenar un barrio
	 * @param barrio
	 * @param model
	 * @return
	 */
	@PostMapping("/saveBarrio")
	public String guardar (@Validated Barrio barrio , Model model) {
		barrioService.guardarBarrio(barrio);
		return agregar(model);
	}
	
	
}
