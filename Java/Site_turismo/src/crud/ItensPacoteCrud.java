package crud;

import java.util.Scanner;

import dao.ItensPacoteDAO;
import dao.PacoteDAO;
import dao.ViagemDAO;
import model.ItensPacote;
import model.Pacote;
import model.Viagem;

public class ItensPacoteCrud {

	public static void main(String[] args) {
		ItensPacoteDAO itemDAO = new ItensPacoteDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		ViagemDAO viagemDAO = new ViagemDAO();
		Scanner sc = new Scanner(System.in);

		int op = 0;
		int posicao = 0;

		int id = 0;
		int qtdViajantes = 0;
		double valor = 0;
		int idPacote = 0;
		int idViagem = 0;

		do {
			System.out.println("=== CRUD ITENS ===");
			System.out.println("1 - Cadastrar item");
			System.out.println("2 - Consultar item");
			System.out.println("3 - Atualizar item");
			System.out.println("4 - Deletar item");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Digite a quantidade de viajantes: ");
				qtdViajantes = sc.nextInt();
				System.out.println("Digite o ID do pacote: ");
				idPacote = sc.nextInt();
				System.out.println("Digite o ID da viagem: ");
				idViagem = sc.nextInt();

				Pacote pacote = pacoteDAO.getPacoteById(idPacote);
				Viagem viagem = viagemDAO.getViagemById(idViagem);

				ItensPacote i1 = new ItensPacote(id, qtdViajantes, pacote, viagem);

				itemDAO.save(i1);

				System.out.println("Item cadastrado com sucesso!");
				System.out.println("");
				break;
			case 2:
				for (ItensPacote item : itemDAO.getItensPacote()) {
					System.out.println("ID: " + item.getId() + "\nQTD VIAJANTES: " + item.getQtdViajantes()
							+ "\nVALOR: " + item.getValor() + "\nID PACOTE: " + item.getPacote().getId() + "\nID VIAGEM: "
							+ item.getViagem().getId());
					System.out.println("");
				}
				break;
			case 3:
				System.out.println("Digite o ID que deseja atualizar:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Atualize a qtd de viajantes:");
				qtdViajantes = sc.nextInt();
				System.out.println("Atualize o valor:");
				valor = sc.nextDouble();
				System.out.println("Atualize o ID do pacote:");
				idPacote = sc.nextInt();
				System.out.println("Atualize o ID da viagem:");
				idViagem = sc.nextInt();
				
				Pacote pacote1 = pacoteDAO.getPacoteById(idPacote);
				Viagem viagem1 = viagemDAO.getViagemById(idViagem);

				ItensPacote i2 = new ItensPacote(id, qtdViajantes, pacote1, viagem1);
				
				itemDAO.update(i2);
				System.out.println("Item de codigo " + i2.getId() + " atualizado.");
				System.out.println("");
				break;
			case 4:
				System.out.println("Digite o ID do item que deseja EXCLUIR: ");
				posicao = sc.nextInt();

				itemDAO.deleteById(posicao);
				System.out.println("Item Excluido com sucesso.");
				System.out.println("");
				break;
			case 5:
				System.out.println("Digite o ID do Item: ");
				posicao = sc.nextInt();

				ItensPacote i3 = itemDAO.getItemById(posicao);
				System.out.println("ID: " + i3.getId() + "\nQTD VIAJANTES: " + i3.getQtdViajantes() + "\nVALOR: "
						+ i3.getValor() + "\nID PACOTE: " + i3.getPacote().getId() + "\nID VIAGEM: " + i3.getViagem().getId());
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
