package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.modulos.Acompanhamento;
import br.com.eniac.eniac.modulos.Enfermidade;
import br.com.eniac.eniac.modulos.Usuario;
import br.com.eniac.eniac.modulos.tratamentos.DiabetesObservacoes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("acompanhamento")
public class AcompanhamentoController {

    @GetMapping
    public Acompanhamento getAcompanhamento(){
        return new Acompanhamento(1l, new Usuario(1l, "Anna", "123"), new Enfermidade(new DiabetesObservacoes(false, 201)));
    }
}
