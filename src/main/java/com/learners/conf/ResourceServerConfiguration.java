package com.learners.conf;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.learners.security.AjaxLogoutSuccessHandler;
import com.learners.security.AuthoritiesConstants;
import com.learners.security.Http401UnauthorizedEntryPoint;





@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	@Inject
	private Http401UnauthorizedEntryPoint authenticationEntryPoint;

	@Inject
	private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests().antMatchers("/**").permitAll();

		 http.authorizeRequests().antMatchers("/api/**").authenticated().antMatchers("/api/oauth/**").permitAll();

		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().logout()
				.logoutUrl("/logout").logoutSuccessHandler(ajaxLogoutSuccessHandler).and().csrf().disable()
				.headers().frameOptions().disable().and().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**")
				.permitAll().antMatchers("/health/**").permitAll().antMatchers("/register").permitAll()
				.antMatchers("/logs/**").hasAnyAuthority(AuthoritiesConstants.ADMIN)
				.antMatchers("/websocket/tracker").hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/websocket/**")
				.permitAll().antMatchers("/metrics/**").hasAuthority(AuthoritiesConstants.ADMIN)
				.antMatchers("/trace/**").hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/dump/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/shutdown/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/beans/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/configprops/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/info/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/autoconfig/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/env/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/trace/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/liquibase/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/api-docs/**")
				.hasAuthority(AuthoritiesConstants.ADMIN).antMatchers("/protected/**").authenticated();
		
	}
}// End ResourceServerConfiguration ()
