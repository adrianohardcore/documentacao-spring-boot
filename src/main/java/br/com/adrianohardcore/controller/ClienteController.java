package br.com.adrianohardcore.controller;


//import org.springframework.*;
import javax.validation.Valid;

import br.com.adrianohardcore.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.adrianohardcore.model.Cliente;
import br.com.adrianohardcore.repository.ClienteRepository;
//import org.springframework.transaction.annotation.*;  






@Controller
@PreAuthorize("hasRole('ADMIN')")
public class ClienteController {

	@Autowired    
	public ClienteRepository clienteRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
 	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	//@ResponseBody 	
	public String lista(Model model){		
		model.addAttribute("clientes",clienteRepository.findAll());
		return "/cliente/lista";
	} 
	
	@RequestMapping(value = "/cliente/form", method = RequestMethod.GET)	
	public String form(Model model){
		log.info("Formulario de cadastro de cliente");
		model.addAttribute("cliente", new Cliente());
		return "/cliente/form";
	}

/*     @RequestMapping(value="/cliente/form", method=RequestMethod.POST)
    public String formSave(@ModelAttribute Cliente cliente, Model model) {
        clienteRepository.save(cliente);
        return "result";
    } */	
	
/* 	@RequestMapping(value = "/cliente/form", method = RequestMethod.POST)
	public String formSave(@Valid Cliente cliente, BindingResult result) {		
 		if (result.hasErrors())
			return "/cliente/form";
		//clienteRepository.save(cliente); 
		return "redirect:/cliente";
	} */	
	
	
/* @ModelAttribute("timesheet") TimeSheet timeSheet, */

	
	@RequestMapping(value = "/cliente/form", method = RequestMethod.POST)
	public String formSave(@Valid Cliente cliente, BindingResult result) {		  
 		if (result.hasErrors()){
			return "/cliente/form";
		}
		clienteRepository.save(cliente); 
		return "redirect:/cliente";
	}
}
