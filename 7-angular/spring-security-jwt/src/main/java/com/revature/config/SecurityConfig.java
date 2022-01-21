package com.revature.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.revature.filter.JwtFilter;
import com.revature.service.CustomUserDetailsService;

/**
 * We can customize the security configuration of the Spring Security Context
 * by writing our own authorization and authentication. For this create a 
 * a SecurityConfig class that extends the WebSecurityConfigurerAdapter 
 * and overrides its methods.
 * 
 * In order to access ANY link in our application, a User must be logged in.
 * A user can only be logged in (a.k.a authenticated) by first passing 
 * the /authenticate controller.
 */
@Configuration
@EnableWebSecurity
// possibility to include @CrossOrigin("http://localhost:4200");
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
	/**
	 * WebSecurityConfigureAdapater requires us to override
	 * the same method twice:  
	 * 
	 * - The First takes in AuthenticationManagerBuilder
	 * - The Second takes in HttpSecurity object
	 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * WHEN CORS STRIKES! -> https://www.baeldung.com/spring-security-cors-preflight
     * 
     * We haven't explicitly excluded the preflight requests from authorization 
     * in our Spring Security configuration. Remember that Spring Security secures 
     * all endpoints by default.  As a result, our API expects an authorization token 
     * in the OPTIONS request as well. Spring provides an out of the box solution to 
     * exclude OPTIONS requests from authorization checks:
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors(); // The cors() method will add the Spring-provided CorsFilter to 
        http.csrf()  // the application context which in turn bypasses the authorization
        .disable()   // checks for OPTIONS requests.
        .authorizeRequests()
        .antMatchers("/authenticate")
        .permitAll().antMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll().anyRequest().authenticated()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
// 	resp.setHeader("Access-Control-Allow-Origin", "*");
//         resp.setHeader("Access-Control-Allow-Credentials", "true");
//         resp.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT,DELETE,PATCH");
//         resp.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
//         chain.doFilter(req, resp);	
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
