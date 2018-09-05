package model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.bo.ArtefatoBO;
import model.vo.ArtefatoVO;

public class ArtefatoDAO extends ArtefatoBO{

	public boolean existeRegistroPorIdArtefato(int idArtefato) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM artefato " + "WHERE idartefato like '" + idArtefato + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
			return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que " + "verifica existencia de artefato por ID.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;

	}

	public int CadastrarArtefatoDAO(ArtefatoVO artefatoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO artefato (nome, ano, valor) VALUES ('" + artefatoVO.getNome() + "', " + artefatoVO.getAno() + ", " + artefatoVO.getValor() + ")";
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarArtefatoDAO(ArtefatoVO artefatoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "UPDATE artefato SET nome = '" + artefatoVO.getNome() + "', ano = " + artefatoVO.getAno()
				+ ", valor = " + artefatoVO.getValor() + " WHERE idartefato = " + artefatoVO.getIdArtefato();

		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;

	}

	public int excluirArtefatoDAO(ArtefatoVO artefatoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM artefato " + "WHERE idartefato = " + artefatoVO.getIdArtefato();
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Erro ao executar a query " + "de exclusão do artefato.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<ArtefatoVO> consultarTodosArtefatosDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArtefatoVO consultarArtefatoDAO(ArtefatoVO artefatoVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
