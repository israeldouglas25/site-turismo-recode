package crud;

import java.util.Scanner;

import dao.PermissaoDAO;
import model.Permissoes;

public class PermissaoCrud {

	public static void main(String[] args) {
		PermissaoDAO permissaoDAO = new PermissaoDAO();

		Scanner sc = new Scanner(System.in);

		int op = 0;
		int posicao = 0;

		int id = 0;
		String tipo = "";

		do {
			System.out.println("=== CRUD PERMISSÕES ===");
			System.out.println("1 - Cadastrar permissão");
			System.out.println("2 - Consultar permissão");
			System.out.println("3 - Atualizar permissão");
			System.out.println("4 - Deletar permissão");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Digite o tipo de permissão:");
				tipo = sc.nextLine();

				Permissoes p1 = new Permissoes(id, tipo);

				permissaoDAO.save(p1);
				System.out.println("Permissão cadastrada com sucesso!");
				System.out.println("");
				break;
			case 2:
				for (Permissoes p : permissaoDAO.getPermissoes()) {
					System.out.println("ID: " + p.getId() + "\nTIPO: " + p.getTipo());
					System.out.println("");
				}
				break;
			case 3:	
				System.out.println("Digite o ID da permissão:");
				posicao = sc.nextInt();
				sc.nextLine();
				System.out.println("Atualize a permissão");
				tipo = sc.nextLine();
				
				Permissoes p2 = new Permissoes(posicao, tipo);

				permissaoDAO.update(p2);
				System.out.println("Permissão Atualizada!");
				System.out.println("");
				break;
			case 4:
				System.out.println("Digite o ID da permissão que deseja EXCLUIR:");
				posicao = sc.nextInt();
				
				permissaoDAO.deleteById(posicao);
				System.out.println("Permissão Excluida com sucesso.");
				break;
			case 5:
				System.out.println("Digite o ID da permissão:");
				posicao = sc.nextInt();
				
				Permissoes p3 = permissaoDAO.getPermissaoById(posicao);
				
				System.out.println("ID: " + p3.getId() + "\nTIPO: " + p3.getTipo());
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
