package model.bo;


import java.util.ArrayList;
import model.dao.ArtefatoDAO;
import model.vo.ArtefatoVO;

public class ArtefatoBO {

	public void cadastrarArtefatoBO(ArtefatoVO artefatoVO) {
		ArtefatoDAO artefatoDAO = new ArtefatoDAO();
		if (artefatoDAO.existeRegistroPorIdArtefato(artefatoVO.getIdArtefato())) {
			System.out.println("\nArtefato já cadastrado");
		} else {
			int resultado = artefatoDAO.CadastrarArtefatoDAO(artefatoVO);
			if (resultado == 1) {
				System.out.println("\nArtefato cadastrado com sucesso");
			} else {
				System.out.println("\nNão foi possível cadastrar o artefato");
			}
		}
	}

	public void atualizarArtefatoBO(ArtefatoVO artefatoVO) {
		ArtefatoDAO artefatoDAO = new ArtefatoDAO();
		if (artefatoDAO.existeRegistroPorIdArtefato(artefatoVO.getIdArtefato())) {
			int resultado = artefatoDAO.atualizarArtefatoDAO(artefatoVO);
			if (resultado == 1) {
				System.out.println("\nArtefato atualizado com sucesso");
			} else {
				System.out.println("\nNão foi possivel atualizar o artefato");
			}
		} else {
			System.out.println("\nArtefato ainda nao foi cadasdtrado");
		}
	}

	public void excluirArtefatoBO(ArtefatoVO artefatoVO) {
		ArtefatoDAO artefatoDAO = new ArtefatoDAO();
		if (artefatoDAO.existeRegistroPorIdArtefato(artefatoVO.getIdArtefato())) {
			int resultado = artefatoDAO.excluirArtefatoDAO(artefatoVO);
			if (resultado == 1) {
				System.out.println("\nArtefato excluido com sucesso");
			} else {
				System.out.println("\nNão foi possível excluir o artefato");
			}
		} else {
			System.out.println("\nArtefato não existe na base de dados");
		}
	}

	public ArrayList<ArtefatoVO> consultarArtefatosBO() {
		ArtefatoDAO artefatoDAO = new ArtefatoDAO();
		ArrayList<ArtefatoVO> artefatosVO = artefatoDAO.consultarTodosArtefatosDAO();
		if (artefatosVO.isEmpty()) {
			System.out.println("\nNão foram encontrados artefatoes na " + "base de dados");
		}
		return artefatosVO;
	}

	public ArtefatoVO consultarArtefatoBO(ArtefatoVO artefatoVO) {
		ArtefatoDAO artefatoDAO = new ArtefatoDAO();
		ArtefatoVO artefato = artefatoDAO.consultarArtefatoDAO(artefatoVO);
		if (artefato == null) {
			System.out.println("\nArtefato não localizado");
		}
		return artefato;
	}
}
