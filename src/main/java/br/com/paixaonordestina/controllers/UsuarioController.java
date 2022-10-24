package br.com.paixaonordestina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	// Abrir pagina de login
	@GetMapping("/login")
	public String logar() {
		return "login";
	}

	// Login invalido
	@GetMapping("/login-erro")
	public String logarError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Credenciais invalidas!");
		model.addAttribute("texto", "Email ou senha incorretos, tente novamente.");
		model.addAttribute("subtexto", "Acesso permitido para cadastros ativos.");
		return "login";
	}

}
