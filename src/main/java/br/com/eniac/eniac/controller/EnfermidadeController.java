package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.config.TokenService;
import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.entity.Usuario;
import br.com.eniac.eniac.entity.repository.AcompanhamentoRepository;
import br.com.eniac.eniac.entity.repository.UsuarioRepository;
import br.com.eniac.eniac.userCase.Lancamentos;
import br.com.eniac.eniac.port.controllerUserCasePort.EnfermidadePort;
import br.com.eniac.eniac.userCase.DiabetesObservacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enfermidade")
public class EnfermidadeController {
    @Autowired
    private EnfermidadePort enfermidadePort;
    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private  UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<List<DiabetesObservacoes>> getEnfermidade(@RequestHeader("Authorization") String token, @PathVariable Long id){
        Acompanhamento acompanhamento = acompanhamentoRepository.getById(id);
        Usuario usuario = usuarioRepository.getById(tokenService.getIdUsuario(token.substring(7,token.length())));
        if (usuario.getEmail().equals(acompanhamento.getUsuario().getEmail())){
            List<br.com.eniac.eniac.entity.Lancamentos> lte = (List<br.com.eniac.eniac.entity.Lancamentos>) acompanhamento.getLancamentos();
            List<Lancamentos> lancamentos = lte.stream().map(l -> {
                 return new Lancamentos(l.getDado(),l.isJejum());}).collect(Collectors.toList());
            return new ResponseEntity(enfermidadePort.getListStatus(lancamentos), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
