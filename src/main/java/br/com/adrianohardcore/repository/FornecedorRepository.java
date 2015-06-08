package br.com.adrianohardcore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.adrianohardcore.model.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer>{


}
