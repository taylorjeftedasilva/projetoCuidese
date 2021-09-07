package br.com.eniac.eniac.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class TokenDto {
    private String token;
    private String tipoDeAutenticacao;

    public TokenDto(String token, String bearer) {
        this.token = token;
        this.tipoDeAutenticacao = bearer;
    }
}
