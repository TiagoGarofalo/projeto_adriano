package model.bo;


import java.util.ArrayList;
import model.dao.ColecaoDAO;
import model.vo.ColecaoVO;

public class ColecaoBO {

	public void cadastrarColecaoBO(ColecaoVO colecaoVO) {
		ColecaoDAO colecaoDAO = new ColecaoDAO();
		if (colecaoDAO.existeRegistroPorIdColecao(colecaoVO.getIdColecao())) {
			System.out.println("\nColecao já cadastrada");
		} else {
			int resultado = colecaoDAO.CadastrarColecaoDAO(colecaoVO);
			if (resultado == 1) {
				System.out.println("\nColeção cadastrada com sucesso");
			} else {
				System.out.println("\nNão foi possível cadastrar a coleção");
			}
		}
	}

	public void excluirColecaoBO(ColecaoVO colecaoVO) {
		ColecaoDAO colecaoDAO = new ColecaoDAO();
		if (colecaoDAO.existeRegistroPorIdColecao(colecaoVO.getIdColecao())) {
			int resultado = colecaoDAO.excluirColecaoDAO(colecaoVO);
			if (resultado == 1) {
				System.out.println("\nColeção excluida com sucesso");
			} else {
				System.out.println("\nNão foi possível excluir a coleção");
			}
		} else {
			System.out.println("\nColeção não existe na base de dados");
		}
	}

	public void atualizarColecaoBO(ColecaoVO colecaoVO) {
		ColecaoDAO colecaoDAO = new ColecaoDAO();
		if (colecaoDAO.existeRegistroPorIdColecao(colecaoVO.getIdColecao())) {
			int resultado = colecaoDAO.atualizarColecaoDAO(colecaoVO);
			if (resultado == 1) {
				System.out.println("\nColeção atualizada com sucesso");
			} else {
				System.out.println("\nNão foi possivel atualizar a coleção");
			}
		} else {
			System.out.println("\nColeção ainda não foi cadastrada.");
		}
	}

	public ArrayList<ColecaoVO> consultarColecoesBO() {
		ColecaoDAO colecaoDAO = new ColecaoDAO();
		ArrayList<ColecaoVO> colecoesVO = colecaoDAO.consultarTodasColecoesDAO();
		if (colecoesVO.isEmpty()) {
			System.out.println("\nNão foram encontradas coleções na base de dados");
		}
		return colecoesVO;
	}

	public ColecaoVO consultarColecaoBO(ColecaoVO colecaoVO) {
		ColecaoDAO colecaoDAO = new ColecaoDAO();
		ColecaoVO colecao = colecaoDAO.consultarColecaoDAO(colecaoVO);
		if (colecao == null) {
			System.out.println("\nColeção não localizada");
		}
		return colecao;

	}

}
