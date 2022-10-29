package br.com.paixaonordestina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.paixaonordestina.model.Funcionario;
import br.com.paixaonordestina.model.UF;
import br.com.paixaonordestina.repository.CargoRepository;
import br.com.paixaonordestina.repository.FuncionarioRepository;
import br.com.paixaonordestina.utils.SenhaUtils;

/**
 * Controle de funcionarios.
 * 
 * @author Israel
 *
 */
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	/**
	 * Anotação para a interface de funcionario, onde pode ser usados os metodos
	 * create, read, update e delete.
	 */
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	/**
	 * Anotação para a interface de funcionario, onde pode ser usados os metodos
	 * create, read, update e delete.
	 */
	@Autowired
	private CargoRepository cargoRepository;

	/**
	 * Lista de funcionarios
	 * 
	 * @return
	 */
	@RequestMapping("/listar")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("funcionario/lista");

		modelAndView.addObject("funcionarios", funcionarioRepository.findAll());

		return modelAndView;
	}

	/**
	 * Pagina de cadastro do funcionario com os metodos de cargo e UF (estado).
	 * 
	 * @return
	 */
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("funcionario/cadastro");

		modelAndView.addObject("funcionario", new Funcionario());
		modelAndView.addObject("cargos", cargoRepository.findAll());
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	/**
	 * Cadastro o funcionario no banco de dados.
	 * 
	 * @param funcionario
	 * @return
	 */
	@PostMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario, RedirectAttributes attributes) {
		String senhaEncriptada = SenhaUtils.encode(funcionario.getSenha());
		funcionario.setSenha(senhaEncriptada);
		
		funcionarioRepository.save(funcionario);
		attributes.addFlashAttribute("mensagem", "Funcionario salvo com sucesso!");
		return "redirect:/funcionarios/cadastrar";
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
		ModelAndView modelAndView = new ModelAndView("funcionario/cadastro");

		modelAndView.addObject("funcionario", funcionarioRepository.getReferenceById(id));
		modelAndView.addObject("cargos", cargoRepository.findAll());
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	/**
	 * Salva a edição realizada sem alterar a senha cadastrada.
	 * 
	 * @param funcionario
	 * @param id
	 * @return
	 */
	@PostMapping("/{id}/editar")
	public String editar(Funcionario funcionario, @PathVariable Long id, RedirectAttributes attributes) {
		String senhaAtual = funcionarioRepository.getReferenceById(id).getSenha();

		funcionario.setSenha(senhaAtual);
		funcionarioRepository.save(funcionario);
		attributes.addFlashAttribute("mensagem", "Funcionário atualizado com sucesso!");
		return "redirect:/funcionarios/listar";
	}

	/**
	 * Exclui o funcionario recebendo o ID como parametro.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);

		return "redirect:/funcionarios/listar";
	}

}
