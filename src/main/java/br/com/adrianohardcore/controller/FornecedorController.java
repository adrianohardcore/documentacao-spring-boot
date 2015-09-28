package br.com.adrianohardcore.controller;


import br.com.adrianohardcore.model.Fornecedor;
import br.com.adrianohardcore.model.QFornecedor;
import br.com.adrianohardcore.repository.FornecedorRepository;
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

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
@PreAuthorize("hasRole('ADMIN')")
public class FornecedorController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public FornecedorRepository fornecedorRepository;

    @RequestMapping(value = "/fornecedor", method = RequestMethod.GET)
    public String lista() {
        return "/fornecedor/lista";
    }

    @RequestMapping(value = "/fornecedores", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> findItems(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "sort", required = false) String psort,
            @RequestParam(value = "order", required = false) String porder,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "filter", required = false) String filter
    ) {
        Integer page = (offset / limit);
        log.info("filter: " + filter);
        Map<String, String> example = jsonToMap(filter);
        Pageable pageRequest = new PageRequest(page, limit, Direction.fromString(porder), psort);
        log.info("limit: " + limit.toString() + " offset: " + offset.toString() + " totalPages: " + page + " order: " + porder + " psort: " + psort + " search: " + search);
        QFornecedor fornecedor = QFornecedor.fornecedor;
        BooleanBuilder where = new BooleanBuilder();
        if (search != null) {
            if (filter != null) {
                for (Map.Entry<String, String> entry : example.entrySet()) {
                    log.info("coluna: " + entry.getKey() + " valor: " + entry.getValue());
                    if (entry.getKey() == "idfornecedor" && StringUtils.isNumeric(entry.getValue()))
                        where.or(fornecedor.idfornecedor.eq(Integer.parseInt(entry.getValue())));
                    if (entry.getKey() == "nomefornecedor")
                        where.or(fornecedor.nomefornecedor.containsIgnoreCase(entry.getValue()));
                    if (entry.getKey() == "nomefantasia")
                        where.or(fornecedor.nomefantasia.containsIgnoreCase(entry.getValue()));
                }
            } else {
                if (StringUtils.isNumeric(search))
                    where.or(fornecedor.idfornecedor.eq(Integer.parseInt(search)));
                where.or(fornecedor.nomefornecedor.containsIgnoreCase(search));
                where.or(fornecedor.nomefantasia.containsIgnoreCase(search));
            }
        }
        Page<Fornecedor> fornecedores = fornecedorRepository.findAll(where, pageRequest);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("total", fornecedores.getTotalElements());
        modelMap.put("rows", fornecedores.getContent());
        return modelMap;
    }

    @RequestMapping(value = "/fornecedor/form", method = RequestMethod.GET)
    public String form(Model model) {
        log.info("Formulario de cadastro de fornecedor");
        model.addAttribute("fornecedor", new Fornecedor());
        return "/fornecedor/form";
    }

    @Transactional
    @RequestMapping(value = "/fornecedor/form", method = RequestMethod.POST)
    public String formSave(@Valid Fornecedor fornecedor, BindingResult result) {
        if (result.hasErrors())
            return "/fornecedor/form";
        fornecedorRepository.save(fornecedor);
        return "redirect:/fornecedor";
    }

    private Map<String, String> jsonToMap(String json) {
        //String json = "{\"name\":\"mkyong\", \"age\":\"29\"}";
        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            //convert JSON string to Map
            map = mapper.readValue(json,
                    new TypeReference<HashMap<String, String>>() {
                    });
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
