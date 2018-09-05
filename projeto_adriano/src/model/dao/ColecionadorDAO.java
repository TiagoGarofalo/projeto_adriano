package model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.bo.ColecionadorBO;
import model.vo.ColecionadorVO;

public class ColecionadorDAO extends ColecionadorBO {

	public int CadastrarColecionadorDAO(ColecionadorVO colecionadorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO colecionador (nome, " + "cpf, telefone, email) VALUES ('" + colecionadorVO.getNome()
				+ "', '" + colecionadorVO.getCpf() + "', '" + colecionadorVO.getTelefone() + "', '"
				+ colecionadorVO.getEmail() + "')";
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

	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM colecionador " + "WHERE cpf like '" + cpf + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que " + "verifica existencia de colecionador por CPF.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean existeRegistroPorIdColecionador(int idColecionador) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM colecionador " + "WHERE idcolecionador like '" + idColecionador + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que " + "verifica existencia de colecionador por ID.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarColecionadorDAO(ColecionadorVO colecionadorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "UPDATE colecionador SET nome = '" + colecionadorVO.getNome() + "', cpf = '"	+ colecionadorVO.getCpf() 
		+ "', telefone = '" + colecionadorVO.getTelefone() + "', email = '" + colecionadorVO.getEmail() 
		+ "' WHERE idcolecionador = " + colecionadorVO.getIdColecionador();

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

	public int excluirColecionadorDAO(ColecionadorVO colecionadorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM colecionador " + "WHERE idcolecionador = " + colecionadorVO.getIdColecionador();
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Erro ao executar a query " + "de exclusão do colecionador.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;

	}

	public ArrayList<ColecionadorVO> consultarTodosColecionadoresDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public ColecionadorVO consultarColecionadorDAO(ColecionadorVO colecionadorVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
