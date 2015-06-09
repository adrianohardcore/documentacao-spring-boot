package br.com.adrianohardcore.service;

import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.model.Permissao;
import br.com.adrianohardcore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String nomeusuario) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByNomeusuario(nomeusuario);
        List<GrantedAuthority> authorities = buildUserAuthority(usuario.getPermissoes());
        return buildUserForAuthentication(usuario, authorities);
    }

    private User buildUserForAuthentication(Usuario user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getNomeusuario(), user.getSenha(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Permissao> userRoles) {

        List<GrantedAuthority> setAuths = new ArrayList(); 

        // Build user's authorities
        for (Permissao userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getNomePermissao()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }
}