
package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter 
{

	// add a reference to our security data source
	
		@Autowired
		@Qualifier("securityDataSource")
		private DataSource securityDataSource;
			
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			// use jdbc authentication ... oh yeah!!!		
			auth.jdbcAuthentication().dataSource(securityDataSource);
			
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.authorizeRequests()
				.antMatchers("/employees/showForm*").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers("/employees/delete").hasRole("ADMIN")
				.antMatchers("/employees/**").hasRole("EMPLOYEE")
				.antMatchers("/resources/**").permitAll()
				.and()
				.formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
			
		}
	
	
	
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("adam").password("test123").roles("EMPLOYEE", "MANAGER"))
				.withUser(users.username("henry").password("test123").roles("EMPLOYEE", "ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/employees/showForm*").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers("/employees/delete").hasRole("ADMIN")
		.antMatchers("/employees/**").hasRole("EMPLOYEE")
		.antMatchers("/home/**").hasRole("ADMIN")
		.antMatchers("/resources/**").permitAll()
		.and()
		.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	

	}*/

}
