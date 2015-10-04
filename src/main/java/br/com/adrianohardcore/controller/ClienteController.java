package br.com.adrianohardcore.controller;


import br.com.adrianohardcore.model.Cliente;
import br.com.adrianohardcore.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasRole('USER')")
public class ClienteController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired    
	public ClienteRepository repo;
	private Integer page = 0;
	private Integer pageTotal = 0;

	@RequestMapping(value = "/clientelista", method = RequestMethod.GET)
	public String index() {
		log.info("Pagina inicial cliente!");
		return "/cliente/index";
	}
 
	@RequestMapping(value = "/clientes",method = RequestMethod.GET , produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> findItems() {
		Integer limit = 10;
		String porder = "ASC";
		String psort = "nomecliente";
		Pageable pageRequest = new PageRequest(page, limit, Direction.fromString(porder), psort);
		log.info("limit: " + limit.toString() + " totalPages: " + page + " order: " + porder + " psort: " + psort);

		Page<Cliente> fornecedores = repo.findAll(pageRequest);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("draw", page);
		modelMap.put("recordsTotal", fornecedores.getTotalElements());
		modelMap.put("recordsFiltered", fornecedores.getTotalElements());
		modelMap.put("data", fornecedores.getContent());

		return modelMap;
	}

	@RequestMapping(value = "/clientes",method = RequestMethod.POST)
	@ResponseBody
	public Cliente addItem(@RequestBody Cliente cliente) {
		cliente.setDoctocliente(null);
		return repo.save(cliente);
	}

	@RequestMapping(value = "/clientes/{DOCTOCLIENTE}", method = RequestMethod.PUT)
	@ResponseBody
	public Cliente updateItem(@RequestBody Cliente updatedItem, @PathVariable String id) {
		updatedItem.setDoctocliente(id);
		return repo.save(updatedItem);
	}

	@RequestMapping(value = "/clientes/{DOCTOCLIENTE}", method = RequestMethod.DELETE)
	@ResponseBody
		public void deleteItem(@PathVariable String id) {
		repo.delete(id);
	}
}
