package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    Permissao findByNomePermissao(String user);


	//Optional<Permissao> findOneByEmail(String email);
	
	
	Permissao findById(Long id);
	Optional<Permissao> findOneByNomePermissao(String nomePermissao);

}
