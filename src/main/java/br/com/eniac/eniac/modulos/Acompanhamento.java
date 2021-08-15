package br.com.eniac.eniac.modulos;

import javax.persistence.*;

@Entity
public class Acompanhamento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Usuario Paciente;
	@OneToOne
	private Enfermidade enfermidade;
	private String status;
	
	public String getStatus() {
		return status;
	}


	public void setStatus() {
		this.status = enfermidade.getTratamento().getGlicemia();
	}


	public Acompanhamento(Long id, Usuario paciente, Enfermidade enfermidade) {
		this.Paciente = paciente;
		this.enfermidade = enfermidade;
		this.status = enfermidade.getTratamento().getGlicemia();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getPaciente() {
		return Paciente;
	}
	public void setPaciente(Usuario paciente) {
		Paciente = paciente;
	}
	public Enfermidade getEnfermidade() {
		return enfermidade;
	}
	public void setEnfermidade(Enfermidade enfermidade) {
		this.enfermidade = enfermidade;
	}
	

}
