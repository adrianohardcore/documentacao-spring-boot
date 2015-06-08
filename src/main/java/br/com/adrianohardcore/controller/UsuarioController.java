package br.com.adrianohardcore.controller;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.model.validator.UsuarioValidator;
import br.com.adrianohardcore.repository.PermissaoRepository;
import br.com.adrianohardcore.repository.UsuarioRepository;
import br.com.adrianohardcore.service.UsuarioService;

@Controller
//@PreAuthorize("hasAuthority('USER')")
public class UsuarioController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired    
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired    
	public PermissaoRepository permissaoRepository;
	
 	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)	
	public String lista(Model model){		
		model.addAttribute("usuarios",usuarioRepository.findAll());
		return "/usuario/lista";
	} 
	
//	@RequestMapping(value = "/usuario/form", method = RequestMethod.GET)	
//	public String form(Usuario usuario){	
//		return "/usuario/form";
//	}
	
	@RequestMapping(value = "/usuario/form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
	}
	
//	@RequestMapping(value = "/usuario", method = RequestMethod.POST)	
//	public String create(@Valid Usuario usuario, BindingResult result) {
	
	@Transactional
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)	
	public String create(@Valid Usuario usuario, BindingResult result) {		
		LOGGER.debug("Salvar usuário");		
		
		UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService) ;
		usuarioValidator.validate(usuario,result);		
		
		if (result.hasErrors())
			return "usuario/form";
		
		usuarioService.create(usuario);
		
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
	public String update(@ModelAttribute @Valid Usuario usuario, BindingResult result,Model model) {
		LOGGER.debug("Atualizar usuários do formulario update");
		
		if (usuario.getSenhaForm().isEmpty() == false){
			LOGGER.debug("Senha: " +  usuario.getSenhaForm());
			UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService) ;
			usuarioValidator.validate(usuario,result);			
		}
		
		if (result.hasErrors())
		{			
			model.addAttribute("roleList", permissaoRepository.findAll());			
			return "usuarios/update";
		}
		
		usuarioRepository.save(usuario);
		return "redirect:/user";
	}
}
