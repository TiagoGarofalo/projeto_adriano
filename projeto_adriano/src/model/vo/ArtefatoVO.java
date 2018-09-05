package model.vo;


public class ArtefatoVO {

	private int idArtefato;
	private String nome;
	private int ano;
	private double valor;

	public ArtefatoVO(int idArtefato, String nome, int ano, double valor) {
		super();
		this.idArtefato = idArtefato;
		this.nome = nome;
		this.ano = ano;
		this.valor = valor;
	}

	public ArtefatoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdArtefato() {
		return idArtefato;
	}

	public void setIdArtefato(int idArtefato) {
		this.idArtefato = idArtefato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void imprimir() {
		System.out.printf("%3d %-20s %-4s %-12s \n",
				this.getIdArtefato(),
				this.getNome(),
				this.getAno(),
				this.getValor());
	}
	
}
