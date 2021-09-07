package br.com.eniac.eniac.controller.dto.request;

import br.com.eniac.eniac.entity.Lancamentos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoDTO {
    private List<Lancamentos> lancamentos;
}
