package ifrn.nc.moxa.persistencia;

import ifrn.nc.moxa.negocio.Servidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServidorDAO {

	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ServidorDAO() {
		super();
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = FabricadeConexao.getInstance().getConnection();
		return conn;
	}

	public int add(Servidor servidor) {
		int resultado = 0;
		try {
			String sql = "INSERT into servidor(nome,matricula,classificacao,senha) values (?,?,?,?)";
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, servidor.getNome());
			ps.setString(2, servidor.getMatricula());
			ps.setString(3, servidor.getClassificacao());
			ps.setString(4, servidor.getSenha());
			resultado = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return resultado;
	}
	
	public Servidor buscarPorID(Servidor servidor ){
		
		try{
			connection = getConnection();
			ps = connection.prepareStatement("SELECT id,nome,matricula,classificacao FROM servidor where id=?");
			ps.setInt(1, servidor.getId());
			rs = ps.executeQuery();
			
			if(rs.next()){
			
				servidor.setId(rs.getInt(1));
				servidor.setNome(rs.getString(2));
				servidor.setMatricula(rs.getString(3));
				servidor.setClassificacao(rs.getString(4));
			}
			
			
		}catch(SQLException e ){
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		
		return servidor;
		
		
	}

	public List<Servidor> listarTodos() {

		List<Servidor> servidores = new ArrayList<>();

		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM servidor");
			rs = ps.executeQuery();

			while (rs.next()) {

				Servidor servidor = new Servidor();
				servidor.setId(rs.getInt(1));
				servidor.setNome(rs.getString(2));
				servidor.setMatricula(rs.getString(3));
				servidor.setClassificacao(rs.getString(4));
			

				// TODO UM Servidor tem varias Entradas
				
				servidores.add(servidor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}

		return servidores;
	}

	public int atualizar(Servidor servidor) {
		int resultado = 0;
		try {
			String sql = "UPDATE  servidor SET nome= ? , matricula = ?, classificacao = ? where id = ? ";
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, servidor.getNome());
			ps.setString(2, servidor.getMatricula());
			ps.setString(3, servidor.getClassificacao());
			ps.setInt(4, servidor.getId());
			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return resultado;
	}

	public int deletarPorID(Servidor servidor) {
		int resultado = 0;
		try {
			String sql = " DELETE FROM  servidor WHERE id = ?";
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, servidor.getId());
			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return resultado;
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
