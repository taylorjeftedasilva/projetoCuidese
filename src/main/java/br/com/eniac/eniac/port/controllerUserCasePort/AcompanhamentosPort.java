package br.com.eniac.eniac.port.controllerUserCasePort;

import br.com.eniac.eniac.config.TokenService;
import br.com.eniac.eniac.controller.dto.request.AcompanhamentoDTO;
import br.com.eniac.eniac.entity.repository.AcompanhamentoRepository;
import br.com.eniac.eniac.entity.repository.LancamentoRepository;
import br.com.eniac.eniac.entity.repository.UsuarioRepository;
import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.entity.Lancamentos;
import br.com.eniac.eniac.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Acompanhamento save(AcompanhamentoDTO ac, String token) {
        List<Lancamentos> lancamentos = lancamentoRepository.saveAll(ac.getLancamentos());
        Acompanhamento acomp = new Acompanhamento(null, getUsuario(token), lancamentos);
        return acompanhamentoRepository.save(acomp);
    }

    private Usuario getUsuario(String token) {
        Long id = tokenService.getIdUsuario(token.substring(7,token.length()));
        return usuarioRepository.getById(Long.valueOf(id));
    }
    private boolean lancamentoCriado(Lancamentos lancamento){
        try{
        Optional<Lancamentos> lancamentosOptional = lancamentoRepository.findById(lancamento.getId());

        if(lancamentosOptional.isPresent()){
            return true;
        }
        return false;
        }catch (Exception ex){
            return false;
        }
    }

    public Acompanhamento update(Long id, AcompanhamentoDTO ac, String token) {
        Optional<Acompanhamento> exitsAcompanhamento = acompanhamentoRepository.findById(id);

        ac.getLancamentos().forEach(lan -> {
            boolean exiteLancamento = lancamentoCriado(lan);
            Long isPresentId = lan.existeID();
            if(!exiteLancamento ||  isPresentId == 0){
                Long idLancamento = lancamentoRepository.save(lan).getId();
                lan.setId(idLancamento);
            }
        });
        if(exitsAcompanhamento.isPresent()){
            Acompanhamento acompanhamento = exitsAcompanhamento.get();
            Usuario usuario = getUsuario(token);
            if(usuario.getEmail().equals(acompanhamento.getUsuario().getEmail())){
                acompanhamento.setLancamentos(ac.getLancamentos());
                acompanhamentoRepository.saveAndFlush(acompanhamento);
                return acompanhamento;
            }
        }
        return null;
    }
}
