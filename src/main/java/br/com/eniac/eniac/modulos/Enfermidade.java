package br.com.eniac.eniac.modulos;

import br.com.eniac.eniac.modulos.tratamentos.DiabetesObservacoes;

public class Enfermidade {
	private Long id;
	private final String nome;
	private DiabetesObservacoes tratamento;
	
	
	public Enfermidade(DiabetesObservacoes tratamento) {
		this.nome = tratamento.NOME_ENFERMIDADE;
		this.tratamento = tratamento;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public DiabetesObservacoes getTratamento() {
		return tratamento;
	}
	public void setTratamento(DiabetesObservacoes tratamento) {
		this.tratamento = tratamento;
	}
}
