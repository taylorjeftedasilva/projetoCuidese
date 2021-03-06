package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.dto.UsuarioDTO;
import br.com.eniac.eniac.entity.Usuario;
import br.com.eniac.eniac.port.controllerUserCasePort.UsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create/user")
public class UsuarioController {

    @Autowired
    UsuarioPort port;

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody Usuario usuario){
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        UsuarioDTO usr = UsuarioDTO.convert(port.setUsuario(usuario));
        return new ResponseEntity(usr, HttpStatus.CREATED);
    }


}
