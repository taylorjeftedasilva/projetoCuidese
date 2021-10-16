package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.dto.request.UsuarioRequestDTO;
import br.com.eniac.eniac.controller.dto.response.UsuarioResponseDTO;
import br.com.eniac.eniac.entity.Usuario;
import br.com.eniac.eniac.port.controllerUserCasePort.UsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/create/user")
public class UsuarioController {

    @Autowired
    UsuarioPort port;

    @GetMapping
    public ResponseEntity<String> getUser(){
        System.out.println("te chamei");
        return new ResponseEntity("Taylor", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUser(@RequestBody UsuarioRequestDTO usuario){
        try{
        Usuario usr1 = new Usuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        Optional<Usuario> validacao = port.getUsuario(usr1.getEmail());
        if(!validacao.isPresent()){
            usr1.setSenha(new BCryptPasswordEncoder().encode(usr1.getSenha()));
            UsuarioResponseDTO user = UsuarioResponseDTO.convert(port.setUsuario(usr1));
            return new ResponseEntity(user, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();}
        catch (NullPointerException nl ){
            return ResponseEntity.badRequest().build();
        }
    }


}
