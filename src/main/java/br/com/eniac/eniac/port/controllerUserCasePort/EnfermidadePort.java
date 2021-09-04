package br.com.eniac.eniac.port.controllerUserCasePort;

import br.com.eniac.eniac.userCase.DiabetesObservacoes;
import br.com.eniac.eniac.userCase.Enfermidade;
import br.com.eniac.eniac.userCase.Lancamentos;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class EnfermidadePort {

    public List<DiabetesObservacoes> getListStatus(List<Lancamentos> lancamentos){
        return Enfermidade.getStatus(lancamentos);
    }
    public DiabetesObservacoes getStatus(Lancamentos lancamento){
        return Enfermidade.getStatus(lancamento);
    }
}
