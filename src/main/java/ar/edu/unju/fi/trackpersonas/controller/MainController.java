package ar.edu.unju.fi.trackpersonas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
	
	@RequestMapping("/home")
	public String main(Model model) {
		return "index";
	}
	@RequestMapping("/usuarios")
	public String obtenerUsuarios(Model model) {
		return "usuarios";
	}
	@RequestMapping("/barrios")
	public String obtenerBarrios(Model model) {
		return "barrios";
	}
	//@GetMapping({"/","/login"})
	//public String ingresar(Model model) {
		//return"login";
	//}
}
