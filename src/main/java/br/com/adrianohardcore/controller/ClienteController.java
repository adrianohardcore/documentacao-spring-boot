package br.com.adrianohardcore.controller;


import br.com.adrianohardcore.model.Cliente;
import br.com.adrianohardcore.repository.ClienteRepository;
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
import org.springframework.ui.ModelMap;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasRole('USER')")
public class ClienteController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired    
	public ClienteRepository repo;

	@RequestMapping(value = "/clientelista", method = RequestMethod.GET)
	public String index() {
		log.info("Pagina inicial cliente!");
		return "/cliente/index"; 
	}

    private Integer page = 0;
    private Integer pageTotal = 0;
 
	@RequestMapping(value = "/clientes",method = RequestMethod.GET , produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Cliente> findItems() {
		String sord = "nomecliente";
		String sidx = "ASC";
		page++;
		Integer rows = 50;


		//Order order = new Order(Direction.fromString(sord.toLowerCase()),sidx);
		Sort sort = new Sort(sord);
		//Pageable pageRequest = new PageRequest(page - 1, rows, sort);
        Pageable pageRequest = new PageRequest(page - 1, rows, sort);
		Page<Cliente> clientes = repo.findAll(pageRequest);
		//Map<String,Object> modelMap = new HashMap<String,Object>();


        if (page >= clientes.getTotalPages() ){
            page = 1;
        }


        log.info("page: " + page.toString() + " rows: " + rows.toString() + " totalPages: " + clientes.getTotalPages() + " totalRows: " + clientes.getTotalElements()     );



		//List<Cliente> clientes = repo.findAll();
		//return clientes.getContent();
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
