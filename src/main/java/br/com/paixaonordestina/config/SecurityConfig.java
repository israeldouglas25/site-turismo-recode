package br.com.paixaonordestina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
		.csrf().disable()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/destino").permitAll()
        .antMatchers("/promocao").permitAll()
        .antMatchers("/contatos/cadastrar").permitAll()
        .antMatchers("/clientes/cadastrar").permitAll()
        .antMatchers("/funcionarios/cadastrar").permitAll()
        .antMatchers("/blog/**").hasRole("USER")
        .anyRequest().authenticated()
        .and()
        	.formLogin()
        	.loginPage("/login")
        	.defaultSuccessUrl("/", true)
        	.failureUrl("/login-erro")
        	.permitAll()
        .and()
        	.logout()
        	.logoutSuccessUrl("/")
        .and().httpBasic()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().build();
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                           .antMatchers("/img/**", "/css/**", "/js/**");     
    }
	

}
