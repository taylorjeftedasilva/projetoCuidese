package br.com.eniac.eniac.controller.dto.response;

import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.entity.Lancamentos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoResponseDTO {
    private Long id;
    private UsuarioResponseDTO usuario;
    private List<Lancamentos> lancamentos;

    public  static AcompanhamentoResponseDTO convert(Acompanhamento ac){
        UsuarioResponseDTO usr = new UsuarioResponseDTO(ac.getUsuario().getId(), ac.getUsuario().getNome());
        return new AcompanhamentoResponseDTO(ac.getId(), usr, ac.getLancamentos());
    }
}
