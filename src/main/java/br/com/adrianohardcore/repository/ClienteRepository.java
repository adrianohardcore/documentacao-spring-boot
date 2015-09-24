package br.com.adrianohardcore.repository;

import br.com.adrianohardcore.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, String>{

    //Page<Cliente> findAll2(String name, Pageable pageRequest);


    Page<Cliente> findAll(Pageable pageRequest);
}
