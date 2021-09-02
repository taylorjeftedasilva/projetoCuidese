package br.com.eniac.eniac.controller.repository;

import br.com.eniac.eniac.modulos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
