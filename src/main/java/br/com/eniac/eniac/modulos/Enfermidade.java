package br.com.eniac.eniac.modulos;

import br.com.eniac.eniac.modulos.tratamentos.DiabetesObservacoes;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Enfermidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Value("${stuff.nome:Diabetes}")
	private String nome;
	@OneToOne(cascade=CascadeType.PERSIST)
	private DiabetesObservacoes tratamento;
	
	
	public Enfermidade(DiabetesObservacoes tratamento) {
		this.nome = tratamento.NOME_ENFERMIDADE;
		this.tratamento = tratamento;
	}

	public DiabetesObservacoes getTratamento() {
		return tratamento;
	}
	public void setTratamento(DiabetesObservacoes tratamento) {
		this.tratamento = tratamento;
	}
}
