package crud;

import java.util.Arrays;

import model.Permissoes;
import model.Usuario;

public class Teste {

	public static void main(String[] args) {
		Permissoes p1 = new Permissoes(1, "comum");
		Permissoes p2 = new Permissoes(2, "administrador");
		
		Usuario u1 = new Usuario(1, "Joao", "joao@email", "1234", p2);
		Usuario u2 = new Usuario(2, "Anna", "anna@email", "4567", p1);
		Usuario u3 = new Usuario(3, "Jose", "jose@email", "7891", p1);
		
		System.out.println(u1.mostrar());
		System.out.println(u2.mostrar());
		System.out.println(u3.mostrar());

	}

}
