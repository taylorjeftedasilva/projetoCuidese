package br.com.eniac.eniac.port.controllerUserCasePort;

import br.com.eniac.eniac.config.TokenService;
import br.com.eniac.eniac.controller.dto.AcompanhamentoDTO;
import br.com.eniac.eniac.entity.repository.AcompanhamentoRepository;
import br.com.eniac.eniac.entity.repository.LancamentoRepository;
import br.com.eniac.eniac.entity.repository.UsuarioRepository;
import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.entity.Lancamentos;
import br.com.eniac.eniac.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcompanhamentosPort {
    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private TokenService tokenService;

    public List<Acompanhamento> getAcompanhamentos(String token){
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByUsuario(getUsuario(token));
        return acompanhamentos;
    }


//    public Acompanhamento setAcompanhamento(Acompanhamento acompanhamento){
//        return acompanhamentoRepository.save(acompanhamento);
//    }

    public Acompanhamento save(AcompanhamentoDTO ac, String token) {
        List<Lancamentos> lancamentos = lancamentoRepository.saveAll(ac.getLancamentos());
        Acompanhamento acomp = new Acompanhamento(null, getUsuario(token), lancamentos);
        return acompanhamentoRepository.save(acomp);
    }

    private Usuario getUsuario(String token) {
        Long id = tokenService.getIdUsuario(token.substring(7,token.length()));
        return usuarioRepository.getById(Long.valueOf(id));
    }
}
