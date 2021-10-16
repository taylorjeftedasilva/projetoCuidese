package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.dto.request.FormLogin;
import br.com.eniac.eniac.controller.dto.request.TokenDto;
import br.com.eniac.eniac.config.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> auth(@RequestBody FormLogin login){
        try {
            UsernamePasswordAuthenticationToken dadosLogin = login.convert();
            Authentication authenticaion = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerar(authenticaion);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
