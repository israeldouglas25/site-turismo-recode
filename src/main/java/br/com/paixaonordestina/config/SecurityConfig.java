package br.com.paixaonordestina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import br.com.paixaonordestina.service.FuncionarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
		.csrf().disable()
        .authorizeRequests()
        .antMatchers("/**").permitAll()
//        .antMatchers("/destino").permitAll()
//        .antMatchers("/promocao").permitAll()
//        .antMatchers("/contatos/cadastrar").permitAll()
//        .antMatchers("/clientes/cadastrar").permitAll()
//        .antMatchers("/**").hasAnyAuthority()
        .antMatchers("/blog/**").hasRole("USER")
        .anyRequest().authenticated()
        .and()
        	.formLogin()
        	.loginPage("/usuario/login")
        	.defaultSuccessUrl("/", true)
        	.failureUrl("/usuario/login")
        	.permitAll()
        .and()
        	.logout()
        	.logoutSuccessUrl("/")
        .and().httpBasic()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .build();
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                           .antMatchers("/img/**", "/css/**", "/js/**");     
    }
	
	
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//	}
//
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(funcionarioService).passwordEncoder(new BCryptPasswordEncoder());
//	}
	
}
