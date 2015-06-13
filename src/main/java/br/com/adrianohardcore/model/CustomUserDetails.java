
package br.com.adrianohardcore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.adrianohardcore.model.Permissao;
import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.repository.UsuarioRepository;


public class CustomUserDetails extends User {

    private long id;
    private String nome;
    private String email;

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, long id, String nome, String email) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.nome = nome;
        this.email = email;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
	
	public String getNome() {
		return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
	
		public String getEmail() {
		return email;
    }

    public void setEmail(String email) {
        this.nome = email;
    }
	
	    @Override
    public String toString() {
        return "Usuario " +
                "Id:" + id + " Nome: " + nome + " Email: " + email 
                + super.toString();
    }
	

	
	
	
}