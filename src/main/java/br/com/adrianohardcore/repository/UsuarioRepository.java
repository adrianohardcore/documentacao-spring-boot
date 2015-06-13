package br.com.adrianohardcore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianohardcore.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findOneByEmail(String email);
	Usuario findByEmail(String email);
	Usuario findByNomeusuario(String nomeusuario);

	Optional<Usuario> findById(Long id);
}
