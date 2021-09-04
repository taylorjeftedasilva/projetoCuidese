package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.repository.AcompanhamentoRepository;
import br.com.eniac.eniac.userCase.Lancamentos;
import br.com.eniac.eniac.port.controllerUserCasePort.EnfermidadePort;
import br.com.eniac.eniac.userCase.DiabetesObservacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enfermidade")
public class EnfermidadeController {
    @Autowired
    private EnfermidadePort enfermidadePort;
    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @GetMapping
    public List<DiabetesObservacoes> getEnfermidade(){
        List<br.com.eniac.eniac.entity.Lancamentos> lte = (List<br.com.eniac.eniac.entity.Lancamentos>) acompanhamentoRepository.getById(Long.valueOf(1)).getLancamentos();
        List<Lancamentos> lancamentos = lte.stream().map(l -> {
             return new Lancamentos(l.getDado(),l.isJejum());}).collect(Collectors.toList());
        return enfermidadePort.getListStatus(lancamentos);
    }
}
