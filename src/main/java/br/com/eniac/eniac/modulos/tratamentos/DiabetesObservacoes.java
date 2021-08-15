package br.com.eniac.eniac.modulos.tratamentos;

import br.com.eniac.eniac.modulos.enums.StatusDiabetes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Entity
public class DiabetesObservacoes {
	public final String NOME_ENFERMIDADE = "DIABETES";
	private boolean jejum;
	@Enumerated(EnumType.STRING)
	private StatusDiabetes glicemia;
	private final int GLICEMIA_JEJUM_NORMAL = 99;
	private final int GLICEMIA_JEJUM_ALTERADO_INICIAL= 100;
	private final int GLICEMIA_JEJUM_ALTERADO_FINAL = 125;
	
	public DiabetesObservacoes (boolean jejum, int glicemia){
		this.jejum = jejum;
		setGlicemia(jejum, glicemia);
	}
	
	public void setJejum(boolean jejum) {
		this.jejum = jejum;
	}
	
	public boolean getJejum() {
		return jejum;
	}
	public String getGlicemia() {
		String resultadoTratado = String.valueOf(this.glicemia).replace("_", " ");
		return resultadoTratado;
	}
	private void setGlicemia(boolean jejum, int glicemia) {
			
			if(jejum && glicemia <= GLICEMIA_JEJUM_NORMAL ) {
				this.glicemia = StatusDiabetes.GLICEMIA_NORMAL;
			}
			else if(jejum && glicemia >= 
					GLICEMIA_JEJUM_ALTERADO_INICIAL & 
					glicemia <= GLICEMIA_JEJUM_ALTERADO_FINAL) {
				this.glicemia = StatusDiabetes.GLICEMIA_ALTERADA;
			}else if(jejum && glicemia >= 
					GLICEMIA_JEJUM_ALTERADO_INICIAL) {
				this.glicemia = StatusDiabetes.DIABETES;
			}
			else if(!jejum && glicemia <= 200) {
				this.glicemia = StatusDiabetes.GLICEMIA_NORMAL;
			}
			else if(!jejum && glicemia > 200) {
				this.glicemia = StatusDiabetes.DIABETES;
			}
			
		}

}
