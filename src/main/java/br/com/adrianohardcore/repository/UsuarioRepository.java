package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findOneByEmail(String email);
	Usuario findByEmail(String email);
	Usuario findByNomeusuario(String nomeusuario);
	Usuario findById(Long id);
	Optional<Usuario> findOneByNomeusuario(String nomeusuario);
}
