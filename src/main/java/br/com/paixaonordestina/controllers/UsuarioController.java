package br.com.paixaonordestina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	// Abrir pagina de login
	@GetMapping("/login")
	public String logar() {
		return "usuario/login";
	}

}
