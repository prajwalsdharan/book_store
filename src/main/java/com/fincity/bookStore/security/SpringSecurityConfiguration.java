package com.fincity.bookStore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}userSecret").roles("USER")
		.and()
		.withUser("admin").password("{noop}adminSecret").roles("USER", "ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		//HTTP Basic authentication
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/book-store/rest/v1.0/books/**").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/book-store/rest/v1.0/books/add").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/book-store/rest/v1.0/books/delete/**").hasRole("ADMIN")
		.and()
		.csrf().disable()
		.formLogin().disable();
	}

}


