package br.com.eniac.eniac.entity.repository;

import br.com.eniac.eniac.entity.Acompanhamento;
import br.com.eniac.eniac.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {
    List<Acompanhamento> findByUsuario(Usuario paciente);
}
