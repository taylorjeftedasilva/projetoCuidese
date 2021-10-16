package br.com.eniac.eniac.controller.dto.response;

import br.com.eniac.eniac.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nome;

    public static UsuarioResponseDTO convert(Usuario usr) {
        return new UsuarioResponseDTO(usr.getId(), usr.getNome());
    }
}