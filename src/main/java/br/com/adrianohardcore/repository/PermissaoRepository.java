package br.com.adrianohardcore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.adrianohardcore.model.Usuario;

@Repository
public interface PermissaoRepository extends CrudRepository<Usuario, Long>{

}
