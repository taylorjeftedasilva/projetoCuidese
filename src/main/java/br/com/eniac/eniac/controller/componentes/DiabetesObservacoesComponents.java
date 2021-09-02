package br.com.eniac.eniac.controller.componentes;

import lombok.Data;

@Data
public class DiabetesObservacoesComponents {

    public String NOME_ENFERMIDADE = "DIABETES";
    private boolean jejum;
    private int glicemia;

    public boolean getJejum() {
        return jejum;
    }
}
