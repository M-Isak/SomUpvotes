package com.somupvotes.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class webSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
    public PasswordEncoder getPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
;//		auth.inMemoryAuthentication()
//		    .passwordEncoder(getPasswordEncoder())
//		    .withUser("mohamedisak.ali@gmail.com")
//		    .password(getPasswordEncoder().encode("test123"))
//		    .roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		     .authorizeRequests()
		     .antMatchers("/").permitAll()
		     .antMatchers("/images/**").permitAll()
		     .antMatchers("/register").permitAll()
		     .antMatchers("/admin/**").hasRole("ADMIN")
		     .anyRequest().hasRole("USER").and()
		     .formLogin()
		     .loginPage("/login")
		     .permitAll()
		     .defaultSuccessUrl("/dashboard")
		     .and()
		     .logout()
		     .logoutUrl("/logout")
		     .permitAll();
		
	}

}
