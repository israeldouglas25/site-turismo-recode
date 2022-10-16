package crud;

import java.util.Scanner;

import dao.PacoteDAO;
import dao.UsuarioDAO;
import model.Pacote;
import model.Usuario;

public class PacoteCrud {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		Scanner sc = new Scanner(System.in);

		int op = 0;
		int posicao = 0;

		int id = 0;
		String data = "";

		do {
			System.out.println("=== CRUD PACOTE ===");
			System.out.println("1 - Cadastrar pacote");
			System.out.println("2 - Consultar pacote");
			System.out.println("3 - Atualizar pacote");
			System.out.println("4 - Deletar pacote");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Digite a data:");
				data = sc.nextLine();
				System.out.println("Digite o ID do usuario:");
				posicao = sc.nextInt();

				Usuario u1 = usuarioDAO.getUsuarioById(posicao);

				Pacote p1 = new Pacote(id, data, u1);

				pacoteDAO.save(p1);

				System.out.println("Pacote cadastrado com sucesso!");
				System.out.println("");
				break;
			case 2:
				for (Pacote pc : pacoteDAO.getPacote()) {
					System.out.println("ID: " + pc.getId() + "\nDATA: " + pc.getData() + "\nVALOR: " + pc.getValor()
							+ "\nID USUARIO: " + pc.getUsuario().getId());
					System.out.println("");
				}
				break;
			case 3:
				System.out.println("Digite o ID que deseja atualizar:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Atualize a data:");
				data = sc.nextLine();
				System.out.println("Atualize o ID do usuario:");
				posicao = sc.nextInt();
				System.out.println("");

				Usuario u2 = usuarioDAO.getUsuarioById(posicao);

				Pacote p2 = new Pacote(id, data, u2);

				pacoteDAO.update(p2);
				System.out.println("Viagem de codigo " + p2.getId() + " atualizado.");
				System.out.println("");
				break;
			case 4:
				System.out.println("Digite o ID do pacote que deseja EXCLUIR: ");
				posicao = sc.nextInt();

				pacoteDAO.deleteById(posicao);
				System.out.println("Pacote Excluido com sucesso.");
				System.out.println("");
				break;
			case 5:
				System.out.println("Digite o ID do pacote: ");
				posicao = sc.nextInt();

				Pacote p3 = pacoteDAO.getPacoteById(posicao);
				System.out.println("ID: " + p3.getId() + "\nDATA: " + p3.getData() + "\nVALOR: " + p3.getValor()
						+ "\nID USUARIO: " + p3.getUsuario());
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
