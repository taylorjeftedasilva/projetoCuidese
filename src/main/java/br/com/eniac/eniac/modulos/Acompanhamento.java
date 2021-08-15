package br.com.eniac.eniac.modulos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Acompanhamento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Usuario Paciente;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Enfermidade enfermidade;
	private String status;

	public Acompanhamento(Long id, Usuario paciente, Enfermidade enfermidade) {
		this.Paciente = paciente;
		this.enfermidade = enfermidade;
//		this.status = enfermidade.getTratamento().getGlicemia();
	}

	public void setStatus() {
//		this.status = enfermidade.getTratamento().getGlicemia();
	}

}
