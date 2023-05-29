package co.edu.ufps.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import co.edu.ufps.web.entities.Seleccion;
import co.edu.ufps.web.repositories.SeleccionRepository;

@Controller
@RequestMapping("/selecciones")
public class SeleccionesController {

	@Autowired
	private SeleccionRepository seleccionRepository;
	
	@GetMapping
	public String listar(Model model) {
		
		   List<Seleccion> selecciones = seleccionRepository.findAll();
        
        	model.addAttribute("selecciones", selecciones);
        	return "index";
		 
	}
	
	@PostMapping
	public String agregar() {
		return "";
	}
}
