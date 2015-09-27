package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{
	Page<Fornecedor> findAll(Pageable pageRequest);
	Page<Fornecedor> findByNomefornecedorLike(String name, Pageable pageRequest);
	Page<Fornecedor> findByNomefantasiaLike(String name, Pageable pageRequest);
	Page<Fornecedor> findByNomefornecedorOrNomefantasia(String name, Pageable pageRequest);

	Page<Fornecedor> findByNomefornecedorLikeIgnoreCaseOrNomefantasiaLikeIgnoreCase(String query1, String query2, Pageable pageable);
	
	//@Query(value = "select f from Fornecedor f where f.nomefornecedor like upper(%:text%) or f.nomefantasia like upper(%:text%)")

    @Query("SELECT f FROM Fornecedor f WHERE " +
            "UPPER(f.nomefornecedor) LIKE UPPER(CONCAT('%',:text, '%')) OR " +
            "UPPER(f.nomefantasia) LIKE UPPER(CONCAT('%',:text, '%'))")
    Page<Fornecedor> fullTextSearch(@Param("text") String text, Pageable pageable);
	



}
