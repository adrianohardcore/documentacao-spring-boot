package br.com.adrianohardcore;

/* import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter; */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/* @EnableAutoConfiguration
@Configuration
@ComponentScan
@SpringBootApplication */
@SpringBootApplication
public class App {

	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

/* 	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	} */

/* 	@Bean
	@ConditionalOnMissingBean(HiddenHttpMethodFilter.class)
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	} */


}
