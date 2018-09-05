package model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.bo.ColecaoBO;
import model.vo.ColecaoVO;

public class ColecaoDAO extends ColecaoBO{

	public boolean existeRegistroPorIdColecao(int idColecao) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM colecao " + "WHERE idcolecao like '" + idColecao + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que " + "verifica existencia de colecao por ID.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;

	}

	public int CadastrarColecaoDAO(ColecaoVO colecaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO colecao (idColecao, " + "idColecionador, idArtefato) VALUES ("
				+ colecaoVO.getIdColecao() + ", " + colecaoVO.getIdColecionador() + ", " + colecaoVO.getIdArtefato()
				+ ")";
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

	public int atualizarColecaoDAO(ColecaoVO colecaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "UPDATE colecao SET idcolecao = " + colecaoVO.getIdColecao() + ", idcolecionador = " 
		+ colecaoVO.getIdColecionador() + ", idartefato = " + colecaoVO.getIdArtefato() 
		+ " WHERE idcolecao = " + colecaoVO.getIdColecao();

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

	public int excluirColecaoDAO(ColecaoVO colecaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM colecao " + "WHERE idcolecao = " + colecaoVO.getIdColecao();
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Erro ao executar a query " + "de exclusão da colecao.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;

	}

	public ArrayList<ColecaoVO> consultarTodasColecoesDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public ColecaoVO consultarColecaoDAO(ColecaoVO colecaoVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
