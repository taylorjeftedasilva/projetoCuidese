package br.com.eniac.eniac.config;

import br.com.eniac.eniac.entity.Usuario;
import br.com.eniac.eniac.port.controllerUserCasePort.UsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    UsuarioPort usuarioPort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(usuarioPort.getUsuario(email).isPresent()){
        return  usuarioPort.getUsuario(email).get();
        }
        throw new UsernameNotFoundException("Dados invalidos");
    }
}
