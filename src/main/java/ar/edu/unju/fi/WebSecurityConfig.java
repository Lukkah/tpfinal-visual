package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.trackpersonas.service.LoginUsuarioServiceImp;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	    LoginUsuarioServiceImp userDetailsService;
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**"
    };

	@Autowired
	private AutenticacionSuccessHandler autenticacion;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/", "/home").permitAll()
				//.antMatchers("/gestionUsuarios").access("hasRole('DB')")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				//.defaultSuccessUrl("/gestionUsuarios")
				.successHandler(autenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("nombreUsuario")
				.passwordParameter("password")				
				.and()
			.logout()
				.permitAll();
				//.logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}	
	
	BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    
   
}