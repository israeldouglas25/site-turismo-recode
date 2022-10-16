package br.com.paixaonordestina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

	@GetMapping("/")
	public String Home() {
		return "index";
	}

	@GetMapping("/destino")
	public String destino() {
		return "destino/destino";
	}

	@GetMapping("/promocao")
	public String promocao() {
		return "promocao";
	}

	@GetMapping("/cadastrar")
	public String cadastro() {
		return "cliente/cadastrar";
	}

	@GetMapping("/login")
	public String logar() {
		return "login";
	}

}
