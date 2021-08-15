package br.com.eniac.eniac.modulos;

import br.com.eniac.eniac.modulos.enums.UsuarioType;

import javax.persistence.*;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;
	@Enumerated(EnumType.STRING)
	private UsuarioType userType = UsuarioType.COMUM;
	
	public Usuario() {}
	
	public Usuario(Long id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioType getUserType() {
		return userType;
	}
	public void setUserType(UsuarioType userType) {
		this.userType = userType;
	}

}
