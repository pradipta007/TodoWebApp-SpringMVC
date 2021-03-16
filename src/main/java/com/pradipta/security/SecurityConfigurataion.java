package com.pradipta.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//Security Congig- Simple code

@Configuration
@EnableWebSecurity
public class SecurityConfigurataion {

	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		//anybody logging with below id and pass is authentic req and are user and admin both roles given
		
		@Autowired
		public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
				throws Exception {
			auth.inMemoryAuthentication().withUser("pradipta").password("dummy")
					.roles("USER", "ADMIN");
		}

		//permit all (user,admin) for login page (/login is a page that spring security already has developed)
		// "/todo" allow users which have ROLE as USER 
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/login").permitAll()
					.antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
					.formLogin();
		}
	}
	
}
