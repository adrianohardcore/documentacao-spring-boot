package br.com.adrianohardcore.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
 
@Controller
class HomeController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	// final UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
 
    @RequestMapping("/")
    String index() {
		log.info("Teste");		
        return "home";
    }
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        log.info("Getting login page, error={}", error);
        return new ModelAndView("login", "error", error);
    }	
    
	@RequestMapping(value = "/logout")
 	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login?message="+message;
	}
}