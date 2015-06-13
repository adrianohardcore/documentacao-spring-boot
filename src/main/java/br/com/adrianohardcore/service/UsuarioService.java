package br.com.adrianohardcore.service;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adrianohardcore.config.PasswordCrypto;
import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    

    @Autowired
    UsuarioRepository usuarioRepository;

    
    public Optional<Usuario> getUserById(long id) {        
        return Optional.ofNullable(usuarioRepository.findOne(id));
    }
    
    public Optional<Usuario> getUserByEmail(String email) {
        log.info("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return usuarioRepository.findOneByEmail(email);
    }
    
    public Collection<Usuario> getAllUsers() {
        log.info("Getting all users");
        return (Collection<Usuario>) usuarioRepository.findAll() ; //(new Sort("email"));
    }
    
    public Usuario create(Usuario form) {
		log.info("Cadastrando ...");		
        Usuario user = form;

        //Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		//user.setSenha(passwordEncoder.encodePassword(form.getSenhaForm(),null));
		log.info("Senha digitada: " + form.getSenhaForm());
		//user.setSenha(PasswordCrypto.getInstance().encrypt(form.getSenhaForm()));
		user.setSenha(new BCryptPasswordEncoder().encode(form.getSenhaForm()));
		log.info("Senha criptografada: " + user.getSenhaForm());
		
		
        //user.setEmail(form.getEmail());
        //user.setSenha(PasswordCrypto.getInstance().encrypt(form.getSenhaForm()));
		//(new BCryptPasswordEncoder().encode(form.getSenhaForm()));
		//PasswordCrypto.getInstance().encrypt(password);
		
        //user.setPermissoes(form.getPermissoes());
        return usuarioRepository.save(user);
    }

}
