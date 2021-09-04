package br.com.eniac.eniac.port.controllerUserCasePort;

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

    public List<Acompanhamento> getAcompanhamentos(){
        Usuario usr = usuarioRepository.getById(Long.valueOf(1));
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByUsuario(usr);
        return acompanhamentos;
    }

    public Acompanhamento setAcompanhamento(Acompanhamento acompanhamento){
        return acompanhamentoRepository.save(acompanhamento);
    }

    public Acompanhamento save(AcompanhamentoDTO ac) {
        List<Lancamentos> lancamentos = lancamentoRepository.saveAll(ac.getLancamentos());
        Acompanhamento acomp = new Acompanhamento(null, usuarioRepository.getById(Long.valueOf(1)), lancamentos);
        return acompanhamentoRepository.save(acomp);
    }
}
