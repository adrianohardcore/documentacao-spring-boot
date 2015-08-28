package br.com.adrianohardcore.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.security.Principal;
import java.util.Optional;

@Controller
class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(Principal principal) {
        log.info("Pagina inicial!");
        return "home";
    }

    @RequestMapping("/403")
    public String unauthorized() {
        log.info("Usuario nao autorizado!");
        return "403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        log.info("Entrando na pagina de login ", error);
        return new ModelAndView("login", "error", error);
    }

    @RequestMapping(value = "/logout")
    public String logoutSuccess() {
        String message = "Desconectado com sucesso!";
        log.info(message);
        return "redirect:/login?message="+ message;
    }
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception e) {
		return "return error object instead";
	}
	

}