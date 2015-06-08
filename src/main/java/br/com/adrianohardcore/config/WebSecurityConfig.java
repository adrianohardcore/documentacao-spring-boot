package br.com.adrianohardcore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/login").permitAll()
				.antMatchers("/hello/**").hasRole("ADMIN")				
				.antMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
            	.logoutUrl("/logout")
            	.logoutSuccessUrl("/")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        
    }
	


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {				
		auth
			.inMemoryAuthentication()
				.withUser("user").password("user").roles("USER").and()
				.withUser("admin").password("admin").roles("USER", "ADMIN");				
    }	
	
	
	// @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        // userDetailsService.setDataSource(datasource);
        // PasswordEncoder encoder = new BCryptPasswordEncoder();
 
        // auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        // auth.jdbcAuthentication().dataSource(datasource);
 
        // if(!userDetailsService.userExists("user")) {
            // List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            // authorities.add(new SimpleGrantedAuthority("USER"));
            // User userDetails = new User("user", encoder.encode("password"), authorities);
 
            // userDetailsService.createUser(userDetails);
        // }
    // }
}