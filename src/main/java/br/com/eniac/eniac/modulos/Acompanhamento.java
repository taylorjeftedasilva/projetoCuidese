package br.com.eniac.eniac.modulos;

public class Acompanhamento {
	
	private Long id;
	private Usuario Paciente;
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
