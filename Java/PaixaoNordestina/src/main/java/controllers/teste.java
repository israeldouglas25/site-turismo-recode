package controllers;

import dao.CardDAO;
import dao.UsuarioDAO;
import model.Card;
import model.Usuario;

public class teste {

	public static void main(String[] args) {
		CardDAO cardDAO = new CardDAO();
		UsuarioDAO uDAO = new UsuarioDAO();

		int id = 0;
		int posicao = 2;
		String nome = "Bahia";
		double preco = 400;

		// CREATE
		// Card card3 = new Card(id, nome, preco);
		// cardDAO.save(card3);

		// UPDATE
		// Card atualizarCard = new Card(posicao, nome, preco);
		// cardDAO.update(atualizarCard);

		// LIST
		
		  //for(Card c : cardDAO.getCard()) { System.out.println("ID: "+ c.getId() +
		  //"\nNOME: "+ c.getNome() + "\nPRECO: "+ c.getPrecoPromocao()); }
		 
		  for(Usuario c : uDAO.getUsuario()) { System.out.println("ID: "+ c.getId() +
				  "\nNOME: "+ c.getNome() + "\nE-MAIL: "+ c.getEmail() + "\nSENHA: "+ c.getSenha() + "\nPERMISSÃO: "+ c.getPermissoes().getId()); }

		// LIST BY ID
		//Card busca = cardDAO.getCardById(posicao);
		//System.out.println("ID: " + busca.getId() + "\nNOME: " + busca.getNome() + "\nPRECO: " + busca.getPrecoPromocao());

	}

}
