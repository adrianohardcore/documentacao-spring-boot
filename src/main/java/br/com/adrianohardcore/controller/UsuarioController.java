package br.com.adrianohardcore.controller;



import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.model.validator.UsuarioValidator;
import br.com.adrianohardcore.repository.PermissaoRepository;
import br.com.adrianohardcore.repository.UsuarioRepository;
import br.com.adrianohardcore.service.UsuarioService;


@Controller
@PreAuthorize("hasRole('USER')")
public class UsuarioController {			   
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired    
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired    
	public PermissaoRepository permissaoRepository;
	
 	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)	
	public String lista(Principal principal,Model model){

		log.info("---" + principal.getName());
		
		//((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getD‌​etails()).getId();
		//Object user =  SecurityContextHolder.getContext().getAuthentication().getDetails();
		//UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
		//log.info("ID: " + userDetails.getEmail().toString());
		
		//((CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPr‌​incipal()).ge
		
		//CustomUserDetails usuarioAtual = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("Email: " + usuarioAtual.getEmail());
		//usuarioAtual.ge//





		//model.addAttribute("usuarios",usuarioRepository.findAll());
		model.addAttribute("usuarios",usuarioService.getAllUsers() );
		return "/usuario/lista";
	} 
	
//	@RequestMapping(value = "/usuario/form", method = RequestMethod.GET)	
//	public String form(Usuario usuario){	
//		return "/usuario/form";
//	}

	@RequestMapping(value = "/usuario/form", method = RequestMethod.GET)
	public String form(Model model) {
		log.info("Formulario de cadastro de usuario");
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
	}
	//formUsuarioAtual
	
	@RequestMapping(value = "/usuario/editar", method = RequestMethod.GET)
	public String formEditAtual(Model model) {
		
		CustomUserDetails usuarioAtual = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("Email: " + usuarioAtual.getEmail());
		
		Usuario usuario = usuarioService.getUserById(usuarioAtual.getId());
		
		
		log.info("Formulario de cadastro de usuario");
		model.addAttribute("usuario", usuario);
		return "usuario/formUsuarioAtual";
	}
	
	@Transactional
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)	
	public String create(@Valid Usuario usuario, BindingResult result) {	

		log.info("inicio gravando novo usuario");		
		
		UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService) ;
		usuarioValidator.validate(usuario,result);		
		
		if (result.hasErrors()){
			log.info("Erro ao gravar novo usuario");		
			return "usuario/form";		
		}
		log.info("Antes gravar usuario");		
		usuarioService.create(usuario);		
		log.info("Depois gravar usuario");		
		return "redirect:/usuarios";		
	}	
	

	
	@RequestMapping(value = "/userio/{id}", method = RequestMethod.DELETE)	
	public void delete(@PathVariable("id") Long id) {
			
		usuarioRepository.delete(id);	
	}	

	@RequestMapping(value = "/usuario/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {

		modelMap.addAttribute("usuario", usuarioRepository.findOne(id));
		modelMap.addAttribute("permissaolist", permissaoRepository.findAll());
		return "usuario/update";
	}	

	@RequestMapping(value = "/usuario",method = RequestMethod.PUT)
	public @ResponseBody String update(@ModelAttribute @Valid Usuario usuario, BindingResult result,Model model) {
		log.debug("Atualizar usuarios do formulario update");

		
		if (!usuario.getSenhaForm().isEmpty()){
			log.debug("Senha: " +  usuario.getSenhaForm());			
			
			UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService) ;
			usuarioValidator.validate(usuario,result);			
		}
		
		if (result.hasErrors())  
		{			
			model.addAttribute("roleList", permissaoRepository.findAll());				
			return "usuario/formUsuarioAtual";
		}
		
		usuarioService.create(usuario);
		return "redirect:/user";
	}


	//@PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
	//@RequestMapping("/usuario/{id}")
//	public ModelAndView getUserPage(@PathVariable Long id) {
//		//LOGGER.info("Getting user page for user={}", id);
//		log.info("Cadastro do usuario atual");
//		return new ModelAndView("user", "user", usuarioRepository.findById(id));  //getUserById(id)
//				//.orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
//	}
}
