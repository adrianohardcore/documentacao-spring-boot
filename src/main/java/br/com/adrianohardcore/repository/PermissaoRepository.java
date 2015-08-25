package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Permissao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adrianohardcore.model.Usuario;
import java.util.Optional;

import java.util.List;


public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    Permissao findByNomePermissao(String user);


	//Optional<Permissao> findOneByEmail(String email);
	
	
	Permissao findById(Long id);
	Optional<Permissao> findOneByNomePermissao(String nomePermissao);

}
