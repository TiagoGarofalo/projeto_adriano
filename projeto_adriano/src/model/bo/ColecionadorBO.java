package model.bo;


import java.util.ArrayList;
import model.dao.ColecionadorDAO;
import model.vo.ColecionadorVO;

public class ColecionadorBO {

	public void cadastrarColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if (colecionadorDAO.existeRegistroPorCpf(colecionadorVO.getCpf())) {
			System.out.println("\nColecionador já cadastrado");
		} else {
			int resultado = colecionadorDAO.CadastrarColecionadorDAO(colecionadorVO);
			if (resultado == 1) {
				System.out.println("\nColecionador cadastrado com sucesso");
			} else {
				System.out.println("\nNão foi possível cadastrar o colecionador");
			}
		}
	}

	public void atualizarColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if (colecionadorDAO.existeRegistroPorIdColecionador(colecionadorVO.getIdColecionador())) {
			int resultado = colecionadorDAO.atualizarColecionadorDAO(colecionadorVO);
			if (resultado == 1) {
				System.out.println("\nColecionador atualizado com sucesso");
			} else {
				System.out.println("\nNão foi possivel atualizar o colecionador");
			}
		} else {
			System.out.println("\nColecionador ainda nao foi cadasdtrado");
		}

	}

	public void excluirColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		if (colecionadorDAO.existeRegistroPorIdColecionador(colecionadorVO.getIdColecionador())) {
			int resultado = colecionadorDAO.excluirColecionadorDAO(colecionadorVO);
			if (resultado == 1) {
				System.out.println("\nColecionador excluido com sucesso");
			} else {
				System.out.println("\nNão foi possível excluir o colecionador");
			}
		} else {
			System.out.println("\nColecionador não existe na base de dados");
		}

	}

	public ArrayList<ColecionadorVO> consultarColecionadoresBO() {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		ArrayList<ColecionadorVO> colecionadoresVO = colecionadorDAO.consultarTodosColecionadoresDAO();
		if (colecionadoresVO.isEmpty()) {
			System.out.println("\nNão foram encontrados colecionadores na " + "base de dados");
		}
		return colecionadoresVO;
	}

	public ColecionadorVO consultarColecionadorBO(ColecionadorVO colecionadorVO) {
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		ColecionadorVO colecionador = colecionadorDAO.consultarColecionadorDAO(colecionadorVO);
		if (colecionador == null) {
			System.out.println("\nColecionador não localizado");
		}
		return colecionador;
	}

}
