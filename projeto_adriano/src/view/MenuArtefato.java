package view;


import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraArtefato;
import model.vo.ArtefatoVO;

public class MenuArtefato {

	Scanner teclado = new Scanner(System.in);

	public void apresentaMenuArtefato() {
		System.out.println("Sistema Gerenciador de Coleções\n \n--------menu--------");
		System.out.println("\nOpções:\n");
		System.out.println("1 - Cadastrar Artefato");
		System.out.println("2 - Consultar Artefato");
		System.out.println("3 - Atualizar Artefatos");
		System.out.println("4 - Excluir Artefato");
		System.out.println("5 - Voltar\n");
		System.out.print("Digite a opção: ");
		int opcao = Integer.parseInt(teclado.next());

		while (opcao != 5) {

			switch (opcao) {

			case 1: {
				this.cadastrarArtefato();
				break;
			}

			case 2: {
				this.consultarArtefato();
				break;
			}

			case 3: {
				this.atualizarArtefato();
				break;
			}

			case 4: {
				this.excluirArtefato();
				break;
			}

			default: {
				System.out.println("\nOpção inválida");
				break;
			}

			}
			System.out.println("Sistema Gerenciador de Coleções\n \n--------menu--------");
			System.out.println("\nOpções:\n");
			System.out.println("1 - Cadastrar Artefato");
			System.out.println("2 - Consultar Artefato");
			System.out.println("3 - Atualizar Artefatos");
			System.out.println("4 - Excluir Artefato");
			System.out.println("5 - Voltar\n");
			System.out.print("Digite a opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}

	private void excluirArtefato() {
		ArtefatoVO artefatoVO = new ArtefatoVO();
		System.out.print("\nInforme o código do Artefato: ");
		artefatoVO.setIdArtefato(Integer.parseInt(teclado.next()));
		
		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		controladoraArtefato.excluirArtefatoController(artefatoVO);
	}

	private void atualizarArtefato() {
		ArtefatoVO artefatoVO = new ArtefatoVO();
		System.out.print("\nDigite o ID do Artefato: ");
		artefatoVO.setIdArtefato(Integer.parseInt(teclado.next()));
		System.out.print("Digite o nome do Artefato: ");
		artefatoVO.setNome(teclado.next());
		System.out.print("Digite o ano do Artefato: ");
		artefatoVO.setAno(Integer.parseInt(teclado.next()));
		System.out.print("Digite o valor: ");
		artefatoVO.setValor(Integer.parseInt(teclado.next()));

		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		controladoraArtefato.atualizarArtefatoController(artefatoVO);

	}

	private void consultarArtefato() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todos os Artefatos");
		System.out.println("2 - Consultar um Artefato especifico");
		System.out.println("3 - Não Consultar");
		System.out.println("\nDigite a opção: ");
		int opcao = Integer.parseInt(teclado.next());

		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		while (opcao != 3) {
			switch (opcao) {
			case 1: {
				opcao = 3;
				ArrayList<ArtefatoVO> artefatosVO = controladoraArtefato.consultarTodosArtefatosController();
				System.out.print("\n--------Resultado da consulta--------");
				System.out.printf("\n%3s %-20s %-30s \n", "ID", "nome", "ano", "valor");
				for (int i = 0; i < artefatosVO.size(); i++) {
					artefatosVO.get(i).imprimir();
				}
				break;
			}
			case 2: {
				opcao = 3;
				ArtefatoVO artefatoVO = new ArtefatoVO();
				System.out.println("\nInforme o código do Artefato: ");
				artefatoVO.setIdArtefato(Integer.parseInt(teclado.next()));

				ArtefatoVO artefato = controladoraArtefato.consultarArtefatoController(artefatoVO);
				System.out.print("\n--------Resultado da consulta--------");
				System.out.printf("\n%3s %-20s %-30s \n", "ID", "nome", "ano", "valor");
				artefato.imprimir();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
				System.out.println("\nInforme o tipo de consulta a ser realizada");
				System.out.println("1 - Consultar todos os Artefatos");
				System.out.println("2 - Consultar um Artefato especifico");
				System.out.println("3 - Não Consultar");
				System.out.println("\nDigite a opção: ");
				opcao = Integer.parseInt(teclado.next());
			}
			}
		}
	}

	private void cadastrarArtefato() {
		ArtefatoVO artefatoVO = new ArtefatoVO();
		System.out.print("\nDigite o nome do Artefato: ");
		artefatoVO.setNome(teclado.next());
		System.out.print("Digite o ano do Artefato: ");
		artefatoVO.setAno(Integer.parseInt(teclado.next()));
		System.out.print("Digite o valor: ");
		artefatoVO.setValor(Integer.parseInt(teclado.next()));

		ControladoraArtefato controladoraArtefato = new ControladoraArtefato();
		controladoraArtefato.cadastrarArtefatoController(artefatoVO);

	}

}
