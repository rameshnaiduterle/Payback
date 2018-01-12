/**
 * 
 */
package com.softpath.paybackpoc.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Ramesh Naidu 
 * 
 * @created on 1.10.2018
 *
 */
@Configuration
@EnableResourceServer
public class ResourceConfigurer extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/payback/**").authenticated().and().formLogin().disable().httpBasic().disable();
	}

	
	
	
	
}
