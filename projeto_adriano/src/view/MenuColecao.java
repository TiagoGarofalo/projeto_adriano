package view;


import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraColecao;
import model.vo.ColecaoVO;

public class MenuColecao {

	Scanner teclado = new Scanner(System.in);

	public void apresentaMenuColecao() {

		System.out.println("Sistema Gerenciador de Coleções\n \n--------menu--------");
		System.out.println("\nOpções:\n");
		System.out.println("1 - Cadastrar Coleção");
		System.out.println("2 - Consultar Coleção");
		System.out.println("3 - Atualizar Coleção");
		System.out.println("4 - Excluir Coleção");
		System.out.println("5 - Voltar\n");
		System.out.print("Digite a opção: ");
		int opcao = Integer.parseInt(teclado.next());

		while (opcao != 5) {

			switch (opcao) {

			case 1: {
				this.cadastrarColecao();
				break;
			}

			case 2: {
				this.consultarColecao();
				break;
			}

			case 3: {
				this.atualizarColecao();
				break;
			}

			case 4: {
				this.excluirColecao();
				break;
			}

			default: {
				System.out.println("\nOpção inválida");
				break;
			}

			}
			System.out.println("Sistema Gerenciador de Coleções\n \n--------menu--------");
			System.out.println("\nOpções:\n");
			System.out.println("1 - Cadastrar Coleção");
			System.out.println("2 - Consultar Coleção");
			System.out.println("3 - Atualizar Coleção");
			System.out.println("4 - Excluir Coleção");
			System.out.println("5 - Voltar\n");
			System.out.print("Digite a opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}

	private void excluirColecao() {
		ColecaoVO colecaoVO = new ColecaoVO();
		System.out.println("\nInforme o código da coleção: ");
		colecaoVO.setIdColecao(Integer.parseInt(teclado.next()));

		ControladoraColecao controladoraColecao = new ControladoraColecao();
		controladoraColecao.excluirColecaoController(colecaoVO);
	}

	private void atualizarColecao() {
		ColecaoVO colecaoVO = new ColecaoVO();
		System.out.print("\nDigite o ID da Coleção: ");
		colecaoVO.setIdColecao(Integer.parseInt(teclado.next()));
		System.out.print("\nDigite o ID do Colecionador: ");
		colecaoVO.setIdColecionador(Integer.parseInt(teclado.next()));
		System.out.print("\nDigite o ID do Artefato: ");
		colecaoVO.setIdArtefato(Integer.parseInt(teclado.next()));
	
		ControladoraColecao controladoraColecao = new ControladoraColecao();
		controladoraColecao.atualizarColecaoController(colecaoVO);

	}

	private void consultarColecao() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todas as coleções");
		System.out.println("2 - Consultar uma coleção especifica");
		System.out.println("3 - Não Consultar");
		System.out.println("\nDigite a opção: ");
		int opcao = Integer.parseInt(teclado.next());

		ControladoraColecao controladoraColecao = new ControladoraColecao();

		while (opcao != 3) {

			switch (opcao) {

			case 1: {
				opcao = 3;
				ArrayList<ColecaoVO> colecoesVO = controladoraColecao.consultarTodasColecoesController();
				System.out.print("\n--------Resultado da consulta--------");
				System.out.printf("\n%3s %-20s %-30s \n", "ID");
				for (int i = 0; i < colecoesVO.size(); i++) {
					colecoesVO.get(i).imprimir();
				}
				break;
			}
			case 2: {
				opcao = 3;
				ColecaoVO colecaoVO = new ColecaoVO();
				System.out.println("\nInforme o código da coleção: ");
				colecaoVO.setIdColecionador(Integer.parseInt(teclado.next()));

				ColecaoVO colecao = controladoraColecao.consultarColecaoController(colecaoVO);
				System.out.print("\n--------Resultado da consulta--------");
				System.out.printf("\n%3s %-20s %-30s \n", "ID");
				colecao.imprimir();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
				System.out.println("\nInforme o tipo de consulta a ser realizada");
				System.out.println("1 - Consultar todas as coleções");
				System.out.println("2 - Consultar uma coleção especifica");
				System.out.println("3 - Não Consultar");
				System.out.println("\nDigite a opção: ");
				opcao = Integer.parseInt(teclado.next());
			}
			}
		}
	}

	private void cadastrarColecao() {
		ColecaoVO colecaoVO = new ColecaoVO();
		System.out.print("\nDigite o id do colecionador: ");
		colecaoVO.setIdColecionador(Integer.parseInt(teclado.next()));
		System.out.print("Digite o id do artefato: ");
		colecaoVO.setIdArtefato(Integer.parseInt(teclado.next()));

		ControladoraColecao controladoraColecao = new ControladoraColecao();
		controladoraColecao.cadastrarColecaoController(colecaoVO);

	}

}
