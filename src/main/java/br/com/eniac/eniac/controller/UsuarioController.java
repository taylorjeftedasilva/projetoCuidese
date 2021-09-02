package br.com.eniac.eniac.controller;

import br.com.eniac.eniac.controller.repository.UsuarioRepository;
import br.com.eniac.eniac.modulos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/create/user")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> user(){
        List<Usuario> usr = new ArrayList(usuarioRepository.findAll());
        return new ResponseEntity(usr, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario){
        Usuario usr = usuarioRepository.save(usuario);
        return new ResponseEntity(usr, HttpStatus.CREATED);
    }


}
