package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.repository.AcompanhamentoRepository;
import br.com.eniac.eniac.modulos.Acompanhamento;
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
    public ResponseEntity<Acompanhamento> CriaAcompanhamento(@RequestBody Acompanhamento acomp){
        try{
            Acompanhamento acompanhamento = acompanhamentoRepository.save(acomp);
            return new ResponseEntity(acompanhamento, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
