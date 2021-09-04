package br.com.eniac.eniac.entity;

import br.com.eniac.eniac.userCase.domain.enums.UsuarioType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
}
