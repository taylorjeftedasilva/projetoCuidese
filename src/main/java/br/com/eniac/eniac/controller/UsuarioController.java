package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.dto.UsuarioDTO;
import br.com.eniac.eniac.entity.Usuario;
import br.com.eniac.eniac.port.controllerUserCasePort.UsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create/user")
public class UsuarioController {

    @Autowired
    UsuarioPort port;

//    @GetMapping
//    public ResponseEntity<List<Usuario>> user(){
//        List<Usuario> usr = new ArrayList(port.findAll());
//        return new ResponseEntity(usr, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody Usuario usuario){
        UsuarioDTO usr = UsuarioDTO.convert(port.setUsuario(usuario));
        return new ResponseEntity(usr, HttpStatus.CREATED);
    }


}
