package co.edu.ufps.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class Controlador {
	

	
	@GetMapping
	public String redireccionar() {
		
		return "redirect:/selecciones";
	}
}
