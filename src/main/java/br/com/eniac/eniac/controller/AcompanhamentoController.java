package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.dto.request.AcompanhamentoDTO;
import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.port.controllerUserCasePort.AcompanhamentosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("acompanhamento")
public class AcompanhamentoController {


    @Autowired
    private AcompanhamentosPort acompanhamentosPort;

    @GetMapping
    public ResponseEntity<List<br.com.eniac.eniac.controller.dto.response.AcompanhamentoDTO>> getAcompanhamento(@RequestHeader(value="Authorization") String token){
        List<Acompanhamento> listaAcompanhamento  = acompanhamentosPort.getAcompanhamentos(token);
        List<br.com.eniac.eniac.controller.dto.response.AcompanhamentoDTO> retorno = listaAcompanhamento.stream().map(acom -> {
            return br.com.eniac.eniac.controller.dto.response.AcompanhamentoDTO.convert(acom);
        }).collect(Collectors.toList());
        return new ResponseEntity(retorno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<br.com.eniac.eniac.controller.dto.response.AcompanhamentoDTO> CriaAcompanhamento(@RequestHeader(value="Authorization") String token, @RequestBody AcompanhamentoDTO ac){
        try{
            return new ResponseEntity(br.com.eniac.eniac.controller.dto.response.AcompanhamentoDTO.convert(acompanhamentosPort.save(ac, token)), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<br.com.eniac.eniac.controller.dto.response.AcompanhamentoDTO> atualizar(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestBody AcompanhamentoDTO ac){
        try{
            return new ResponseEntity(br.com.eniac.eniac.controller.dto.response.AcompanhamentoDTO.convert(acompanhamentosPort.update(id, ac, token)), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
