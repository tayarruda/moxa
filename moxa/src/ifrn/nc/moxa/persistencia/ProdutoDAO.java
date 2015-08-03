package ifrn.nc.moxa.persistencia;

import ifrn.nc.moxa.negocio.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ProdutoDAO() {
		super();
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = FabricadeConexao.getInstance().getConnection();
		return conn;
	}

	public int add(Produto produto) {
		int resultado = 0;
		try {
			String queryString = "INSERT into produto(nome,categoria,preco,fornecedor,quantidade) values (?,?,?,?,?)";
			connection = getConnection();
			ps = connection.prepareStatement(queryString);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getCategoria());
			ps.setDouble(3, produto.getPreco());
			ps.setString(4, produto.getFornecedor());
			ps.setInt(5, produto.getQuantidade());
			return ps.executeUpdate(); // realizar a atualização no bd, aqui
										// atualização = insert

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return resultado;
	}

	public Produto buscarPorID(Produto produto) {

		try {
			connection = getConnection();
			ps = connection
					.prepareStatement("SELECT id,nome,quantidade,preco,fornecedor,categoria FROM produto where id=?");
			ps.setInt(1, produto.getId());
			rs = ps.executeQuery();

			if (rs.next()) {

				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setQuantidade(rs.getInt(3));
				produto.setPreco(rs.getDouble(4));
				produto.setFornecedor(rs.getString(5));
				produto.setCategoria(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}

		return produto;

	}

	public List<Produto> listarTodos() {

		List<Produto> produtos = new ArrayList<>();

		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM produto");
			rs = ps.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setCategoria(rs.getString(3));
				produto.setPreco(rs.getDouble(4));
				produto.setFornecedor(rs.getString(5));
				produto.setQuantidade(rs.getInt(6));

				produtos.add(produto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}

		return produtos;
	}

	public int atualizar(Produto produto) {
		int resultado = 0;
		try {
			String sql = "UPDATE  produto SET nome= ? , categoria = ?, preco = ? , "
					+ " fornecedor = ? , quantidade = ? WHERE id = ? ";
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getCategoria());
			ps.setDouble(3, produto.getPreco());
			ps.setString(4, produto.getFornecedor());
			ps.setInt(5, produto.getQuantidade());
			ps.setInt(6, produto.getId());
			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return resultado;
	}

	public int deletarPorID(Produto produto) {
		int resultado = 0;
		try {
			String sql = " DELETE FROM  produto  WHERE id = ?";
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, produto.getId());
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
