package controllers;

import java.util.stream.Stream;

import dao.ContatoDAO;
import model.Contato;

public class teste {

	public static void main(String[] args) {
		//CardDAO cardDAO = new CardDAO();
		//UsuarioDAO uDAO = new UsuarioDAO();
		ContatoDAO contatoDAO = new ContatoDAO();

		int id = 0;
		//int posicao = 2;
		//double preco = 400;
		/*
		 * String nome = "Douglas"; String email = "douglas@email"; String telefone =
		 * "2222-3333"; String mensagem = "minha segunda mensagem";
		 * 
		 * Contato contato = new Contato(id, nome, email, telefone, mensagem);
		 * contatoDAO.save(contato);
		 */

		// CREATE
		// Card card3 = new Card(id, nome, preco);
		// cardDAO.save(card3);

		// UPDATE
		// Card atualizarCard = new Card(posicao, nome, preco);
		// cardDAO.update(atualizarCard);

		// LIST
		
		  //for(Card c : cardDAO.getCard()) { System.out.println("ID: "+ c.getId() +
		  //"\nNOME: "+ c.getNome() + "\nPRECO: "+ c.getPrecoPromocao()); }
		 
			/*
			 * for(Usuario c : uDAO.getUsuario()) { System.out.println("ID: "+ c.getId() +
			 * "\nNOME: "+ c.getNome() + "\nE-MAIL: "+ c.getEmail() + "\nSENHA: "+
			 * c.getSenha() + "\nPERMISSÃO: "+ c.getPermissoes().getId()); }
			 */
		// LIST BY ID
		//Card busca = cardDAO.getCardById(posicao);
		//System.out.println("ID: " + busca.getId() + "\nNOME: " + busca.getNome() + "\nPRECO: " + busca.getPrecoPromocao());

		
		for(Contato c : contatoDAO.getContato()) { System.out.println("ID: "+ c.getId() +
				  "\nNOME: "+ c.getNome() + "\nEMAIL: "+ c.getEmail() + "\nTELEFONE: "+ c.getTelefone() + "\nMSG: "+ c.getMensagem()); }
	}
	

}
