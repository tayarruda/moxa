package ifrn.nc.moxa.persistencia;
import ifrn.nc.moxa.negocio.Requisicao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequisicaoDAO {
	
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		public RequisicaoDAO() {
			super();
		}

		private Connection getConnection() throws SQLException {
			Connection conn;
			conn = FabricadeConexao.getInstance().getConnection();
			return conn;
		}

		public int add(Requisicao requisicao) {
			try {
				String queryString = "INSERT into produto(dataR) values (?)";
				connection = getConnection();
				ps = connection.prepareStatement(queryString);
				
				Date dataSQL = new Date(requisicao.getDataR().getTime());
				ps.setDate(1, dataSQL);
				
				return ps.executeUpdate(); //realizar a atualização no bd, aqui atualização = insert
		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				finishConnection();
			}
			return 0;
		}

		private void finishConnection() {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


