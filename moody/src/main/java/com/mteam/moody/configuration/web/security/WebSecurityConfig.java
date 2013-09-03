package com.mteam.moody.configuration.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mteam.moody.configuration.db.MongoDBConfiguration;
import com.mteam.moody.service.UserService;

@EnableWebSecurity
@Import(MongoDBConfiguration.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeUrls()
				.antMatchers("/assets/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.logout()
				.logoutSuccessUrl("/login.html?logout")
				.logoutUrl("/logout.html")
				.permitAll()
				.and()
			.formLogin()
				.defaultSuccessUrl("/index.html")
				.loginUrl("/login.html")
				.failureUrl("/login.html?error")
				.permitAll();
	}
	
	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).and().build();
		System.out.println(auth.getDefaultUserDetailsService().toString());
	}
	
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return (AuthenticationManager) new AuthenticationManagerBuilder().userDetailsService(userDetailsService()).and().build();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		return new UserService();
	}
}