package br.com.eniac.eniac.userCase;

import br.com.eniac.eniac.userCase.domain.enums.UsuarioType;

public class Usuario {
    private Long id;
    private String nome;
    private String senha;
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
