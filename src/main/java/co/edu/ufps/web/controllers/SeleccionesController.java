package co.edu.ufps.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import co.edu.ufps.web.entities.Continente;
import co.edu.ufps.web.entities.Seleccion;
import co.edu.ufps.web.repositories.ContinenteRepository;
import co.edu.ufps.web.repositories.SeleccionRepository;
import javax.validation.Valid;

@Controller
@RequestMapping("/selecciones")
public class SeleccionesController {

	@Autowired
	private SeleccionRepository seleccionRepository;
	
	@Autowired
	private ContinenteRepository continenteRepository;
	
	@GetMapping
	public String listar(Model model) {
		
		   List<Seleccion> selecciones = seleccionRepository.findAll();
        
        	model.addAttribute("selecciones", selecciones);
        	return "index";
		 
	}
	
	@GetMapping("/form")
    public String mostrar(@RequestParam(value = "id", required = false) Integer id, Model model) {
		Seleccion seleccion = new Seleccion();
		
		if(id != null) {
			seleccion = seleccionRepository.findById(id).get();
		}
		List<Continente> continentes = continenteRepository.findAll();
		model.addAttribute("continentes", continentes);
		model.addAttribute("selecciones", seleccion);
        return "nuevo";
    }
	
	@PostMapping("/agregar")
	public String agregar(@Valid Seleccion seleccion, BindingResult result) {
		if (result.hasErrors()) {
            return "nuevo";
        }
		seleccionRepository.save(seleccion);
		
		return "redirect:/selecciones";
	}
	
	@GetMapping("/editar")
	public String actualizar(@RequestParam("id") int id, @ModelAttribute("selecciones") Seleccion seleccionActualizada, BindingResult result) {
		Seleccion seleccion = seleccionRepository.findById(id)
             .orElseThrow(() -> new IllegalArgumentException("Seleccion no encontrada con id: " + id));
		seleccion.setNombre(seleccionActualizada.getNombre());
		seleccion.setContinente(seleccionActualizada.getContinente());
		seleccion.setGrupo(seleccionActualizada.getGrupo());
		
        seleccionRepository.save(seleccion);
	    return "redirect:/selecciones"; 
	}
	
	@GetMapping("/borrar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {

        Seleccion seleccion = seleccionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Seleccion no encontrada con id: " + id));
        seleccionRepository.delete(seleccion);
        return "redirect:/selecciones";
    }
	
}
