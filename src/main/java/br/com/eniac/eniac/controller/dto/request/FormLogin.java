package br.com.eniac.eniac.controller.dto.request;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class FormLogin {
    private String email;
    private String senha;

    public UsernamePasswordAuthenticationToken convert() {
        if(email.isEmpty() ||  senha.isEmpty()){
            throw new NullPointerException("Email ou senha invalidos");
        }
        return new UsernamePasswordAuthenticationToken(email,senha);
    }
}
