package com.crud.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	UserDetailsService userDetailsService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		//auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("akashmulik39@gmail.com").password("akash123").authorities("ROLE_ADMIN", "ROLE_USER");
		auth.inMemoryAuthentication().withUser("girish@gmail.com").password("girish123").roles("USER");
	}
	
	@Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
	        .antMatchers("/homePage").access("hasRole('ROLE_USER')")
	        .antMatchers("/myProfile").hasRole("USER")
	        .antMatchers("/viewUsers").access("hasRole('ROLE_ADMIN')")
	        .and()
	        .formLogin().loginPage("/login")
	        .defaultSuccessUrl("/homePage")
	        .failureUrl("/login?error")
	        .usernameParameter("email")
	        .passwordParameter("pswd")
	        .and()
	        .logout()
	        .logoutSuccessUrl("/login?logout")
	        .invalidateHttpSession(true)
	        .and()
	        .csrf()
	        .and()
	        .exceptionHandling()
	        .accessDeniedPage("/accessDenied");
        
    }
}
