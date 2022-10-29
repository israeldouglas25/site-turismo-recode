package br.com.paixaonordestina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.paixaonordestina.model.Cargo;
import br.com.paixaonordestina.repository.CargoRepository;

/**
 * Controle da pagina de cargos.
 * 
 * @author Israel
 *
 */
@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	/**
	 * Retornara a lista de cargos cadastrados.
	 * 
	 * @return
	 */
	@RequestMapping("/listar")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("cargo/lista");

		modelAndView.addObject("cargos", cargoRepository.findAll());

		return modelAndView;
	}

	/**
	 * Mostrar a tela para cadastro do cargo.
	 * 
	 * @return
	 */
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cargo/cadastro");

		modelAndView.addObject("cargo", new Cargo());

		return modelAndView;
	}

	/**
	 * Mostra a tela de edição do cargo através do ID.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cargo/cadastro");

		modelAndView.addObject("cargo", cargoRepository.getReferenceById(id));

		return modelAndView;
	}

	/**
	 * Salva o cargo cadastrado ou editado.
	 * 
	 * @param cargo
	 * @return
	 */
	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Cargo cargo, RedirectAttributes attributes) {
		cargoRepository.save(cargo);
		attributes.addFlashAttribute("mensagem", "Cargo salvo com sucesso!");
		return "redirect:/cargos/cadastrar";
	}

	/**
	 * Deleta o cargo através do ID recebido por parametro
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		cargoRepository.deleteById(id);

		return "redirect:/cargos/listar";
	}

}
