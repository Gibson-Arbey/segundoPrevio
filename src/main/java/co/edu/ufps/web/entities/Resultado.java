package co.edu.ufps.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resultado")
public class Resultado {

	@Id
	@SequenceGenerator(name="resultado_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="resultado_id_seq")
	private Integer id;
	
	@JsonIgnore
    @ManyToOne
	@JoinColumn(name="partido_id")
    private Partido partido;

    @ManyToOne
	@JoinColumn(name="seleccion_id")
    private Seleccion seleccion;
    
	private Integer goles;
	
	private Integer amarrillas;
	
	private Integer rojas;
}
