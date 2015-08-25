package br.com.adrianohardcore.controller;



import java.security.Principal;

import javax.validation.Valid;

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

import br.com.adrianohardcore.model.CustomUserDetails;
import br.com.adrianohardcore.model.Permissao;

import br.com.adrianohardcore.repository.PermissaoRepository;
import br.com.adrianohardcore.repository.PermissaoRepository;
import br.com.adrianohardcore.service.PermissaoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;


//@Controller
//@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping("/permissoes")
public class PermissaoController {			   
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired    
	public PermissaoRepository repo;	
	
    @RequestMapping("/")
    public String index(Principal principal) {
        log.info("Pagina inicial!");
        return "/permissao/index";
    }
 
	@RequestMapping(method = RequestMethod.GET)
	public List<Permissao> findItems() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Permissao addItem(@RequestBody Permissao permissao) {
		permissao.setId(null);
		return repo.saveAndFlush(permissao);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Permissao updateItem(@RequestBody Permissao updatedItem, @PathVariable Long id) {
		updatedItem.setId(id);
		return repo.saveAndFlush(updatedItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public void deleteItem(@PathVariable Integer id) {
		//repo.delete(id);
	}
}
