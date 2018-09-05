package controller;


import java.util.ArrayList;

import model.bo.ColecaoBO;
import model.vo.ColecaoVO;

public class ControladoraColecao {

	public void cadastrarColecaoController(ColecaoVO colecaoVO) {
		ColecaoBO colecaoBO = new ColecaoBO();
		colecaoBO.cadastrarColecaoBO(colecaoVO);
	}

	public void excluirColecaoController(ColecaoVO colecaoVO) {
		ColecaoBO colecaoBO = new ColecaoBO();
		colecaoBO.excluirColecaoBO(colecaoVO);
	}

	public void atualizarColecaoController(ColecaoVO colecaoVO) {
		ColecaoBO colecaoBO = new ColecaoBO();
		colecaoBO.atualizarColecaoBO(colecaoVO);
	}

	public ArrayList<ColecaoVO> consultarTodasColecoesController() {
		ColecaoBO colecaoBO = new ColecaoBO();
		return colecaoBO.consultarColecoesBO();
	}

	public ColecaoVO consultarColecaoController(ColecaoVO colecaoVO) {
		ColecaoBO colecaoBO = new ColecaoBO();
		return colecaoBO.consultarColecaoBO(colecaoVO);
	}

}
