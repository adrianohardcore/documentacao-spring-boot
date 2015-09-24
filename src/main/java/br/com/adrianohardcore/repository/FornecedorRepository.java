package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Fornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer>{


}
