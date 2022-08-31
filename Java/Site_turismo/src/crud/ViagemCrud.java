package crud;

import dao.ViagemDAO;
import dao.ViajanteDAO;
import model.Viagem;
import model.Viajante;

public class ViagemCrud {

	public static void main(String[] args) {
		ViagemDAO viagemDAO = new ViagemDAO();
		ViajanteDAO viajanteDAO = new ViajanteDAO();
		
		int id = 0;
		String origem = "Rio de Janeiro";
		String destino = "Fernando de Noronha";
		String data_ida = "30/08/2022";
		String data_volta = "04/09/2022";
		int qtd_viajantes = 4;
		int qtd_quartos = 2;
		int id_viajante = 1;
		
		Viajante viajante = viajanteDAO.getViajanteById(id_viajante);
		
		Viagem v1 = new Viagem(id, origem, destino, data_ida, data_volta, qtd_viajantes, qtd_quartos, viajante);
		
		viagemDAO.save(v1);
		System.out.println("\n***  Cadastrou  ***\n");

	}

}
