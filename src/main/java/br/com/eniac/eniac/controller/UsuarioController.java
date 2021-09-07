package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.dto.response.UsuarioDTO;
import br.com.eniac.eniac.entity.Usuario;
import br.com.eniac.eniac.port.controllerUserCasePort.UsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/create/user")
public class UsuarioController {

    @Autowired
    UsuarioPort port;

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody br.com.eniac.eniac.controller.dto.request.UsuarioDTO usr){
        Usuario usuario = new Usuario(usr.getNome(), usr.getEmail(), usr.getSenha());
        System.out.println(usuario);
        Optional<Usuario> validacao = port.getUsuario(usuario.getEmail());
        if(!validacao.isPresent()){
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            UsuarioDTO user = UsuarioDTO.convert(port.setUsuario(usuario));
            return new ResponseEntity(user, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }


}
