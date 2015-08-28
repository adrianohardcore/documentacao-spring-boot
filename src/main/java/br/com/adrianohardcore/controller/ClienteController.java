package br.com.adrianohardcore.controller;


import java.security.Principal;

import javax.validation.Valid;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.adrianohardcore.model.CustomUserDetails;
import br.com.adrianohardcore.repository.ClienteRepository;
import br.com.adrianohardcore.model.Cliente;
import br.com.adrianohardcore.*;

import br.com.adrianohardcore.repository.PermissaoRepository;
import br.com.adrianohardcore.repository.PermissaoRepository;
import br.com.adrianohardcore.service.PermissaoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*; 






@Controller
//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasRole('USER')")
public class ClienteController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired    
	public ClienteRepository repo;

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)  
	public String index() {
		log.info("Pagina inicial cliente!");
		return "/cliente/index"; 
	} 	
 
	@RequestMapping(value = "/clientes",method = RequestMethod.GET)
	@ResponseBody
	public List<Cliente> findItems() {
		return repo.findAll();
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
