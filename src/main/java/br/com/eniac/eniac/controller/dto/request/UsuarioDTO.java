package br.com.eniac.eniac.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
}
