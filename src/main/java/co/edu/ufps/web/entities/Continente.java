package co.edu.ufps.web.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="continente")
public class Continente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  
    @Id
	@SequenceGenerator(name="continente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="continente_id_seq")
    private Integer id;

    private String nombre;
}
