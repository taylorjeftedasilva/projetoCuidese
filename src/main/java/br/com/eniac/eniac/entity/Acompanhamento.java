package br.com.eniac.eniac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acompanhamento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Usuario usuario;
	@ElementCollection(targetClass=Lancamentos.class)
	private List<Lancamentos> lancamentos;

}
