package br.com.eniac.eniac.port.controllerUserCasePort;

import br.com.eniac.eniac.entity.repository.UsuarioRepository;
import br.com.eniac.eniac.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioPort {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario setUsuario(Usuario usr){
        Usuario usuario = usuarioRepository.save(usr);
        return usuario;
    }
    public Optional<Usuario> getUsuario(String email){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }
}
