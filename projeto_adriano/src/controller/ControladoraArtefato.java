package controller;


import java.util.ArrayList;

import model.bo.ArtefatoBO;
import model.vo.ArtefatoVO;

public class ControladoraArtefato {

	public void cadastrarArtefatoController(ArtefatoVO artefatoVO) {
		ArtefatoBO artefatoBO = new ArtefatoBO();
		artefatoBO.cadastrarArtefatoBO(artefatoVO);
	}

	public void excluirArtefatoController(ArtefatoVO artefatoVO) {
		ArtefatoBO artefatoBO = new ArtefatoBO();
		artefatoBO.excluirArtefatoBO(artefatoVO);
	}

	public void atualizarArtefatoController(ArtefatoVO artefatoVO) {
		ArtefatoBO artefatoBO = new ArtefatoBO();
		artefatoBO.atualizarArtefatoBO(artefatoVO);
	}

	public ArrayList<ArtefatoVO> consultarTodosArtefatosController() {
		ArtefatoBO artefatoBO = new ArtefatoBO();
		return artefatoBO.consultarArtefatosBO();
	}

	public ArtefatoVO consultarArtefatoController(ArtefatoVO artefatoVO) {
		ArtefatoBO artefatoBO = new ArtefatoBO();
		return artefatoBO.consultarArtefatoBO(artefatoVO);
	}

}
