package br.com.eniac.eniac.controller.dto.request;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class FormLogin {
    private String email;
    private String senha;

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(email,senha);
    }
}
