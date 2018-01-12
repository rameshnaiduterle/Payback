package com.softpath.paybackpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;


/**
 * @author Ramesh Naidu @softpath
 * This is the main Spring boot configured Class.
 * 
 * Methods in this services
 *  1. configure - Used for Deploying builded war in External Servers
 *  2. authenticationManager - Used for basic authentication for accessing PAYBACK LMS
 *  3. Main method - Used for starting the Spring Boot application. 
 * 
 * @category Configuration
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.softpath.paybackpoc"})
public class PaybackPocBootApplication extends SpringBootServletInitializer  {

	/**
	 * This method is to deploy the builded war into external server 
	 * 
	 * If it is prefer to RUN an embedded container, we don't require the method
	 * we can comment it out.
	 * 
	 * Input parameters - SpringApplicationBuilder 
	 */
	@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(PaybackPocBootApplication.class);
	}
	
	/**
	 * @param builder
	 * 
	 * Method - Authenticating the user from accessing the PAYBACK application.
	 *  
	 * Currently it provides -IN-Memory authentication with password as static 
	 */

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
	}
	
	
	
	/**
	 * 
	 * @param args
	 * Main method to start the Spring Boot Application
	 */
	public static void main(String[] args) {
		SpringApplication.run(PaybackPocBootApplication.class, args);
	}
	
	
	
	

}
