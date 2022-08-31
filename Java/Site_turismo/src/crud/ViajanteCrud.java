package crud;

import dao.ViajanteDAO;
import model.Viajante;

public class ViajanteCrud {

	public static void main(String[] args) {
		ViajanteDAO viajanteDAO = new ViajanteDAO();
		
		int id = 0;
		
		String nome = "Ferreira";
		String email = "ferreira@email";
		int idade = 51;
		String logradouro = "Rua X numero 10";
		String bairro = "teste";
		String cidade = "qualquer";
		String estado = "RJ";
		String telefone = "2222222";
		
		Viajante v1 = new Viajante(id, nome, email, idade, logradouro, bairro, cidade, estado, telefone);
		
		viajanteDAO.save(v1);
		System.out.println("\n***  Cadastrou  ***\n");

	}

}
