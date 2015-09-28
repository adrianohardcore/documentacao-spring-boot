package br.com.adrianohardcore.controller;


import br.com.adrianohardcore.model.CustomUserDetails;
import br.com.adrianohardcore.model.Usuario;
import br.com.adrianohardcore.model.validator.UsuarioValidator;
import br.com.adrianohardcore.repository.PermissaoRepository;
import br.com.adrianohardcore.repository.UsuarioRepository;
import br.com.adrianohardcore.service.UsuarioService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysema.query.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

import javax.validation.Valid;
import java.security.Principal;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.PathVariable;

	import org.springframework.web.bind.annotation.RequestMapping;   

	import org.springframework.stereotype.Controller;

	import org.springframework.ui.Model;



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
	
 	@RequestMapping(value = "/usuario", method = RequestMethod.GET)	
	public String lista(){
		return "/usuario/lista";
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> findItems(
            @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "nomeusuario", required = false) String nomeusuario,
			@RequestParam(value = "email", required = false) String email,			
            @RequestParam(value = "sort", required = false) String psort,
            @RequestParam(value = "order", required = false) String porder,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset            
    ) {
        Integer page = (offset / limit);
        Pageable pageRequest = new PageRequest(page, limit, Direction.fromString(porder), psort);        
        QUsuario usuario = QUsuario.usuario;
        BooleanBuilder where = new BooleanBuilder();
		//if (StringUtils.isNumeric(id))
		//	where.or(usuario.id.eq(Integer.parseInt(search)));
		
		
		if (StringUtils.isNumeric(id))  where.or(usuario.id.eq(Integer.parseInt(id)));	
		
		
/*         if (id != null || nome != null || nomeusuario != null || email  != null ||  ) {		
			if (StringUtils.isNumeric(search))
				where.or(usuario.id.eq(Integer.parseInt(search)));
			where.or(usuario.nome.containsIgnoreCase(search));
			where.or(usuario.nomeusuario.containsIgnoreCase(search));
			where.or(usuario.email.containsIgnoreCase(search));    
        } */
		
        Page<Usuario> usuarioes = usuarioRepository.findAll(where, pageRequest);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("total", usuarioes.getTotalElements());
        modelMap.put("rows", usuarioes.getContent());
        return modelMap;
    }

    @PreAuthorize("true")
    @RequestMapping(value = "/usuario/form", method = RequestMethod.GET)
	public String form(Model model) {
		log.info("Formulario de cadastro de novo usuario");
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
	}

	@RequestMapping(value = "/usuario/editar", method = RequestMethod.GET)
	public String formEditAtual(Model model) {
		
		CustomUserDetails usuarioAtual = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario usuario = usuarioService.getUserById(usuarioAtual.getId());

		log.info("Formulario de edicao de usuario");
		model.addAttribute("usuario", usuario);
		return "usuario/formUsuarioAtual";
	}
 
//    @RequestMapping(value = "/usuario/{id}/editar", method = RequestMethod.GET)
//    public String formEdit(Usuario usuario,Model model) {
//
//        log.info("Formulario de edicao de usuario");
//
//
//        usuarioService.getUserById(id);
//        model.addAttribute("usuario", usuario);
//        return "usuario/formUsuarioAtual";
//    }


	@Transactional
    @PreAuthorize("true")
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)	
	public String create(@Valid Usuario usuario, BindingResult result) {
		log.info("inicio gravando novo usuario");
		UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService) ;
		usuarioValidator.validate(usuario,result);
		if (result.hasErrors()){
			log.info("Erro ao gravar novo usuario");		
			return "usuario/form";		
		}
		usuarioService.create(usuario);
		return "redirect:/usuarios";		
	}
	


	@RequestMapping(value = "/usuario/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("usuario", usuarioRepository.findOne(id));
		modelMap.addAttribute("permissaolist", permissaoRepository.findAll());
		return "usuario/formEditar";
	}

	@RequestMapping(value = "/usuarioEditar",method = RequestMethod.POST)
	public String update(@ModelAttribute @Valid Usuario usuario, BindingResult result,Model model) {
		log.info("Atualizar usuarios do formulario update");
		log.info("Senha usuario do formulario: " + usuario.getSenhaForm());

		if (!usuario.getSenhaForm().trim().isEmpty()){
			log.info("Senha: " +  usuario.getSenhaForm());
			UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService) ;
			usuarioValidator.validate(usuario,result);			
		}
		
		if (result.hasErrors()){
			model.addAttribute("permissoes", permissaoRepository.findAll());
			return "usuario/formUsuarioAtual";
		}
		log.info("Editando usuario do formulario ");
		usuarioService.update(usuario);
        return "redirect:/usuarios";
    }
}
