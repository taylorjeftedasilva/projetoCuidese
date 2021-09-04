package br.com.eniac.eniac.port.controllerUserCasePort;

import br.com.eniac.eniac.controller.repository.UsuarioRepository;
import br.com.eniac.eniac.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPort {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario setUsuario(Usuario usr){
        Usuario usuario = usuarioRepository.save(usr);
        return usuario;
    }
}
