package br.com.adrianohardcore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.adrianohardcore.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{


}
