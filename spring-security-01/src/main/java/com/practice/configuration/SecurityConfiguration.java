package com.practice.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated()); // This is going to authenticate all the http requests
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll()); // This is going to permit all the http requests
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll()); // This is going to deny all the http requests
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((requests)-> 
								requests.requestMatchers("/myAccount","/myCards","/myBalance","/myLoans").authenticated()
										.requestMatchers("/notices","/contact","/error","/register").permitAll()); // Permiting only general pages for all
		/**
		 * formLogin helps to open the login screen in the browser and send the
		 * appropriate user creadentails. We can also disable it, if we disable it it
		 * will be redirected to browser window of login page in that case it uses
		 * BasicAuthenticationFilter for preparing the user object and performing
		 * authentication and authorization activities.
		 */
//		http.formLogin(flc -> flc.disable()); //This is to disable formLogin , FLC -> FormLoginConfigurer
		http.formLogin(withDefaults());
		/**
		 * We can also disable httpBasic login, but if we disable both formLogin and
		 * httpBasic at a time then spring security can't handle to input so browser
		 * throws the exception while trying to get the login page only.
		 */
//		http.httpBasic(hbc -> hbc.disable());
		http.httpBasic(withDefaults());
		return http.build();
	}
	

	/**
	 * If we want to have an multiple users for accessing the application we can't
	 * have it using the properties so we can create multiple users using the
	 * UserDetailsService implementation as below
	 */
//	@Bean /** Commenting this as we are step forward to get the user credentails from the database **/
	public UserDetailsService userDetails() {
		/**
		 * By default when we are creating bean for users spring security won't be
		 * having an password encoder so i'm setting as {noop} prefix of password to
		 * inform as we don't need password encoder.
		 */
		UserDetails userDeatils1 = User.builder().username("user").password("{noop}Reddy@54321").build();
//		54321 --> $2a$12$weKb1I2vr/i.w0xuw4jaS.gXt2GvLJ3nG33XVKS9PuF0pWPdA6YDi
		UserDetails userDeatils2 = User.builder().username("admin").password("{bcrypt}$2a$12$CWbuRVt.NIEWQ5caRmrIreT.ONykFKnGVedvNoNtnWJG0oBqI/ZMC").build();
		return new InMemoryUserDetailsManager(userDeatils1, userDeatils2);
	}
	
//	@Bean
	public UserDetailsService userDetails(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	/**
	 * This bean is used to check weather the user provided password is strong or can be leaked.
	 * @return
	 */
	@Bean
	public CompromisedPasswordChecker compromisedPasswordChecker() {
		return new HaveIBeenPwnedRestApiPasswordChecker();
	}
}