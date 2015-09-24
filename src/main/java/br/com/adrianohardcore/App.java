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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import java.util.List;


/* @EnableAutoConfiguration
@Configuration
@ComponentScan
@SpringBootApplication */
@SpringBootApplication
public class App {

	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
		return new ShallowEtagHeaderFilter();
	}

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		final ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//		converter.setObjectMapper(objectMapper);
//		converters.add(converter);
//		super.configureMessageConverters(converters);
//	}


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
