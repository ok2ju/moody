package com.mteam.moody.configuration.web.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeUrls()
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.logout()
				.logoutSuccessUrl("/login.html?logout")
				.logoutUrl("/logout.html")
				.permitAll()
				.and()
			.formLogin()
				.defaultSuccessUrl("/async")
				.loginUrl("/login")
				.failureUrl("/login.html?error")
				.permitAll();
	}

	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("user").roles("USER").and()
				.withUser("admin").password("admin").roles("ADMIN","USER");
	}
}