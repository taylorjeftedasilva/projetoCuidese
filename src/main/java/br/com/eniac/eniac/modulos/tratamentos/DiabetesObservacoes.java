package br.com.eniac.eniac.modulos.tratamentos;

import br.com.eniac.eniac.modulos.enums.StatusDiabetes;
import br.com.eniac.eniac.modulos.tratamentos.methodos.LogicaDiabetes;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class DiabetesObservacoes {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@Value("${NOME_ENFERMIDADE: DIABETES}")
	public String NOME_ENFERMIDADE = "DIABETES";
	private boolean jejum;
	@Enumerated(EnumType.STRING)
	private StatusDiabetes glicemia;

	public String getGlicemia() {
		String resultadoTratado = String.valueOf(this.glicemia).replace("_", " ");
		return resultadoTratado;
	}

	public DiabetesObservacoes (boolean jejum, int glicemia){
		this.jejum = jejum;
		this.glicemia = LogicaDiabetes.setGlicemia(this.jejum, glicemia);
	}

}
