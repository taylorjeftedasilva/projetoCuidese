package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.componentes.AcompanhamentoComponents;
import br.com.eniac.eniac.controller.repository.AcompanhamentoRepository;
import br.com.eniac.eniac.modulos.Acompanhamento;
import br.com.eniac.eniac.modulos.Enfermidade;
import br.com.eniac.eniac.modulos.Usuario;
import br.com.eniac.eniac.modulos.tratamentos.DiabetesObservacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acompanhamento")
public class AcompanhamentoController {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @GetMapping
    public ResponseEntity<List> getAcompanhamento(){
        List<Acompanhamento> listaAcompanhamento  = acompanhamentoRepository.findAll();
        return new ResponseEntity(listaAcompanhamento, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Acompanhamento> CriaAcompanhamento(@RequestBody AcompanhamentoComponents acomp){
        System.out.println(acomp);
        Usuario usuario = new Usuario(acomp.getUser().getNome(), acomp.getUser().getSenha());
        DiabetesObservacoes diabetesObservacoes = new DiabetesObservacoes(acomp.getEnfermidade().getTratamento().getJejum(),acomp.getEnfermidade().getTratamento().getGlicemia());
        Enfermidade enfermidade = new Enfermidade(diabetesObservacoes);

        Acompanhamento acompanhamentoCompleto = new Acompanhamento(usuario, enfermidade);
        try{
            Acompanhamento acompanhamento = acompanhamentoRepository.save(acompanhamentoCompleto);
            return new ResponseEntity(acompanhamento, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
