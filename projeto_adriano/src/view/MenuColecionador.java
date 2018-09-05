package view;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controller.ControladoraColecionador;
import model.dao.Banco;
import model.vo.ColecionadorVO;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class MenuColecionador {

	Scanner teclado = new Scanner(System.in);

	public void apresentaMenuColecionador() {

		System.out.println("Sistema Gerenciador de Coleções\n \n--------menu--------");
		System.out.println("\nOpções:\n");
		System.out.println("1 - Cadastrar Colecionador");
		System.out.println("2 - Consultar Colecionador");
		System.out.println("3 - Atualizar Colecionador");
		System.out.println("4 - Excluir Colecionador");
		System.out.println("0 - Imprimir relatório");
		System.out.println("5 - Voltar\n");
		System.out.print("Digite a opção: ");
		int opcao = Integer.parseInt(teclado.next());

		while (opcao != 5) {

			switch (opcao) {

			case 1: {
				this.cadastrarColecionador();
				break;
			}

			case 2: {
				this.consultarColecionador();
				break;
			}

			case 3: {
				this.atualizarColecionador();
				break;
			}

			case 4: {
				this.excluirColecionador();
				break;
			}
			
			case 0: {
				this.imprimirRelColecionador();
				break;
			}

			default: {
				System.out.println("\nOpção inválida");
				break;
			}

			}
			System.out.println("\nSistema Gerenciador de Coleções\n \n--------menu--------");
			System.out.println("\nOpções:\n");
			System.out.println("1 - Cadastrar Colecionador");
			System.out.println("2 - Consultar Colecionador");
			System.out.println("3 - Atualizar Colecionador");
			System.out.println("4 - Excluir Colecionador");
			System.out.println("0 - Imprimir relatório");
			System.out.println("5 - Voltar\n");
			System.out.print("Digite a opção: ");
			opcao = Integer.parseInt(teclado.next());
		}

	}

	private void imprimirRelColecionador() {
		try {
			Connection conn = Banco.getConnection();
			Map<String, Object> parametros = new HashMap<String, Object>();
			
			JasperPrint rel = JasperFillManager.fillReport("D:/SENAC/TRABALHO.jasper", parametros, conn);
			JasperViewer visualizador = new JasperViewer(rel, true);
			visualizador.setVisible(true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void excluirColecionador() {
		ColecionadorVO colecionadorVO = new ColecionadorVO();
		System.out.println("\nInforme o código do colecionador: ");
		colecionadorVO.setIdColecionador(Integer.parseInt(teclado.next()));

		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		controladoraColecionador.excluirColecionadorController(colecionadorVO);
	}

	private void atualizarColecionador() {
		ColecionadorVO colecionadorVO = new ColecionadorVO();
		System.out.print("\nDigite o ID do colecionador: ");
		colecionadorVO.setIdColecionador(Integer.parseInt(teclado.next()));
		System.out.print("Digite o nome do colecionador: ");
		colecionadorVO.setNome(teclado.next());
		System.out.print("Digite o cpf do colecionador: ");
		colecionadorVO.setCpf(teclado.next());
		System.out.print("Digite o telefone: ");
		colecionadorVO.setTelefone(teclado.next());
		System.out.print("Digite o email: ");
		colecionadorVO.setEmail(teclado.next());

		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		controladoraColecionador.atualizarColecionadorController(colecionadorVO);

	}

	private void consultarColecionador() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todos os colecionadores");
		System.out.println("2 - Consultar um colecionador especifico");
		System.out.println("3 - Não Consultar");
		System.out.println("\nDigite a opção: ");
		int opcao = Integer.parseInt(teclado.next());

		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		while (opcao != 3) {
			switch (opcao) {
			case 1: {
				opcao = 3;
				ArrayList<ColecionadorVO> colecionadoresVO = controladoraColecionador
						.consultarTodosColecionadoresController();
				System.out.print("\n--------Resultado da consulta--------");
				System.out.printf("\n%3s %-20s %-30s \n", "ID", "nome", "cpf");
				for (int i = 0; i < colecionadoresVO.size(); i++) {
					colecionadoresVO.get(i).imprimir();
				}
				break;
			}
			case 2: {
				opcao = 3;
				ColecionadorVO colecionadorVO = new ColecionadorVO();
				System.out.println("\nInforme o código do colecionador: ");
				colecionadorVO.setIdColecionador(Integer.parseInt(teclado.next()));

				ColecionadorVO colecionador = controladoraColecionador.consultarColecionadorController(colecionadorVO);
				System.out.print("\n--------Resultado da consulta--------");
				System.out.printf("\n%3s %-20s %-30s \n", "ID", "nome", "cpf");
				colecionador.imprimir();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
				System.out.println("\nInforme o tipo de consulta a ser realizada");
				System.out.println("1 - Consultar todos os colecionadores");
				System.out.println("2 - Consultar um colecionador especifico");
				System.out.println("3 - Não Consultar");
				System.out.println("\nDigite a opção: ");
				opcao = Integer.parseInt(teclado.next());
			}
			}
		}
	}

	private void cadastrarColecionador() {
		ColecionadorVO colecionadorVO = new ColecionadorVO();
		System.out.print("\nDigite o nome do colecionador: ");
		colecionadorVO.setNome(teclado.nextLine());
		teclado.next();
		System.out.print("Digite o cpf do colecionador: ");
		colecionadorVO.setCpf(teclado.next());
		System.out.print("Digite o telefone: ");
		colecionadorVO.setTelefone(teclado.next());
		System.out.print("Digite o email: ");
		colecionadorVO.setEmail(teclado.next());

		ControladoraColecionador controladoraColecionador = new ControladoraColecionador();
		controladoraColecionador.cadastrarColecionadorController(colecionadorVO);

	}
}
