package br.com.adrianohardcore.model;

import org.springframework.security.core.authority.AuthorityUtils;
import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.model.Permissao;

public class UsuarioAtual extends org.springframework.security.core.userdetails.User {

    private Usuario user;

    public UsuarioAtual(Usuario user) {
        super(user.getEmail(), user.getSenha(), AuthorityUtils.createAuthorityList(user.getPermissoes().toString()));
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    // public Permissao getPermissao() {
        // return user.getPermissoes();
    // }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}