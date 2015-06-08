package br.com.adrianohardcore.service;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    

    @Autowired
    UsuarioRepository usuarioRepository;

    
    public Optional<Usuario> getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(usuarioRepository.findOne(id));
    }
    
    public Optional<Usuario> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return usuarioRepository.findOneByEmail(email);
    }
    
    public Collection<Usuario> getAllUsers() {
        LOGGER.debug("Getting all users");
        return (Collection<Usuario>) usuarioRepository.findAll() ; //(new Sort("email"));
    }
    
    public Usuario create(Usuario form) {
        Usuario user = new Usuario();
        user = form;
        //user.setEmail(form.getEmail());
        user.setSenha (new BCryptPasswordEncoder().encode(form.getSenhaForm()));
        //user.setPermissoes(form.getPermissoes());
        return usuarioRepository.save(user);
    }

}
