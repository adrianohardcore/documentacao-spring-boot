package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import java.util.function.Predicate;
import java.util.Optional;




//public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, QueryDslPredicateExecutor<Usuario> {	

	Optional <Usuario> findOneByEmail(String email);
	Usuario findByEmail(String email);
	Usuario findByNomeusuario(String nomeusuario);
	Usuario findById(Long id);
	Optional<Usuario> findOneByNomeusuario(String nomeusuario);
	Page<Usuario> findAll(Predicate predicate, Pageable pageRequest);
}
