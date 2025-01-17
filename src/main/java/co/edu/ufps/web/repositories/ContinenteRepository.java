package co.edu.ufps.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.web.entities.Continente;

@Repository
public interface ContinenteRepository  extends JpaRepository <Continente, Integer>{

}
