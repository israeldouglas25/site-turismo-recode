package crud;

import java.util.Scanner;

import dao.ViagemDAO;
import dao.ViajanteDAO;
import model.Viagem;
import model.Viajante;

public class ViagemCrud {

	public static void main(String[] args) {
		ViagemDAO viagemDAO = new ViagemDAO();
		ViajanteDAO viajanteDAO = new ViajanteDAO();
		Scanner sc = new Scanner(System.in);

		int op = 0;
		int posicao = 0;

		int id = 0;
		String origem = "";
		String destino = "";
		String data_ida = "";
		String data_volta = "";
		int qtd_viajantes = 0;
		int qtd_quartos = 0;
		int id_viajante = 0;
		double preco = 0;

		do {
			System.out.println("=== CRUD VIAGEM ===");
			System.out.println("1 - Cadastrar viagem");
			System.out.println("2 - Consultar viagem");
			System.out.println("3 - Atualizar viagem");
			System.out.println("4 - Deletar viagem");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				// Cadastrar
				System.out.println("Digite a origem:");
				origem = sc.nextLine();
				System.out.println("Digite o destino:");
				destino = sc.nextLine();
				System.out.println("Data de ida:");
				data_ida = sc.nextLine();
				System.out.println("Data de volta:");
				data_volta = sc.nextLine();
				System.out.println("Digite a quantidade de viajantes:");
				qtd_viajantes = sc.nextInt();
				System.out.println("Quantos quartos?");
				qtd_quartos = sc.nextInt();
				System.out.println("Digite o codigo do viajante:");
				id_viajante = sc.nextInt();
				System.out.println("Digite o preco da viagem:");
				preco = sc.nextDouble();

				Viajante viajante = viajanteDAO.getViajanteById(id_viajante);

				Viagem v1 = new Viagem(id, origem, destino, data_ida, data_volta, qtd_viajantes, qtd_quartos, viajante, preco);

				viagemDAO.save(v1);
				System.out.println("\n***  VIAGEM CADASTRADA COM SUCESSO  ***\n");
				break;
			case 2:
				for (Viagem vg : viagemDAO.getViagem()) {
					System.out.println("ID: " + vg.getId() + "\nORIGEM: " + vg.getOrigem() + "\nDESTINO: "
							+ vg.getDestino() + "\nSAIDA: " + vg.getDataIda() + "\nVOLTA: " + vg.getDataVolta()
							+ "\nQTD VIAJANTES: " + vg.getQtdViajantes() + "\nQTD QUARTOS: " + vg.getQtdQuartos()
							+ "\nID VIAJANTE: " + vg.getViajante().getId()+ "\nPRECO: "+ vg.getPreco());
					System.out.println("");
				}
				break;
			case 3:
				System.out.println("Digite o ID da viagem que deseja atualizar: ");
				posicao = sc.nextInt();
				sc.nextLine();
				System.out.println("Atualizar a origem:");
				origem = sc.nextLine();
				System.out.println("Atualizar o destino:");
				destino = sc.nextLine();
				System.out.println("Atualizar data de ida:");
				data_ida = sc.nextLine();
				System.out.println("Atualizar data de volta:");
				data_volta = sc.nextLine();
				System.out.println("Atualize a quantidade de viajantes:");
				qtd_viajantes = sc.nextInt();
				System.out.println("Atualize quantos quartos?");
				qtd_quartos = sc.nextInt();
				System.out.println("Atualize o codigo do viajante:");
				id_viajante = sc.nextInt();
				System.out.println("Atualize o preco da viagem:");
				preco = sc.nextDouble();

				Viajante vAtual = viajanteDAO.getViajanteById(id_viajante);

				Viagem v2 = new Viagem(posicao, origem, destino, data_ida, data_volta, qtd_viajantes, qtd_quartos,
						vAtual, preco);

				viagemDAO.update(v2);
				System.out.println("Viagem de codigo " + v2.getId() + " atualizado.");
				break;
			case 4:
				System.out.println("Digite o ID da viagem que deseja EXCLUIR: ");
				posicao = sc.nextInt();

				viagemDAO.deleteById(posicao);
				System.out.println("Viagem Excluida com sucesso.");
				break;
			case 5:
				// Buscar
				System.out.println("Digite o ID da viagem: ");
				posicao = sc.nextInt();

				Viagem v3 = viagemDAO.getViagemById(posicao);
				System.out.println("ID: " + v3.getId() + "\nORIGEM: " + v3.getOrigem() + "\nDESTINO: " + v3.getDestino()
						+ "\nSAIDA: " + v3.getDataIda() + "\nVOLTA: " + v3.getDataVolta() + "\nQTD VIAJANTES: "
						+ v3.getQtdViajantes() + "\nQTD QUARTOS: " + v3.getQtdQuartos() + "\nID VIAJANTE: "
						+ v3.getViajante().getId()+ "\nPRECO: "+ v3.getPreco());
				System.out.println("");
				break;
			default:
				System.out.println(
						op != 0 ? "Opcao invalida, digite novamente" : "Obrigado por viajar com a Paixao Nordestina");
			}
		} while (op != 0);

		sc.close();

	}

}
