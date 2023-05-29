package co.edu.ufps.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.web.entities.Partido;

@Repository
public interface PartidoRepository  extends JpaRepository <Partido, Integer>{

}
