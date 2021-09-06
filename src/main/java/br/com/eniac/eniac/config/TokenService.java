package br.com.eniac.eniac.config;


import br.com.eniac.eniac.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${cuidese.jwt.expiration}")
    private Long expiration;

    @Value("${cuidese.jwt.secret}")
    private String secret;

    public String gerar(Authentication auth){
        Usuario logado = (Usuario) auth.getPrincipal();
        Date hoje = new Date();
        Date expiracao = new Date(hoje.getTime() + expiration);

        return Jwts.builder()
                .setIssuer("API Cuide-se")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception ex){
        return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
