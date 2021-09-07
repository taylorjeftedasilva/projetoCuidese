package br.com.eniac.eniac.controller.dto.response;

import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.entity.Lancamentos;
import br.com.eniac.eniac.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoDTO {
    private Long id;
    private UsuarioDTO usuario;
    private List<Lancamentos> lancamentos;

    public  static AcompanhamentoDTO convert(Acompanhamento ac){
        UsuarioDTO usr = new UsuarioDTO(ac.getUsuario().getId(), ac.getUsuario().getNome());
        return new AcompanhamentoDTO(ac.getId(), usr, ac.getLancamentos());
    }
}
