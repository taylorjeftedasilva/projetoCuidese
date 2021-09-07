package br.com.eniac.eniac.controller.dto.response;

import br.com.eniac.eniac.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;

    public static UsuarioDTO convert(Usuario usr) {
        return new UsuarioDTO(usr.getId(), usr.getNome());
    }
}
