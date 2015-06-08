package br.com.adrianohardcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.http.HttpStatus;

 
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
//	@Override
//	public void customize(ConfigurableEmbeddedServletContainer container) {
//
//		super.customize(container);
//		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
//				"/404.html"));
//		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
//				"/500.html"));
//		//container.addErrorPages(new ErrorPage("/jsp/error.jsp"));
//		//logger.info("Server customized.");
//	}
}
