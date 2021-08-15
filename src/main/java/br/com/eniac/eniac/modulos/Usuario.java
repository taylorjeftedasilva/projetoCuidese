package br.com.eniac.eniac.modulos;

import br.com.eniac.eniac.modulos.enums.UsuarioType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;

	@Enumerated(EnumType.STRING)
	private UsuarioType userType = UsuarioType.COMUM;
	
	public Usuario(Long id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
}
