package br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario;

import java.time.LocalDate;

public class UsuarioResponse {
    private Long id;
    private String login;
    private String senha;
    private LocalDate dateCriacao;

    public UsuarioResponse(Long id, String login, String senha, LocalDate dateCriacao) {
        super();
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.dateCriacao = dateCriacao;
    }

    public static UsuarioResponse transformaParaDTO(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getLogin(),
                usuario.getSenha(), usuario.getDateCadastro());
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDateCriacao() {
        return dateCriacao;
    }


}
