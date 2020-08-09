package com.somupvotes.websecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class webSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		    .withUser("mohamedisak.ali@gmail.com")
		    .password("test123")
		    .roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		     .authorizeRequests()
		     .antMatchers("/").permitAll()
		     .antMatchers("/login").permitAll()
		     .anyRequest().hasRole("USER").and()
		     .formLogin()
		     .loginPage("/login")
		     .permitAll()
		     .and()
		     .logout()
		     .logoutUrl("/logout")
		     .permitAll();
		
	}

}
