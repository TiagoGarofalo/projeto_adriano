package view;


import java.util.Scanner;

public class Menu {

	Scanner teclado = new Scanner(System.in);

	public void apresentaMenu() {

		System.out.println("Sistema Gerenciador de coleções");
		System.out.println("\nOpções:\n");
		System.out.println("1 - Menu Colecionador");
		System.out.println("2 - Menu Artefato");
		System.out.println("3 - Menu Coleção");
		System.out.println("4 - Sair");
		System.out.print("\nDigite a opção: ");
		int opcao = Integer.parseInt(teclado.next());

		while (opcao != 4) {

			switch (opcao) {

			case 1: {
				MenuColecionador menuColecionador = new MenuColecionador();
				menuColecionador.apresentaMenuColecionador();
				break;
			}

			case 2: {
				MenuArtefato menuArtefato = new MenuArtefato();
				menuArtefato.apresentaMenuArtefato();
				break;
			}

			case 3: {
				MenuColecao menuColecao = new MenuColecao();
				menuColecao.apresentaMenuColecao();
				break;
			}

			default: {
				System.out.println("\nOpção inválida");
				break;
			}

			}
			System.out.println("Sistema Gerenciador de coleções");
			System.out.println("\nOpções:");
			System.out.println("1 - Menu Colecionador");
			System.out.println("2 - Menu Artefato");
			System.out.println("3 - Menu Coleção");
			System.out.println("4 - Sair");
			System.out.print("\nDigite a opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}
}
