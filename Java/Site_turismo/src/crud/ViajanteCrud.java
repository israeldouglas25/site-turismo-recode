package crud;

import java.util.Scanner;

import dao.ViajanteDAO;
import model.Viajante;

public class ViajanteCrud {

	public static void main(String[] args) {
		ViajanteDAO viajanteDAO = new ViajanteDAO();

		Scanner sc = new Scanner(System.in);

		int op = 0;
		int posicao = 0;

		int id = 0;

		String nome = "";
		String email = "";
		int idade = 0;
		String logradouro = "";
		String bairro = "";
		String cidade = "";
		String estado = "";
		String telefone = "";

		do {
			System.out.println("=== CRUD VIAJANTE ===");
			System.out.println("1 - Cadastrar viajante");
			System.out.println("2 - Consultar viajante");
			System.out.println("3 - Atualizar viajante");
			System.out.println("4 - Deletar viajante");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Nome: ");
				nome = sc.nextLine();
				System.out.println("E-mail: ");
				email = sc.nextLine();
				System.out.println("Idade: ");
				idade = sc.nextInt();
				sc.nextLine();
				System.out.println("Logradouro: ");
				logradouro = sc.nextLine();
				System.out.println("Bairro: ");
				bairro = sc.nextLine();
				System.out.println("Cidade: ");
				cidade = sc.nextLine();
				System.out.println("UF: ");
				estado = sc.nextLine();
				System.out.println("Telefone: ");
				telefone = sc.nextLine();

				Viajante v1 = new Viajante(id, nome, email, idade, logradouro, bairro, cidade, estado, telefone);

				viajanteDAO.save(v1);
				System.out.println("\n***  Cadastrou  ***\n");
				break;
			case 2:
				for (Viajante v : viajanteDAO.getViajante()) {
					System.out.println("ID: " + v.getId() + "\nNome: " + v.getNome() + "\nE-mail " + v.getEmail()
							+ "\nIdade: " + v.getIdade() + "\nLogradouro: " + v.getLogradouro() + "\nBairro: "
							+ v.getBairro() + "\nCidade " + v.getCidade() + "\nEstado " + v.getEstado() + "\nTelefone "
							+ v.getTelefone());
					System.out.println("\n");
				}
				break;
			case 3:
				System.out.println("Digite o ID do viajante: ");
				posicao = sc.nextInt();
				sc.nextLine();
				System.out.println("Atualize Nome: ");
				nome = sc.nextLine();
				System.out.println("Atualize E-mail: ");
				email = sc.nextLine();
				System.out.println("Atualize Idade: ");
				idade = sc.nextInt();
				sc.nextLine();
				System.out.println("Atualize Logradouro: ");
				logradouro = sc.nextLine();
				System.out.println("Atualize Bairro: ");
				bairro = sc.nextLine();
				System.out.println("Atualize Cidade: ");
				cidade = sc.nextLine();
				System.out.println("Atualize UF: ");
				estado = sc.nextLine();
				System.out.println("Atualize Telefone: ");
				telefone = sc.nextLine();

				Viajante v2 = new Viajante(posicao, nome, email, idade, logradouro, bairro, cidade, estado, telefone);

				viajanteDAO.update(v2);
				System.out.println("Atualizado!");
				break;
			case 4:
				System.out.println("Digite o ID do viajante que deseja EXCLUIR: ");
				posicao = sc.nextInt();

				viajanteDAO.deleteById(posicao);
				System.out.println("Viajante Excluido com sucesso.");
				break;
			case 5:
				System.out.println("Digite o ID para buscar: ");
				posicao = sc.nextInt();

				Viajante v3 = viajanteDAO.getViajanteById(posicao);

				System.out.println("ID: " + v3.getId() + " Nome: " + v3.getNome());
				break;
			default:
				System.out.println(
						op != 0 ? "Opcao invalida, digite novamente" : "Obrigado por viajar com a Paixao Nordestina");

			}

		} while (op != 0);

		sc.close();

	}

}
