package br.com.paixaonordestina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.paixaonordestina.model.Funcionario;
import br.com.paixaonordestina.model.UserDetailsImpl;
import br.com.paixaonordestina.repository.FuncionarioRepository;

@Service
public class FuncionarioService implements UserDetailsService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Funcionario funcionario = funcionarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		
		return new UserDetailsImpl(funcionario);
	}

}
