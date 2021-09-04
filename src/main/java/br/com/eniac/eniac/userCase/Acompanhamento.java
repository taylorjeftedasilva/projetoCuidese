package br.com.eniac.eniac.userCase;

import java.util.ArrayList;
import java.util.List;

public class Acompanhamento {

    private Long id;
    private Usuario paciente;
    private List<Lancamentos> lancamentos;

    public Acompanhamento(Long id, Usuario paciente) {
        this.paciente = paciente;
        this.lancamentos = new ArrayList<Lancamentos>();
    }

    public Long getId() {
        return id;
    }

    public List<Lancamentos> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(int dado, boolean jejum) {
        Lancamentos lancamentos = new Lancamentos(dado, jejum);
        this.lancamentos.add(lancamentos);
    }
}
