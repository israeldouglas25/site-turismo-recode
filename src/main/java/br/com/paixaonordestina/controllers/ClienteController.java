package br.com.paixaonordestina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.paixaonordestina.model.Cliente;
import br.com.paixaonordestina.model.UF;
import br.com.paixaonordestina.repository.ClienteRepository;

/**
 * Controle de clientes.
 * 
 * @author Israel
 *
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

	/**
	 * Anotação para a interface de cliente, onde pode ser usados os metodos
	 * create, read, update e delete.
	 */
	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Lista de clientes
	 * 
	 * @return
	 */
	@RequestMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cliente/lista");

		modelAndView.addObject("clientes", clienteRepository.findAll());

		return modelAndView;
	}

	/**
	 * Pagina de cadastro do cliente.
	 * 
	 * @return
	 */
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

		modelAndView.addObject("cliente", new Cliente());
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	/**
	 * Retorna os campos preenchido com as informações cadastradas através do
	 * parametro do ID selecionado.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

		modelAndView.addObject("cliente", clienteRepository.getReferenceById(id));
		modelAndView.addObject("ufs", UF.values());
		
		return modelAndView;
	}

	/**
	 * Cadastro o cliente no banco de dados.
	 * 
	 * @param cliente
	 * @return
	 */
	@PostMapping("/cadastrar")
	public String cadastrar(Cliente cliente, RedirectAttributes attributes ) {

		clienteRepository.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return "redirect:/clientes/cadastrar";
	}

	/**
	 * Salva a edição realizada sem alterar a senha cadastrada.
	 * 
	 * @param cliente
	 * @param id
	 * @return
	 */
	@PostMapping("/{id}/editar")
	public String editar(Cliente cliente, @PathVariable Long id) {
		String senhaAtual = clienteRepository.getReferenceById(id).getSenha();
		cliente.setSenha(senhaAtual);

		clienteRepository.save(cliente);

		return "redirect:/clientes/cadastrar";
	}

	/**
	 * Exclui recebendo o ID como parametro.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		clienteRepository.deleteById(id);

		return "redirect:/clientes/listar";
	}

}
