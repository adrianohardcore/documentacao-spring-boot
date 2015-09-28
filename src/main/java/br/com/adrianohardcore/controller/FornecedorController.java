package br.com.adrianohardcore.controller;


import br.com.adrianohardcore.model.Cliente;
import br.com.adrianohardcore.model.Fornecedor;
import br.com.adrianohardcore.model.QFornecedor;
import br.com.adrianohardcore.repository.FornecedorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.apache.xpath.functions.FuncConcat;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;


import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.apache.commons.lang3.StringUtils;


@Controller
@PreAuthorize("hasRole('ADMIN')")
public class FornecedorController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired    
	public FornecedorRepository fornecedorRepository;
	
 	@RequestMapping(value = "/fornecedor", method = RequestMethod.GET)	
	public String lista(){				
		return "/fornecedor/lista";
	}
    
    @RequestMapping(value = "/fornecedores",method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map<String,Object> findItems(
        //return fornecedorRepository.findAll(
			@RequestParam(value="search",required=false) String search,
			@RequestParam(value="sort",required=false) String psort,
			@RequestParam(value="order",required=false) String porder,
			@RequestParam(value="limit",required=false) Integer limit,
			@RequestParam(value="offset",required=false) Integer offset,
            @RequestParam(value="filter",required=false) String filter

			
		)
		{
		Integer page = (offset / limit) ;

            log.info("filter: " + filter);

            Map<String,String> example = jsonToMap(filter);


            //{"nomefornecedor":"LOJA","nomefantasia":"BARB"}
            //{"nomefornecedor":"LOJA"}

            //String[] campo = filter.split('',");




		//Order order = new Order(Direction.fromString(psort.toLowerCase()),porder);	
		
		//Sort sort = new Sort(porder);



			
			
	    Pageable pageRequest = new PageRequest( page,limit,Direction.fromString(porder),psort);
		//Pageable pageRequest = new PageRequest( page,limit,Sort.Direction.DESC,psort);
		log.info("limit: " + limit.toString() + " offset: " + offset.toString() + " totalPages: " + page + " order: " + porder + " psort: " + psort + " search: " + search);
		Page<Fornecedor> fornecedores;

            QFornecedor fornecedor = QFornecedor.fornecedor;
            BooleanBuilder where = new BooleanBuilder();
            if (search != null) {
                if (filter != null){
                    for (Map.Entry<String, String> entry : example.entrySet())
                    {
                        log.info("coluna: " + entry.getKey() + " valor: " + entry.getValue());
                        if (entry.getKey() == "idfornecedor")
                            where.and(fornecedor.idfornecedor.eq(Integer.parseInt(entry.getValue())));
                        if (entry.getKey() == "nomefornecedor")
                            where.and(fornecedor.nomefornecedor.equalsIgnoreCase(entry.getValue()));
                        if (entry.getKey() == "nomefantasia")
                            where.and(fornecedor.nomefantasia.equalsIgnoreCase(entry.getValue()));
                    }
                }
                else {
                    where.or(fornecedor.nomefornecedor.containsIgnoreCase(search));
                    where.or(fornecedor.nomefantasia.containsIgnoreCase(search));
                }
            }
            fornecedores = fornecedorRepository.findAll(where,pageRequest);
		
//		if (StringUtils.isEmpty(search) ){
//			fornecedores = fornecedorRepository.findAll(pageRequest);
            //fornecedores = fornecedorRepository.fullTextSearch("%" + search + "%",pageRequest);
//		}
//		else
	//	{








			//users = userRepository.findByNameLike("%" + search + "%",pageRequest);
			//fornecedores = fornecedorRepository.fullTextSearch("%" + search + "%",pageRequest);
			//fornecedores = fornecedorRepository.findByNomefornecedorLikeIgnoreCaseOrNomefantasiaLikeIgnoreCase("%" + search + "%", "%" + search + "%",pageRequest);
            //fornecedores = fornecedorRepository.fullTextSearch("%" + search + "%",pageRequest);

            //QFornecedor fornecedor = QFornecedor.fornecedor;
            //Predicate consulta1 =  //fornecedor.nomefornecedor.like(search);
            //fornecedores = fornecedorRepository.findAll(fornecedor.nomefornecedor.containsIgnoreCase(search).or(fornecedor.nomefantasia.containsIgnoreCase(search)),pageRequest);

            //Predicate predicate =  fornecedor.nomefornecedor.containsIgnoreCase(search);
            //predicate = fornecedor.nomefantasia.containsIgnoreCase(search);
            //fornecedores = fornecedorRepository.findAll(predicate,pageRequest);

//            QFornecedor fornecedor = QFornecedor.fornecedor;
//            BooleanBuilder where = new BooleanBuilder();
//            if (search != null) {
//                where.or(fornecedor.nomefornecedor.containsIgnoreCase(search));
//                where.or(fornecedor.nomefantasia.containsIgnoreCase(search));
//            }
//            fornecedores = fornecedorRepository.findAll(where,pageRequest);
//            if (lastName != null) {
//                where.and(employee.lastName.eq(lastName));
//            }



            //QUser user = QUser.user;
            //Page<User> page =  userRepository.findAll(user.name.like(name).and(user.age.eq(age)), new PageRequest(0,10));

             //.endsWith("z");
            //fornecedores = fornecedorRepository.findAll(consulta1,pageRequest);




			//log.info("pesquisa: " + search + " registros: " + fornecedores.getTotalElements() );
//		}
		

		
	
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("total", fornecedores.getTotalElements());
		modelMap.put("rows", fornecedores.getContent());
        return modelMap;
    }
	
		// @Transactional
	// @RequestMapping(value="/userlist", produces="application/json")
	// public @ResponseBody Map<String,Object> listJqGrid(
			// @RequestParam("_search") Boolean search,
    		// @RequestParam(value="filters", required=false) String filters,
    		// @RequestParam(value="page", required=false) Integer page,
    		// @RequestParam(value="rows", required=false) Integer rows,
    		// @RequestParam(value="sidx", required=false) String sidx,
    		// @RequestParam(value="sord", required=false) String sord	
	
	
	

	@RequestMapping(value = "/fornecedor/form", method = RequestMethod.GET)
	public String form(Model model){
		log.info("Formulario de cadastro de fornecedor");
		model.addAttribute("fornecedor", new Fornecedor());
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

    private Map<String, String> jsonToMap(String json){
        //String json = "{\"name\":\"mkyong\", \"age\":\"29\"}";

        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            //convert JSON string to Map
            map = mapper.readValue(json,
                    new TypeReference<HashMap<String,String>>(){});
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;

    }
	
	
	
	

}
