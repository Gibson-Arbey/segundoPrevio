package co.edu.ufps.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.web.entities.Seleccion;

@Repository
public interface SeleccionRepository  extends JpaRepository <Seleccion, Integer> {
	
	 public List<Seleccion> findByGrupo(String grupo);
}
