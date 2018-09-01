package com.pmv.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled= true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("authService")
	private UserDetailsService authService;
	
	@Autowired
	public void COnfigureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/*", "/imgs/*","/js/*","/vendors/**").permitAll()
			.anyRequest().authenticated()
			.and()
			
			.formLogin().loginPage("/admin/login").loginProcessingUrl("/admin/logincheck")
			.usernameParameter("username").passwordParameter("password").permitAll()
			.defaultSuccessUrl("/admin/index").permitAll()
			.and()
			.logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/login")
			.permitAll();
		
		super.configure(http);
	}
	
	

}
