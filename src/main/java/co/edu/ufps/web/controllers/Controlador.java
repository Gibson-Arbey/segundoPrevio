package co.edu.ufps.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.web.entities.Continente;
import co.edu.ufps.web.repositories.ContinenteRepository;

@Controller
@RequestMapping("/")
public class Controlador {
	
	@Autowired
	private ContinenteRepository continenteRepository;
	
	@GetMapping
	public String redireccionar(Model model) {
		List<Continente> continentes = continenteRepository.findAll();
		model.addAttribute("continentes", continentes);
		return "redirect:/selecciones";
	}
}
