package br.com.eniac.eniac.controller.repository;

import br.com.eniac.eniac.entity.Lancamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamentos, Long> {
}
