package model.vo;


public class ColecaoVO {

	private int idColecao;
	private int idColecionador;
	private int idArtefato;

	public ColecaoVO(int idColecao, int idColecionador, int idArtefato) {
		super();
		this.idColecao = idColecao;
		this.idColecionador = idColecionador;
		this.idArtefato = idArtefato;
	}

	public ColecaoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdColecao() {
		return idColecao;
	}

	public void setIdColecao(int idColecao) {
		this.idColecao = idColecao;
	}

	public int getIdColecionador() {
		return idColecionador;
	}

	public void setIdColecionador(int idColecionador) {
		this.idColecionador = idColecionador;
	}

	public int getIdArtefato() {
		return idArtefato;
	}

	public void setIdArtefato(int idArtefato) {
		this.idArtefato = idArtefato;
	}

	public void imprimir() {
		System.out.printf("%3d %-3s %-3s \n", 
				this.getIdColecao(), 
				this.getIdColecionador(),
				this.getIdArtefato());
	}

}