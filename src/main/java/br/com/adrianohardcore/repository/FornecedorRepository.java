package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{
	Page<Fornecedor> findAll(Pageable pageRequest);
	Page<Fornecedor> findByNomefornecedorLike(String name, Pageable pageRequest);


}
