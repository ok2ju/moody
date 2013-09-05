package com.mteam.moody.configuration.web.security;

import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@ImportResource({"/WEB-INF/config/security.xml"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
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
				.loginPage("/login.html")
				.failureUrl("/login.html?error")
				.permitAll();
	}
	
	/*@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("oleg").password("oleg").roles("USER");
	}*/
	
	/*@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return (AuthenticationManager) new AuthenticationManagerBuilder().userDetailsService(userDetailsService()).and().build();
	}
	
	@Bean(name="myUserDetailsService")
	protected UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}*/
}