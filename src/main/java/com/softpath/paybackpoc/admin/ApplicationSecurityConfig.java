package com.softpath.paybackpoc.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
* 
* 
* 
 * @author Ramesh Naidu
 * @Category Security configurations.
 * Reference Link - Reference Link - https://projects.spring.io/spring-security-oauth/docs/oauth2.html
 *
 */
@Configuration
@EnableAuthorizationServer
public class ApplicationSecurityConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	private final Logger logger = Logger.getLogger(ApplicationSecurityConfig.class);
	
	
	/**
	 * 	This method is to define the authorization and token endpoints and the token services.
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endPoints) throws Exception {
		endPoints.authenticationManager(authenticationManager);
	}

	/** 
	 * This method is used for Configuring AuthorizationSecuirty for accessing tokens,
	 * if the user is authenticated then only we can access the tokens.
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAuthenticated()");
	}

	
	/**
	 * This method provides Clien Details Config info. 
	 * 
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		logger.info("Trusted Client");
		clients.inMemory().withClient("my-trusted-client")
						.authorizedGrantTypes("client_credentials","password")
						.authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
						.scopes("read","write","trust")
						.resourceIds("oauth2-resource")
						.accessTokenValiditySeconds(1000)
						.secret("secret").authorizedGrantTypes("refresh_token","password","client_credentials");
	}
	
}
