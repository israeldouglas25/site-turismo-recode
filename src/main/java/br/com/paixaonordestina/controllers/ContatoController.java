package br.com.paixaonordestina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.paixaonordestina.model.Contato;
import br.com.paixaonordestina.repository.ContatoRepository;

/**
 * Controle de contato
 * 
 * @author Israel
 *
 */
@Controller
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;

	/**
	 * Lista todos os contatos na pagina.
	 * 
	 * @return
	 */
	@RequestMapping("/listar")
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("contato/listar");

		List<Contato> contatos = contatoRepository.findAll();
		modelAndView.addObject("contatos", contatos);

		return modelAndView;
	}

	/**
	 * Mostrar a pagina de envio do contato.
	 * 
	 * @return
	 */
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {

		ModelAndView modelAndView = new ModelAndView("contato/cadastrar");

		modelAndView.addObject("contato", new Contato());

		return modelAndView;
	}

	/**
	 * Envia o contato para o banco de dados.
	 * 
	 * @param contato
	 * @return
	 */
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Contato contato) {

		ModelAndView modelAndView = new ModelAndView("redirect:/contatos/cadastrar");

		contatoRepository.save(contato);

		return modelAndView;
	}

	/**
	 * Exclui o contato através do ID passado por parametro.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		ModelAndView modelAndView = new ModelAndView("redirect:/contatos/listar");

		contatoRepository.deleteById(id);

		return modelAndView;

	}

}
