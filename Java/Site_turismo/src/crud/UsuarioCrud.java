package crud;

import java.util.Scanner;

import dao.PermissaoDAO;
import dao.UsuarioDAO;
import model.Permissoes;
import model.Usuario;

public class UsuarioCrud {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PermissaoDAO permissaoDAO = new PermissaoDAO();
		Scanner sc = new Scanner(System.in);

		int op = 0;
		int posicao = 0;
		int id = 0;

		String nome = "";
		String email = "";
		String senha = "";
		int id_permissao = 0;

		do {
			System.out.println("=== CRUD USUARIO ===");
			System.out.println("1 - Cadastrar usuario");
			System.out.println("2 - Consultar usuario");
			System.out.println("3 - Atualizar usuario");
			System.out.println("4 - Deletar usuario");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Digite o nome do usuario:");
				nome = sc.nextLine();
				System.out.println("Digite o e-mail:");
				email = sc.nextLine();
				System.out.println("Digite a senha:");
				senha = sc.nextLine();
				System.out.println("Digite o codigo da permissao:");
				id_permissao = sc.nextInt();

				Permissoes permissao = permissaoDAO.getPermissaoById(id_permissao);

				Usuario u = new Usuario(id, nome, email, senha, permissao);

				usuarioDAO.save(u);
				System.out.println("\n***  USUARIO(A) CADASTRADO(A) COM SUCESSO  ***\n");
				break;
			case 2:
				for (Usuario u1 : usuarioDAO.getUsuario()) {
					System.out.println("ID: " + u1.getId() + "\nNOME: " + u1.getNome() + "\nE-MAIL: " + u1.getEmail()
							+ "\nSENHA: " + u1.getSenha() + "\nCODIGO PERMISSAO: " + u1.getPermissoes().getId());
					System.out.println("");
				}
				break;
			case 3:
				System.out.println("Digite o ID do usuario que deseja atualizar:");
				posicao = sc.nextInt();
				sc.nextLine();
				System.out.println("Atualize o nome do usuario:");
				nome = sc.nextLine();
				System.out.println("Atualize o e-mail:");
				email = sc.nextLine();
				System.out.println("Atualize a senha:");
				senha = sc.nextLine();
				System.out.println("Atualize o codigo da permissao:");
				id_permissao = sc.nextInt();

				Permissoes permissao2 = permissaoDAO.getPermissaoById(id_permissao);

				Usuario u1 = new Usuario(posicao, nome, email, senha, permissao2);

				usuarioDAO.update(u1);
				System.out.println("Usuario de ID " + u1.getId() + " atualizado.");
				System.out.println("");
				break;
			case 4:
				System.out.println("Digite o ID do usuario que deseja EXCLUIR: ");
				posicao = sc.nextInt();

				usuarioDAO.deleteById(posicao);
				System.out.println("Usuario(a) Excluido(a) com sucesso.");
				System.out.println("");
				break;
			case 5:
				System.out.println("Digite o ID do usuario: ");
				posicao = sc.nextInt();

				Usuario u2 = usuarioDAO.getUsuarioById(posicao);
				System.out.println("ID: " + u2.getId() + "\nNOME: " + u2.getNome() + "\nE-MAIL: " + u2.getEmail()
						+ "\nSENHA: " + u2.getSenha() + "\nCODIGO PERMISSAO: " + u2.getPermissoes().getId());
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
