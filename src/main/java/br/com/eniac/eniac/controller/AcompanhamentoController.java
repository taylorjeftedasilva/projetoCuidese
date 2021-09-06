package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.dto.AcompanhamentoDTO;
import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.port.controllerUserCasePort.AcompanhamentosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acompanhamento")
public class AcompanhamentoController {


    @Autowired
    private AcompanhamentosPort acompanhamentosPort;

    @GetMapping
    public ResponseEntity<List<Acompanhamento>> getAcompanhamento(@RequestHeader(value="Authorization") String token){
        List<Acompanhamento> listaAcompanhamento  = acompanhamentosPort.getAcompanhamentos(token);
        return new ResponseEntity(listaAcompanhamento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Acompanhamento> CriaAcompanhamento(@RequestHeader(value="Authorization") String token, @RequestBody AcompanhamentoDTO ac){
        try{
            return new ResponseEntity(acompanhamentosPort.save(ac, token), HttpStatus.CREATED);
        }catch (Exception ex){
            System.out.println(ex.getCause());
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
