package ifrn.nc.moxa.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricadeConexao {

	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/moxa";
	private String usuario = "root";
	private String senha = "";

	private static FabricadeConexao fabricadeconexao = null;

	private FabricadeConexao() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, usuario, senha);
		return conn;

	}

	public static FabricadeConexao getInstance() {
		if (fabricadeconexao == null) {
			fabricadeconexao = new FabricadeConexao();
		}
		return fabricadeconexao;

	}

	public static void main(String[] args) throws SQLException {
		FabricadeConexao.getInstance().getConnection();
		System.out.println("Funcionou!");
	}
}
