package ifrn.nc.moxa.persistencia;

import ifrn.nc.moxa.negocio.Entrada;
import ifrn.nc.moxa.negocio.Produto;
import ifrn.nc.moxa.negocio.Servidor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public EntradaDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn = FabricadeConexao.getInstance().getConnection();
		return conn;
	}

	public int add(Entrada entrada) {

		int retorno = 0;
		try {
			String queryString = "Insert into entrada (data_entrada,quantidade,servidor_id) values(?,?,?)";
			connection = getConnection();
			ps = connection.prepareStatement(queryString);

			Date dataDeRegistro = new Date(entrada.getDataDeRegistro()
					.getTime());
			ps.setDate(1, dataDeRegistro);

			ps.setInt(3, entrada.getRegistrador().getId());
			//ps.setInt(3, entrada.getProduto().getId());
			ps.setInt(2, entrada.getQuantidade());

			retorno = ps.executeUpdate();
		} catch (SQLException e) { // capturar
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return retorno;
	}

	ServidorDAO servidorDAO = new ServidorDAO();
	ProdutoDAO produtoDAO = new ProdutoDAO();



	public Entrada buscarPorData(Entrada entrada) {

		try {
			connection = getConnection();
			ps = connection.prepareStatement("Select id, data_entrada,quantidade,servidor_id, produto_id from entrada where data_entrada = ?");
			Date data = new Date(entrada.getDataDeRegistro().getTime());
			ps.setDate(1, data);
			rs = ps.executeQuery();

			while (rs.next()) {

				entrada.setId(rs.getInt(1));
				entrada.setDataDeRegistro(rs.getDate(2));
				entrada.setQuantidade(rs.getInt(3));

				Servidor ser = new Servidor();
				ser.setId(rs.getInt(4));
				ser = servidorDAO.buscarPorID(ser);
						
					

				Produto pro = new Produto();
				pro.setId(rs.getInt(5));
				pro = produtoDAO.buscarPorID(pro);

				entrada.setRegistrador(ser);
				entrada.setProduto(pro);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}

		return entrada;

	}

	
	public Entrada buscarPorId(Entrada entrada) {

		try {
			connection = getConnection();
			ps = connection
					.prepareStatement("Select id,data_entrada,quantidade, servidor_id, produto_id from entrada where id = ?");
			ps.setInt(1, entrada.getId());

			rs = ps.executeQuery();

			if (rs.next()) {

				entrada.setId(rs.getInt(1));
				entrada.setDataDeRegistro(rs.getDate(2));
				entrada.setQuantidade(rs.getInt(3));

				Servidor ser = new Servidor();
				ser.setId(rs.getInt(4));
				ser = servidorDAO.buscarPorID(ser);

				Produto pro = new Produto();
				pro.setId(rs.getInt(5));
				pro = produtoDAO.buscarPorID(pro);

				entrada.setRegistrador(ser);
				entrada.setProduto(pro);

				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}

		return entrada;

	}

	public List<Entrada> listarTodas() {

		List<Entrada> entradas = new ArrayList<>();

		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM entrada");
			rs = ps.executeQuery();

			while (rs.next()) {
				Entrada entrada = new Entrada();
				
				Servidor ser = new Servidor();
				
				
				
				entrada.setId(rs.getInt(1));
				entrada.setDataDeRegistro(rs.getDate(2));
				entrada.setQuantidade(rs.getInt(3));
				entrada.setRegistrador(ser);
			
				ser.setId(rs.getInt(4));
				(new ServidorDAO()).buscarPorID(ser);
				
			
				
				
				

				entradas.add(entrada);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}

		return entradas;
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
