package br.com.adrianohardcore.controller;


import javax.validation.Valid;

import br.com.adrianohardcore.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.adrianohardcore.model.Fornecedor;
import br.com.adrianohardcore.repository.FornecedorRepository;






@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class FornecedorController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired    
	public FornecedorRepository fornecedorRepository;
	
 	@RequestMapping(value = "/fornecedor", method = RequestMethod.GET)
	//@ResponseBody 
	
	
	public String lista(Model model){		
		model.addAttribute("fornecedores",fornecedorRepository.findAll());
		return "/fornecedor/lista";
	}

	@RequestMapping(value = "/fornecedor/form", method = RequestMethod.GET)
	public String form(Model model){
		log.info("Formulario de cadastro de fornecedor");
		model.addAttribute("fornecedor", new Cliente());
		return "/fornecedor/form";
	}

	
/*     @RequestMapping(value="/fornecedor/form", method=RequestMethod.POST)
    public String formSave(@ModelAttribute Fornecedor fornecedor, Model model) {
        fornecedorRepository.save(fornecedor);
        return "result";
    } */	
	
/* 	@RequestMapping(value = "/fornecedor/form", method = RequestMethod.POST)
	public String formSave(@Valid Fornecedor fornecedor, BindingResult result) {		
 		if (result.hasErrors())
			return "/fornecedor/form";
		//fornecedorRepository.save(fornecedor); 
		return "redirect:/fornecedor";
	} */	
	
	
/* @ModelAttribute("timesheet") TimeSheet timeSheet, */

	@Transactional
	@RequestMapping(value = "/fornecedor/form", method = RequestMethod.POST)
	public String formSave(@Valid Fornecedor fornecedor, BindingResult result) {		
 		if (result.hasErrors())
			return "/fornecedor/form";
		fornecedorRepository.save(fornecedor);
		return "redirect:/fornecedor";
	}		
	
	
	
	

}
